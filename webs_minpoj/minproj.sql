
/* Drop Triggers */

DROP TRIGGER TRI_wcomment_comment_no;
DROP TRIGGER TRI_wreply_reply_no;



/* Drop Tables */

DROP TABLE wreply CASCADE CONSTRAINTS;
DROP TABLE wcomment CASCADE CONSTRAINTS;
DROP TABLE wuser CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_wcomment_comment_no;
DROP SEQUENCE SEQ_wreply_reply_no;




/* Create Sequences */

CREATE SEQUENCE SEQ_wcomment_comment_no INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_wreply_reply_no INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE wcomment
(
	comment_no number NOT NULL,
	user_id varchar2(10) NOT NULL,
	reg_date date DEFAULT sysdate NOT NULL,
	comment_content varchar2(500) NOT NULL,
	PRIMARY KEY (comment_no)
);


CREATE TABLE wreply
(
	reply_no number NOT NULL,
	user_id varchar2(10) NOT NULL,
	comment_no number NOT NULL,
	reply_content varchar2(300) NOT NULL,
	reg_date date DEFAULT sysdate NOT NULL,
	PRIMARY KEY (reply_no)
);


CREATE TABLE wuser
(
	user_id varchar2(10) NOT NULL,
	user_name varchar2(10) NOT NULL,
	user_pwd varchar2(10) NOT NULL,
	user_email varchar2(30),
	user_phone varchar2(20),
	PRIMARY KEY (user_id)
);



/* Create Foreign Keys */

ALTER TABLE wreply
	ADD FOREIGN KEY (comment_no)
	REFERENCES wcomment (comment_no)
;


ALTER TABLE wcomment
	ADD FOREIGN KEY (user_id)
	REFERENCES wuser (user_id)
;


ALTER TABLE wreply
	ADD FOREIGN KEY (user_id)
	REFERENCES wuser (user_id)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_wcomment_comment_no BEFORE INSERT ON wcomment
FOR EACH ROW
BEGIN
	SELECT SEQ_wcomment_comment_no.nextval
	INTO :new.comment_no
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_wreply_reply_no BEFORE INSERT ON wreply
FOR EACH ROW
BEGIN
	SELECT SEQ_wreply_reply_no.nextval
	INTO :new.reply_no
	FROM dual;
END;

/





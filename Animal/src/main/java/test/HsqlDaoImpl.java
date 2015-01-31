package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import comment.IDao;

@Repository
public class HsqlDaoImpl implements IDao {

	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(HsqlDaoImpl.class);
	}
	
	public HsqlDaoImpl() {
		// TODO Auto-generated constructor stub
		logger.trace("hsql dao impl 생성자 호출");
	}
	
	@Override
	public void write() {
		// TODO Auto-generated method stub
		logger.trace("hsql 이용해 출력");
	}

}

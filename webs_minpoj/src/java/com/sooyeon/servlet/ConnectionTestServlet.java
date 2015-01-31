package com.sooyeon.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servlet implementation class ConnectionTestServlet
 */
@WebServlet("/ConnectionTestServlet")
public class ConnectionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static final Logger logger = LoggerFactory
			.getLogger(ConnectionTestServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		connectionTest();
		myBatisTest();
	}
	
	private void connectionTest() {
		try {
			// TODO Auto-generated method stub
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myOracle");
			Connection conn = ds.getConnection();
			logger.trace("접속확인"+conn);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void myBatisTest() {
		// classpath
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("sessionfactory 생성 실패", e);
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		logger.trace("sqlSessionFactory: "+ sqlSessionFactory);
	}

}

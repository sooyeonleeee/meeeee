package com.sooyeon.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sooyeon.dao.UserDaoImpl;
import com.sooyeon.service.UserService;

/**
 * Application Lifecycle Listener implementation class ContextLoaderListener
 *
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
	
	static final Logger LOG = LoggerFactory
			.getLogger(ContextLoaderListener.class);
    /**
     * Default constructor. 
     */
    public ContextLoaderListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	String mybatisconfig = sce.getServletContext().getInitParameter("mybatis-config");
    	LOG.trace(mybatisconfig);
    	DBUtil.getUtil().initFactory(mybatisconfig);
    	UserDaoImpl.getInstance();
    	UserService.getService();
    	
    	System.out.println(mybatisconfig);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}

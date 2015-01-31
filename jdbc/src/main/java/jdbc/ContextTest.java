package jdbc;

import javax.sql.DataSource;

import jdbc.dao.DepartmentDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ContextTest {
	
	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(ContextTest.class);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("application_config.xml");
		logger.trace("수업: "+ctx);
		DataSource source = ctx.getBean(DataSource.class);
		logger.trace("datasource 확인: "+source);
		
		
		JdbcTemplate temp = ctx.getBean(JdbcTemplate.class);
		logger.trace("jdbc template 확인: "+temp);
		
		DepartmentDao dao = ctx.getBean(DepartmentDao.class);
		logger.trace("부서의 개수는: "+dao.getDepartmentCount());
	}

}

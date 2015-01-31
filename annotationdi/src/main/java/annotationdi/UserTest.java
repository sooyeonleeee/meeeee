package annotationdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserTest {
	
	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(UserTest.class);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("annotationdi/user_config.xml");
		logger.trace("수업: "+ctx);
		
		User user = ctx.getBean(User.class);
		logger.trace("수업: "+user);
		//user.myPrinter.print();
		String [] beans = ctx.getBeanNamesForType(Object.class);
		for(String bean : beans) {
			logger.trace(bean);
		}
		
		
	}
}

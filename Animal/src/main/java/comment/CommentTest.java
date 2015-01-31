package comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CommentTest {
	
	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(CommentTest.class);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("comment_config.xml");
		logger.trace("수업: "+ctx);
		
		String [] beans = ctx.getBeanNamesForType(Object.class);
		for (String bean:beans) {
			logger.trace(bean);
		}
		
		IService service = ctx.getBean(IService.class);
		service.write();
	}
	
}

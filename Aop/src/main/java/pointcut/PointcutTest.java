package pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PointcutTest {
	
	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(PointcutTest.class);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("target_config.xml");
		TargetInterface t = ctx.getBean(TargetInterface.class);
		logger.trace(""+t);
		
		Bean bean = ctx.getBean(Bean.class);
		logger.trace(""+bean);
		bean.method();
		
		t.hello();
		t.hello("문자열 입력받는 hello 함수");
		logger.trace("minus함수 결과: "+t.minus(5, 3));
		logger.trace("plus함수 결과: "+t.plus(5, 3));
		
		
	}
}

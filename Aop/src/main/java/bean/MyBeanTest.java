package bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import pointcut.Bean;
import pointcut.TargetInterface;

public class MyBeanTest {

	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(MyBeanTest.class);
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"bean_config.xml");
		//logger.trace("수업: " + ctx);

		Tiger tiger = ctx.getBean(Tiger.class);
		//logger.trace("수업: " + tiger);

		IBean bean = ctx.getBean(IBean.class);
		//logger.trace("수업: " + bean);

		logger.trace("tester: " + bean.callMe("why?"));
		logger.trace("tester: " + bean.showMe("your dream."));
		// MyBean 클래스의 showMe함수 안에 1/0으로 exception 발생시킴
		// exception이 발생하더라도 aop에 있는 before, after이 모두 실행됨.

		//logger.trace(bean.getClass().getName());
		//logger.trace(tiger.getClass().getName());
		
		

	}
}

package pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class Target implements TargetInterface {

	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(Target.class);
	}
	
	@Override
	public void hello() {
		// TODO Auto-generated method stub
		logger.trace("hello() 호출");
	}

	@Override
	public void hello(String a) {
		// TODO Auto-generated method stub
		logger.trace("hello(String a) 호출");

	}

	@Override
	public int minus(int a, int b) {
		// TODO Auto-generated method stub
		logger.trace("minus(int a, int b) 호출");
		return a-b;
	}

	@Override
	public int plus(int a, int b) {
		// TODO Auto-generated method stub
		logger.trace("plus(int a, int b) 호출");
		return a+b;
	}

}

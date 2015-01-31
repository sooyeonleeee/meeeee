package pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class PointCutAspect {
	
	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(PointCutAspect.class);
	}
	
	@Before("execution(* *(..))")
	public void beforeMethod() {
		logger.trace("수업: before method call..");
	}
	
	
}

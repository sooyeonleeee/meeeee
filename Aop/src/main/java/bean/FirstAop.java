package bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class FirstAop {
	
	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(FirstAop.class);
	}
	
	@Before("execution(* *Me(..))")
	public void enterlog(JoinPoint jp) {
		logger.trace("method 시작 - "+jp.getSignature());
	}
	@After("execution(* *Me(..))")
	public void enter(JoinPoint jp) {
		logger.trace("method 종료 - "+jp.getSignature());
	}
	@AfterReturning(value="execution(* *Me(..))", returning="str")
	public void changeReturnValue(JoinPoint jp, StringBuffer str) {
		String str1 = str.toString();
		logger.trace(str1.toUpperCase());
	}
	@AfterThrowing(value="execution(* *Me(..))", throwing="e")
	public void handleException(JoinPoint jp, Exception e) {
		logger.trace("예외가 발생 - "+e);
	}
	//around에서는 exception 조작, parameter 조작, result 조작 모두 가능
	@Around("execution(* *Me(..))")
	public Object around(ProceedingJoinPoint pjp) {
		Object result = null;
		logger.trace("method 시작: "+pjp.getSignature());
		long start = System.currentTimeMillis();
		try {
			Object[] args = pjp.getArgs();
			args[0] = args[0].toString().toUpperCase();
			result = pjp.proceed(args);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.trace("method 종료: "+(System.currentTimeMillis()-start));
		return result;
	}
}

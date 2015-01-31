package pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Bean {
	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(Bean.class);
	}
	
	public void method() {
		logger.trace("method() 호출");
	}
}

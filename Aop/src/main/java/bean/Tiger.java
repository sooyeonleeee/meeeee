package bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Tiger {

	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(Tiger.class);
	}

	@Value("호랑이")
	String name;
	
	public Tiger(String name) {
		this.name = name;
	}
	
	public Tiger() {}

	public StringBuffer callMe(String data) {
		logger.trace(data);
		return new StringBuffer(data);
	}

	public StringBuffer showMe(String data) {
		logger.trace(data);
		return new StringBuffer(data);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}
	
	
}

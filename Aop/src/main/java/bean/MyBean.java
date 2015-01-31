package bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements IBean {

	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(MyBean.class);
	}

	@Value("MYBEAN")
	String name;
	@Autowired
	Tiger tiger;
	
	public MyBean() {}
	
	public MyBean(String name, Tiger tiger) {
		this.name = name;
		this.tiger = tiger;
	}

	@Override
	public StringBuffer callMe(String data) {
		// TODO Auto-generated method stub
		logger.trace(data);
		return new StringBuffer(data);
	}

	@Override
	public StringBuffer showMe(String data) {
		// TODO Auto-generated method stub
		logger.trace(data);
		//int i = 1/0;
		return new StringBuffer(data);
	}

	@Override
	public String toString() {
		return "MyBean [name=" + name + ", tiger=" + tiger + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tiger getTiger() {
		return tiger;
	}

	public void setTiger(Tiger tiger) {
		this.tiger = tiger;
	}
	
	

}

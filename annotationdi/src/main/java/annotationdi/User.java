package annotationdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class User {
	
	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(User.class);
	}
	
	@Value("sooyeon")
	String name;
	@Value("10")
	int age;
	@Value("서울")
	String addr;
	
	@Autowired
	//@Qualifier("ink")
	@Qualifier("lazer")
	IPrinter myPrinter;
	
	public User(IPrinter printer) {
		logger.trace("수업 생성자: "+printer);
		this.myPrinter = printer;
	}
	
	public User() {}
	
	public void setPrinter(IPrinter printer) {
		logger.trace("수업 메서드: "+printer);
		this.myPrinter = printer;
	}
	
	public User(String name, int age) {
		logger.trace("수업 생성자: "+name+", "+age);
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", addr=" + addr
				+ ", myPrinter=" + myPrinter + "]";
	}

	public IPrinter getMyPrinter() {
		return myPrinter;
	}

	public void setMyPrinter(IPrinter myPrinter) {
		this.myPrinter = myPrinter;
	}


	
}

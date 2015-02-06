package simple.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class DeptServiceImpl implements DeptService {

	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(DeptServiceImpl.class);
	}
	
	@Override
	public String serviceMessage() {
		logger.trace("service method 호출됨..");
		return "service method";
	}

}

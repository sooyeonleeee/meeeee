package jdbc.test;

import jdbc.entity.Department;
import jdbc.exception.ServiceFailException;
import jdbc.service.IService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ServiceTest {
	
	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(ServiceTest.class);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("application_config.xml");
		IService service = ctx.getBean(IService.class);
		//logger.trace("getDeptCntService 호출 결과 : "+service.getDeptCntService());
		//logger.trace("getDeptByIdNoMappingService(10) 호출 결과 : "+service.getDeptByIdNoMappingService(10));
		//logger.trace("getDeptCntByLocationIdService(1800) 호출 결과 : "+service.getDeptCntByLocationIdService(1800));
		//logger.trace("getDeptByLocationIdService(1800) 호출 결과 : "+service.getDeptByLocationIdService(1800));
		//logger.trace("getDeptByIdService(10) 호출 결과: "+service.getDeptByIdService(10));
		//logger.trace("getAllDeptService 호출 결과 : "+service.getAllDeptService());
		//logger.trace("getDeptByManagerIdService(999) 호출 결과 : "+service.getDeptByManagerIdService(999));
		//logger.trace("getDeptByIdWithEmpService(10) 호출 결과 : "+service.getDeptByIdWithEmpService(10));

		Department dept = new Department(999, "test", 100, 170);
		//logger.trace("insertDeptService() 호출 결과 : "+service.insertDeptService(dept));
		dept.setDepartmentName("test_update55");
		try {
			logger.trace("updateDeptService() 호출 결과 : "+service.updateDeptService(dept));
		} catch (ServiceFailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//logger.trace("deleteDeptService() 호출 결과 : "+service.deleteDeptService(999));
	}
}

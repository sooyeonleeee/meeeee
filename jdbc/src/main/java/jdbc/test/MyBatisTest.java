package jdbc.test;

import jdbc.entity.Department;
import jdbc.service.DepartmentService;
import jdbc.service.IService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyBatisTest {
	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(DepartmentService.class);
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"application_config.xml");
		IService service = ctx.getBean(IService.class);
		// logger.trace("수업: "+service.getDeptCntService());
		// logger.trace("수업: "+service.getDeptByIdNoMappingService(10));
		// logger.trace("수업: "+service.getDeptByIdService(10));
		// logger.trace("수업: "+service.getDeptCntByLocationIdService(1800));
		 //logger.trace("수업: "+service.getDeptByLocationIdService(1700));
		// logger.trace("수업: "+service.getAllDeptService());
		// logger.trace("수업: "+service.getDeptByManagerIdService(100));
		 logger.trace("수업: "+service.getDeptByIdWithEmpService(10));
		// Department dept = new Department(999, "test", 100, 170);
		// logger.trace("수업: " + service.insertDeptService(dept));
		// dept.setDepartmentName("test_update");
		// logger.trace("updateDeptService() 호출 결과 : "+service.updateDeptService(dept));
		// logger.trace("deleteDeptService() 호출 결과 : "+service.deleteDeptService(999));
	}

}

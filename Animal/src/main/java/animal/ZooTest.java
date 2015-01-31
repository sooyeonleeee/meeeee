package animal;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ZooTest{

	private final static Logger logger =  LoggerFactory.getLogger(ZooTest.class);;

	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"zoo_config.xml");
		logger.trace("수업: "+ctx);
		
		Zoo zoo = ctx.getBean(Zoo.class);
		logger.trace("수업: "+zoo);

		List<String> names=zoo.getNames();
		logger.trace("수업: "+names.getClass().getName());
		logger.trace("수업: "+names);
		
		Set<Animal> animals=zoo.getAnimals();
		logger.trace("수업: "+animals);
	}

}

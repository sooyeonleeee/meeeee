package run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import comment.IDao;
@Repository
public class OracleDaoImpl implements IDao {

	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(OracleDaoImpl.class);
	}
	
	@Override
	public void write() {
		// TODO Auto-generated method stub
		logger.trace("oracle 이용해 출력");

	}

}

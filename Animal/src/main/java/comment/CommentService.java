package comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class CommentService implements IService {

	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(CommentService.class);
	}
	@Autowired
	IDao dao;
	
	@Override
	public void write() {
		// TODO Auto-generated method stub
		dao.write();

	}

}

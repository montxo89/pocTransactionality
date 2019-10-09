package apaas.poc.microorch.facade;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import apaas.poc.microorch.model.UserIdMicroUserObject;

@Service
public class MicroUsersFacadeImpl extends AbstractFacade implements MicroUsersFacade {

	static Logger logger = Logger.getLogger(MicroUsersFacadeImpl.class.getName());

	@Override
	public UserIdMicroUserObject returnUser(UserIdMicroUserObject userIdMicroUserObject) {
		logger.info("MicroOrchController MicroUsersFacadeImpl entered");
		UserIdMicroUserObject id = new UserIdMicroUserObject();
		try {
			id = postForObject("http://localhost:8079/idUserService", userIdMicroUserObject,
					UserIdMicroUserObject.class);
		} catch (Exception e) {
			logger.info("MicroOrchController MicroUsersFacadeImpl error = " + e.getMessage() + e);
		}
		return id;
	}

}

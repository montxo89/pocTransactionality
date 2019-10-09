package apaas.poc.microusers.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import apaas.poc.microusers.model.UserIdMicroUserObject;

@Service
public class UserServiceImpl implements UserService {

	static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

	@Override
	public UserIdMicroUserObject userName(UserIdMicroUserObject userIdMicroUserObject) {
		String user = "";
		String id = userIdMicroUserObject.getId();
		logger.info("MicroUserController UserName action processed");
		if (id.equalsIgnoreCase("id")) {
			user = "NoUserDetected";
		} else {
			user = id;
		}
		userIdMicroUserObject.setId(user);
		logger.info("MicroUserController UserName retrieving item");
		return userIdMicroUserObject;
	}

}

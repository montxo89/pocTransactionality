package apaas.poc.microusers.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apaas.poc.microusers.model.UserIdMicroUserObject;
import apaas.poc.microusers.service.UserService;

/**
 * Controller for MicroUsers.
 * 
 * @author Accenture
 */
@RestController
public class MicroUserController {

	static Logger logger = Logger.getLogger(MicroUserController.class.getName());

	@Autowired
	private UserService userService;

	/**
	 * ENDPOINT idUserService.
	 * 
	 */
	@RequestMapping(value = "/idUserService", produces = { "application/json" }, method = RequestMethod.POST)
	public UserIdMicroUserObject userServiceIdEndPoint(@RequestBody UserIdMicroUserObject userIdMicroUserObject)
			throws Exception {
		logger.info("MicroOrchController /idUserService");
		return userService.userName(userIdMicroUserObject);
	}

}

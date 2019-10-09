package apaas.poc.microtrxmng.controller;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apaas.poc.microtrxmng.data.model.TrxDbModel;
import apaas.poc.microtrxmng.model.TokenTrxManager;
import apaas.poc.microtrxmng.modules.TrxDbControllerModule;
import apaas.poc.microtrxmng.service.TokenDealerService;
import io.swagger.annotations.ApiOperation;

/**
 * Controller for MicroTrxMngController.
 * 
 * @author Accenture
 */
@RestController
@RequestMapping(value = "/trxmng")
public class MicroTrxMngController {

	static Logger logger = Logger.getLogger(MicroTrxMngController.class.getName());

	@Autowired
	private TokenDealerService tokenDealerService;
	@Autowired
	private Queue queue;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private TrxDbControllerModule trxDbCtrl;

	/**
	 * ENDPOINT recoverToken.
	 * 
	 * @throws Exception User account not found.
	 */
	@RequestMapping(value = "/recoverToken/{userId}", produces = { "application/json" }, method = RequestMethod.POST)
	public TokenTrxManager tokenDealerService(@PathVariable("userId") String userId) throws Exception {
		logger.info("MicroTrxMngController /recoverToken");
		return tokenDealerService.returnToken(userId);
	}

	@GetMapping(value = "/message/{message}", produces = { "application/json" })
	public ResponseEntity<String> publish(@PathVariable("message") final String message) {
		jmsTemplate.convertAndSend(queue, message);
		logger.info(message + "sent to queue");
		return new ResponseEntity<String>("message correctly queued", HttpStatus.OK);
	}

	/**
	 * Endpoint for list all the trxs
	 * 
	 */
	@ApiOperation(value = "List all the trxs")
	@RequestMapping(value = "/listTrxs", produces = { "application/json" }, method = RequestMethod.GET)
	public ArrayList<TrxDbModel> listAllTrxs() {
		logger.info("MicroTrxs /listTrxs entered");
		return trxDbCtrl.listAllTrxs();
	}

	/**
	 * Endpoint look for a trx by trxId
	 * 
	 */
	@ApiOperation(value = "List a trx using the user id")
	@RequestMapping(value = "/listTrxTrxId", produces = { "application/json" }, method = RequestMethod.GET)
	public TrxDbModel listTrxByTrxId(@RequestBody String trxId) {
		logger.info("MicroTrxs /listTrxTrxId entered");
		return trxDbCtrl.listTrxByTrxId(trxId);
	}

	/**
	 * Endpoint add a trx
	 * 
	 */
	@ApiOperation(value = "Add a new trx")
	@RequestMapping(value = "/addTrx", produces = { "application/json" }, method = RequestMethod.POST)
	public boolean addLOan(@RequestBody TrxDbModel trx) {
		logger.info("MicroTrxs /addLOan entered");
		return trxDbCtrl.addTrx(trx);
	}

	/**
	 * Endpoint modify a trx
	 * 
	 */
	@ApiOperation(value = "Modify a trx")
	@RequestMapping(value = "/modifyTrx", produces = { "application/json" }, method = RequestMethod.POST)
	public boolean modifyLOan(@RequestBody TrxDbModel trx) {
		logger.info("MicroTrxs /modifyTrx entered");
		return trxDbCtrl.modifyTrx(trx);
	}

	/**
	 * Endpoint delete a trx
	 * 
	 */
	@ApiOperation(value = "Delete a trx")
	@RequestMapping(value = "/deleteTrx", produces = { "application/json" }, method = RequestMethod.POST)
	public boolean deleteLOan(@RequestBody TrxDbModel trx) {
		logger.info("MicroTrxs /deleteTrx entered");
		return trxDbCtrl.deleteTrx(trx);
	}

}

package apaas.poc.microtrxmng.modules;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import apaas.poc.microtrxmng.data.model.TrxDbModel;
import apaas.poc.microtrxmng.data.repository.MicroTrxRepositoryOk;

@Component
public class TrxDbControllerModule {

	@Autowired
	private MicroTrxRepositoryOk microTrxRepositoryOk;

	static Logger logger = Logger.getLogger(TrxDbControllerModule.class.getName());

	public ArrayList<TrxDbModel> listAllTrxs() {
		logger.info("microtrx TrxDbControllerModule listAllTrxs entered");
		return microTrxRepositoryOk.listAllTrxs();
	}

	public TrxDbModel listTrxByTrxId(String userId) {
		logger.info("microtrx TrxDbControllerModule show a loan entered");
		return microTrxRepositoryOk.showTrxById(userId);
	}

	public boolean addTrx(TrxDbModel loadDbModel) {
		logger.info("microtrx TrxDbControllerModule addTrx entered");
		return microTrxRepositoryOk.insertTrx(loadDbModel);
	}

	public boolean modifyTrx(TrxDbModel loadDbModel) {
		logger.info("microtrx TrxDbControllerModule modifyTrx entered");
		return microTrxRepositoryOk.modifyTrx(loadDbModel);
	}

	public boolean deleteTrx(TrxDbModel loadDbModel) {
		logger.info("microtrx TrxDbControllerModule deleteTrx entered");
		return microTrxRepositoryOk.deleteTrx(loadDbModel);
	}

}

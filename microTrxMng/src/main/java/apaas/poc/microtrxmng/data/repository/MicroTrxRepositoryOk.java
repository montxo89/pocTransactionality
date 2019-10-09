package apaas.poc.microtrxmng.data.repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apaas.poc.microtrxmng.data.model.TrxDbModel;

@Service
public class MicroTrxRepositoryOk {

	static Logger logger = Logger.getLogger(MicroTrxRepositoryOk.class.getName());

	@Autowired
	private TrxRepository trxRepository;

	public boolean insertTrx(TrxDbModel loanDbModel) {
		logger.info("microTrxMng MicroTrxRepositoryOk insertTrx entered");
		try {
			trxRepository.save(loanDbModel);
			return true;
		} catch (Exception e) {
			logger.info("microTrxMng MicroTrxRepositoryOk insertTrx error = " + e.getMessage() + e);
			return false;
		}
	}

	public boolean modifyTrx(TrxDbModel loanDbModel) {
		logger.info("microTrxMng MicroTrxRepositoryOk modifyTrx entered");
		try {
			trxRepository.save(loanDbModel);
			return true;
		} catch (Exception e) {
			logger.info("microTrxMng MicroTrxRepositoryOk modifyTrx error = " + e.getMessage() + e);
			return false;
		}
	}

	public boolean deleteTrx(TrxDbModel loanDbModel) {
		logger.info("microTrxMng MicroTrxRepositoryOk deleteTrx entered");
		try {
			trxRepository.delete(loanDbModel);
			return true;
		} catch (Exception e) {
			logger.info("microTrxMng MicroTrxRepositoryOk deleteTrx error = " + e.getMessage() + e);
			return false;
		}
	}

	public ArrayList<TrxDbModel> listAllTrxs() {
		try {
			return (ArrayList<TrxDbModel>) trxRepository.findAll();
		} catch (Exception e) {
			logger.info("microTrxMng MicroTrxRepositoryOk listAllTrxs error = " + e.getMessage() + e);
			return null;
		}
	}

	public TrxDbModel showTrxById(String id) {
		try {
			Optional<TrxDbModel> trxDbOpt = trxRepository.findById(id);
			return trxDbOpt.get();
		} catch (Exception e) {
			logger.info("microTrxMng MicroTrxRepositoryOk showTrxById error = " + e.getMessage() + e);
			return null;
		}
	}

}

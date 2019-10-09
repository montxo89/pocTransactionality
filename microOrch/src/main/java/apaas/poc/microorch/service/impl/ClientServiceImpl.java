package apaas.poc.microorch.service.impl;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import apaas.poc.microorch.service.ClientService;
import apaas.poc.microorch.service.dto.ClientDTO;

@Service
public class ClientServiceImpl implements ClientService {

	static Logger logger = Logger.getLogger(ClientServiceImpl.class.getName());

	@Override
	public ClientDTO updateClient(ClientDTO client) {
		// TODO Auto-generated method stub
		return null;
	}

}

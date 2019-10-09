package apaas.poc.microloans.queuelistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@EnableJms
public class ListenerQueue {
	
    private final Logger logger = LoggerFactory.getLogger(ListenerQueue.class);

    @JmsListener(destination = "test-queue")
	public void checkQueue(String message) {
        logger.info("Message received {} ", message);

	}
}

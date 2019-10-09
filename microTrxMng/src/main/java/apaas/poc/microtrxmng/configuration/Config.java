package apaas.poc.microtrxmng.configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.jms.Queue;

@Configuration
public class Config {
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("test-queue");
    }
}

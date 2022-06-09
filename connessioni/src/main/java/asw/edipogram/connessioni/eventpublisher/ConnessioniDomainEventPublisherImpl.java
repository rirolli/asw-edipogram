package asw.edipogram.connessioni.eventpublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import asw.edipogram.common.api.event.DomainEvent;
import asw.edipogram.connessioni.api.event.ConnessioniEventChannel;
import asw.edipogram.connessioni.domain.ConnessioniDomainEventPublisher;

import java.util.logging.Logger;

@Component
public class ConnessioniDomainEventPublisherImpl implements ConnessioniDomainEventPublisher{
    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = ConnessioniEventChannel.channel;

    private final Logger logger = Logger.getLogger(ConnessioniDomainEventPublisherImpl.class.toString()); 

    public void publish(DomainEvent event){
        logger.info("EVENT SEND: publish: " + event); 
        template.send(channel, event);
    }
    
}

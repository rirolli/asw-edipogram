package asw.edipogram.enigmi.eventpublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import asw.edipogram.common.api.event.DomainEvent;
import asw.edipogram.enigmi.api.event.EnigmiEventChannel;
import asw.edipogram.enigmi.domain.EnigmiDomainEventPublisher;

import java.util.logging.Logger;

@Component
public class EnigmiDomainEventPublisherImpl implements EnigmiDomainEventPublisher{
    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = EnigmiEventChannel.channel;

    private final Logger logger = Logger.getLogger(EnigmiDomainEventPublisherImpl.class.toString()); 

    public void publish(DomainEvent event){
        logger.info("EVENT SEND: EnigmiDomainEventPublisherImpl: " + event); 
        template.send(channel, event);
    }
    
}

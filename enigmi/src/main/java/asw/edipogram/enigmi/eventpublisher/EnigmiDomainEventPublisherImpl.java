package asw.edipogram.enigmi.eventpublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import asw.edipogram.common.api.event.DomainEvent;
import asw.edipogram.enigmi.api.event.EnigmiEventChannel;
import asw.edipogram.enigmi.domain.EnigmiDomainEventPublisher;

@Component
public class EnigmiDomainEventPublisherImpl implements EnigmiDomainEventPublisher{
    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = EnigmiEventChannel.channel;

    public void publish(DomainEvent event){
        template.send(channel, event);
    }
    
}

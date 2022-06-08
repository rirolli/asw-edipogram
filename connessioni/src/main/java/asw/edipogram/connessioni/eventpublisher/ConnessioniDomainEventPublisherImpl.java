package asw.edipogram.connessioni.eventpublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import asw.edipogram.common.api.event.DomainEvent;
import asw.edipogram.connessioni.api.event.ConnessioniEventChannel;
import asw.edipogram.connessioni.domain.ConnessioniDomainEventPublisher;

@Component
public class ConnessioniDomainEventPublisherImpl implements ConnessioniDomainEventPublisher{
    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = ConnessioniEventChannel.channel;

    public void publish(DomainEvent event){
        template.send(channel, event);
    }
    
}

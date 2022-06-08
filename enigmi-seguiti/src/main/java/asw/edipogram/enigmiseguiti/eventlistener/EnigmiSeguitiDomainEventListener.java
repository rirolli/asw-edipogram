package asw.edipogram.enigmiseguiti.eventlistener;

import asw.edipogram.enigmiseguiti.domain.EnigmiSeguitiService;
import asw.edipogram.connessioni.api.event.ConnessioniEventChannel;
import asw.edipogram.enigmi.api.event.EnigmiEventChannel;
import asw.edipogram.common.api.event.DomainEvent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.apache.kafka.clients.consumer.ConsumerRecord;



@Component 
public class EnigmiSeguitiDomainEventListener {

    @Autowired
    private EnigmiSeguitiService enigmiService;

	@KafkaListener(topics = {ConnessioniEventChannel.channel,
                             EnigmiEventChannel.channel})
    public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
        DomainEvent event = record.value();
		enigmiService.onEvent(event); 
    }
}

package asw.edipogram.enigmi.domain;

import asw.edipogram.common.api.event.DomainEvent;

public interface EnigmiDomainEventPublisher{
    public void publish(DomainEvent event);
}
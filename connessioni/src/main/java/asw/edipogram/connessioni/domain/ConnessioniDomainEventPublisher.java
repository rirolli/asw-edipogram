package asw.edipogram.connessioni.domain;

import asw.edipogram.common.api.event.DomainEvent;

public interface ConnessioniDomainEventPublisher {
    public void publish(DomainEvent event);
}

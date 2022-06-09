package asw.edipogram.connessioni.api.event;

import asw.edipogram.common.api.event.DomainEvent; 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnessioniCreatedEvent implements DomainEvent {

	private Long id; 
	private String utente; 
	private String tipo; 
	
}

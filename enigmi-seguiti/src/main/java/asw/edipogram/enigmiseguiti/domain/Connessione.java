package asw.edipogram.enigmiseguiti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*; 

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Connessione {

	@Id
	private Long id; 
	private String utente; 
	private String tipo;
	
}

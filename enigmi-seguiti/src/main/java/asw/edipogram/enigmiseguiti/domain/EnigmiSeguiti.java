package asw.edipogram.enigmiseguiti.domain;

import javax.persistence.*;

import lombok.*;

@Entity
@IdClass(EnigmiSeguitiId.class)
@Data @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnigmiSeguiti{

    @Id
    @EqualsAndHashCode.Include
    private Long idEnigma;
    @Id
    @EqualsAndHashCode.Include
    private String utente;
    private String autore;
    private String tipo;
    private String tipoSpecifico;
    private String titolo;
    private String[] testo;

}
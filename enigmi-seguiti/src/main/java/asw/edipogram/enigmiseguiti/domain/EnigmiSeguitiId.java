package asw.edipogram.enigmiseguiti.domain;

import java.io.Serializable;
import java.util.Objects;

import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
public class EnigmiSeguitiId implements Serializable{

    private Long idEnigma;
    private String utente;

}

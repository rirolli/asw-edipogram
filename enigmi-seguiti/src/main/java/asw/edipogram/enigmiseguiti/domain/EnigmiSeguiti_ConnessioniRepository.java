package asw.edipogram.enigmiseguiti.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*; 


public interface EnigmiSeguiti_ConnessioniRepository extends CrudRepository<Connessione, Long> {

    public Collection<Connessione> findByUtente(String utente);

    public Collection<Connessione> findByTipoIn(Collection<String> tipi);

}

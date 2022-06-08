package asw.edipogram.enigmiseguiti.domain;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface EnigmiSeguiti_EnigmaRepository extends CrudRepository<Enigma, Long> {
    
    public Collection<Enigma> findByTipoIn(Collection<String> tipi);

}

package asw.edipogram.enigmiseguiti.domain;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import asw.edipogram.common.api.event.DomainEvent;
import asw.edipogram.enigmi.api.event.EnigmiCreatedEvent;
import asw.edipogram.connessioni.api.event.ConnessioniCreatedEvent;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.*;

@Service 
public class EnigmiSeguitiService {

	@Autowired
	private EnigmiSeguiti_ConnessioniRepository connessioniRepository;

	@Autowired
	private EnigmiSeguiti_EnigmaRepository enigmaRepository;

	@Autowired
	private EnigmiSeguiti_EnigmiSeguitiRepository enigmiSeguitiRepository;

	private final Logger logger = Logger.getLogger(EnigmiSeguitiService.class.toString());


	public void onEvent(DomainEvent event){
		if (event.getClass().equals(ConnessioniCreatedEvent.class)) {
			ConnessioniCreatedEvent cce = (ConnessioniCreatedEvent) event;
			connessioneCreated(cce);
		} 
		else if(event.getClass().equals(EnigmiCreatedEvent.class)){
			EnigmiCreatedEvent ece = (EnigmiCreatedEvent) event;
			enigmaCreated(ece);
		}
		else{
			logger.info("UNKNOWN EVENT: " + event);			
		}
	}

	private void connessioneCreated(ConnessioniCreatedEvent event) {
		logger.info("CREATED CONNESSIONE: " + event.getTipo() + ':' + event.getUtente());

		Connessione connessione = new Connessione(event.getId(), event.getUtente(), event.getTipo());
		connessione = connessioniRepository.save(connessione);

		Collection<String> tipiSeguiti = new TreeSet<>();
		tipiSeguiti.add(event.getTipo());
		Collection<Enigma> enigmi = enigmaRepository.findByTipoIn(tipiSeguiti);
		for (Enigma e : enigmi){
			EnigmiSeguiti enigmaSeguito = new EnigmiSeguiti(e.getId(), event.getUtente(), e.getAutore(), e.getTipo(), e.getTipoSpecifico(), e.getTitolo(), e.getTesto());
			enigmaSeguito = enigmiSeguitiRepository.save(enigmaSeguito);
		}

	}

	private void enigmaCreated(EnigmiCreatedEvent event) {
		logger.info("CREATED ENIGMA: " + event.getTipo() + ':' + event.getAutore());
		Enigma enigma = new Enigma(event.getId(), event.getAutore(), event.getTipo(), event.getTipoSpecifico(), event.getTitolo(), event.getTesto());
		enigma = enigmaRepository.save(enigma);

		Collection<String> tipoEnigma = new TreeSet<>();
		tipoEnigma.add(event.getTipo());
		Collection<Connessione> connessioni = connessioniRepository.findByTipoIn(tipoEnigma);
		for (Connessione c : connessioni){
			EnigmiSeguiti enigmaSeguito = new EnigmiSeguiti(event.getId(), c.getUtente(), event.getAutore(), event.getTipo(), event.getTipoSpecifico(), event.getTitolo(), event.getTesto());
			enigmaSeguito = enigmiSeguitiRepository.save(enigmaSeguito);
		}
	}

	public Collection<EnigmiSeguiti> getEnigmiSeguiti (String utente){
		return enigmiSeguitiRepository.findByUtente(utente);
	}
}

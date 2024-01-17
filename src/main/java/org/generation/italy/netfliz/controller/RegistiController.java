package org.generation.italy.netfliz.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.generation.italy.netfliz.model.Regista;
import org.generation.italy.netfliz.repository.RegistiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Registi")
public class RegistiController {
	
	@Autowired
	RegistiRepository registiRepository;
	
	@GetMapping("/elenco")
	@ResponseBody
	public String elencoRegisti(@RequestParam(required = false) String ordinamento, 
								 @RequestParam(required = false) String nome, 
								 @RequestParam(required = false) String cognome,
								 @RequestParam(required = false) String nazionalità) throws Exception { //gestisce una richiesta get all'indirizzo localhost:8080/Prodotti/elenco?categoria=xxx
		
		List<Regista> elencoRegisti = null;
		
		if(nome==null && cognome==null && nazionalità==null)
            elencoRegisti = (ArrayList<Regista>) registiRepository.findAll();
        else if(nome!=null && cognome==null && nazionalità==null)
            elencoRegisti = (ArrayList<Regista>) registiRepository.findByNome(nome);
        else if(nome==null && cognome!=null && nazionalità==null)
            elencoRegisti = (ArrayList<Regista>) registiRepository.findByCognome(cognome);
        else if(nome==null && cognome==null && nazionalità!=null)
            elencoRegisti = (ArrayList<Regista>) registiRepository.findByNazionalita(nazionalità);

        else if(nome!=null && cognome!=null && nazionalità==null)
            elencoRegisti = (ArrayList<Regista>) 
            		registiRepository.findByNomeAndCognome(nome, cognome);
        else if(nome!=null && cognome==null && nazionalità!=null)
            elencoRegisti = (ArrayList<Regista>) registiRepository.findByNomeAndNazionalita(cognome, nazionalità);
        else if(nome==null && cognome!=null && nazionalità!=null)
            elencoRegisti = (ArrayList<Regista>) registiRepository.findByCognomeAndNazionalita(cognome, nazionalità);

        else if(nome==null && cognome==null && nazionalità==null)
            elencoRegisti = (ArrayList<Regista>) registiRepository.findByNomeAndCognomeAndNazionalita(nome, cognome, nazionalità);
        else
        	elencoRegisti = (ArrayList<Regista>) registiRepository.findAll();	
		
		if(ordinamento!=null) {
			if(ordinamento.equals("asc"))
				Collections.sort(elencoRegisti);
			else if(ordinamento.equals("desc"))
				Collections.sort(elencoRegisti, Collections.reverseOrder());
			else
				return "Ordinamento non valido.";
		}
		
		StringBuilder elenco = new StringBuilder();
		elenco.append("Numero di contenuti presenti: "+elencoRegisti.size());
		elenco.append("<br><br>");
		for(Regista registi:elencoRegisti)
			elenco.append(registi.toString()+"<br>");
		
		
		return elenco.toString();
	
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public String dettaglioRegista(@PathVariable Integer id) {
		Optional<Regista> optRegista = registiRepository.findById(id);
		if(optRegista.isPresent())
			return optRegista.get().toString();
		else
			return "Regista non disponibile.";
	}
}



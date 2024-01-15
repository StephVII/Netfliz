package org.generation.italy.netfliz.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import org.generation.italy.netfliz.model.Contenuto;
import org.generation.italy.netfliz.repository.ContenutiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Contenuti")
public class ContenutiController {
	
	@Autowired
	ContenutiRepository contenutiRepository;
	
	@GetMapping
	@ResponseBody
	public String index() {
		return "Benvenuto nella visualizzazione contenuti.";
	}
	
	@GetMapping("/Elenco")
	@ResponseBody
	public String elencoContenuti(
		@RequestParam(required = false) String titolo,
		@RequestParam(required = false) String genere,
		@RequestParam(required = false) String tipologia,
		@RequestParam(required = false) LocalDate annoProduzione,
		@RequestParam(required = false) LocalDate annoInizio,
		@RequestParam(required = false) LocalDate annoFine,
		@RequestParam(required = false) String ordinamento)
	{
		
		ArrayList<Contenuto> elencoContenuti = null;
		if(titolo==null && genere==null && tipologia==null && annoProduzione==null)
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findAll();
		else if(titolo!=null && genere==null && tipologia==null && annoProduzione==null)
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findByTitoloLike("%"+titolo+"%"); //Ricerca tramite parola chiave
		else if(titolo==null && genere!=null && tipologia==null && annoProduzione==null)
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findByGenere(genere);
		else if(titolo==null && genere==null && tipologia!=null && annoProduzione==null)
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findByTipologia(tipologia);
		else if(titolo==null && genere==null && tipologia==null && annoProduzione!=null)
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findByAnnoProduzione(annoProduzione);
		
		else if(titolo!=null && genere!=null && tipologia==null && annoProduzione==null)
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findByTitoloAndGenere(titolo, genere);
		else if(titolo!=null && genere==null && tipologia!=null && annoProduzione==null)
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findByTitoloAndTipologia(titolo, tipologia);
		else if(titolo!=null && genere==null && tipologia==null && annoProduzione!=null)
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findByTitoloAndAnnoProduzione(titolo, annoProduzione);
		
		else if(titolo==null && genere!=null && tipologia!=null && annoProduzione==null)
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findByGenereAndTipologia(genere, tipologia);
		else if(titolo==null && genere!=null && tipologia==null && annoProduzione!=null)
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findByGenereAndAnnoProduzione(genere, annoProduzione);
		
		else if(titolo==null && genere==null && tipologia!=null && annoProduzione!=null)
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findByTipologiaAndAnnoProduzione(tipologia, annoProduzione);
		
		else if(titolo!=null && genere!=null && tipologia!=null && annoProduzione!=null)
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findAll();
		
		else if(annoProduzione.getYear() >= annoInizio.getYear() && annoProduzione.getYear() <= annoFine.getYear())
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findByAnnoProduzioneBetween(annoInizio, annoFine); //ricerca tramite intervallo di anni
		else
			elencoContenuti = (ArrayList<Contenuto>) contenutiRepository.findAll();
			
		if(ordinamento!=null)
		{
			if(ordinamento.equals("asc"))
				Collections.sort(elencoContenuti);
			else if(ordinamento.equals("desc"))
				Collections.sort(elencoContenuti, Collections.reverseOrder());
			else
				return "Ordinamento non valido.";
		}
		
		StringBuilder elenco = new StringBuilder();
		elenco.append("Numero di contenuti presenti: "+elencoContenuti.size());
		elenco.append("<br><br>");
		for(Contenuto tuttiContenuti:elencoContenuti)
			elenco.append(tuttiContenuti.toString()+"<br>");
		
		
		return elenco.toString();
		
	}

}

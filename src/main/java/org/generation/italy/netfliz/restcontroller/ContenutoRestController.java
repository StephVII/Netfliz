package org.generation.italy.netfliz.restcontroller;

import java.util.List;

import org.generation.italy.netfliz.model.Contenuto;
import org.generation.italy.netfliz.repository.ContenutiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Contenuti")
public class ContenutoRestController {
	
	@Autowired
	ContenutiRepository contenutiRepository;
	
	@GetMapping("/elenco")
	public List<Contenuto> elencoContenuti() {
		return contenutiRepository.findAll();
	}

}

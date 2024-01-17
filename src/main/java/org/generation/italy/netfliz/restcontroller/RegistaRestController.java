package org.generation.italy.netfliz.restcontroller;

import java.util.List;

import org.generation.italy.netfliz.model.Regista;
import org.generation.italy.netfliz.repository.RegistiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Registi")
public class RegistaRestController {
		
	@Autowired
	RegistiRepository registiRepository;
	
	@GetMapping("/elenco")
	public List<Regista> elencoRegisti() {
		return registiRepository.findAll();
	}

}

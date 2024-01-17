package org.generation.italy.netfliz.repository;

import java.util.List;

import org.generation.italy.netfliz.model.Regista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistiRepository extends JpaRepository<Regista, Integer>{
	List<Regista> findByNome(String nome);
    List<Regista> findByCognome(String cognome);
    List<Regista> findByNazionalita(String nazionalita);

    List<Regista> findByNomeAndCognome(String nome, String cognome);
    List<Regista> findByNomeAndNazionalita(String nome, String nazionalita);
    List<Regista> findByCognomeAndNazionalita(String cognome, String nazionalita);

    List<Regista> findByNomeAndCognomeAndNazionalita(String nome, String cognome, String nazionalita);
}

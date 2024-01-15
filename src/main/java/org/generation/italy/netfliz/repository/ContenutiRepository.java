package org.generation.italy.netfliz.repository;
import java.time.LocalDate;
import java.util.List;

import org.generation.italy.netfliz.model.Contenuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenutiRepository extends JpaRepository<Contenuto, Integer>{
	//List<Contenuto> findByTitolo(String titolo);
	List<Contenuto> findByGenere(String genere);
	List<Contenuto> findByTipologia(String tipologia);
	List<Contenuto> findByAnnoProduzione(LocalDate annoProduzione);
	
	List<Contenuto> findByTitoloAndGenere(String titolo, String genere);
	List<Contenuto> findByTitoloAndTipologia(String titolo, String tipologia);
	List<Contenuto> findByTitoloAndAnnoProduzione(String titolo, LocalDate annoProduzione);
	
	List<Contenuto> findByGenereAndTipologia(String genere, String tipologia);
	List<Contenuto> findByGenereAndAnnoProduzione(String genere, LocalDate annoProduzione);
	
	List<Contenuto> findByTipologiaAndAnnoProduzione(String tipologia, LocalDate annoProduzione);
	
	List<Contenuto> findByTitoloLike(String titolo);

	List<Contenuto> findByAnnoProduzioneBetween(LocalDate annoInizio, LocalDate annoFine);

}

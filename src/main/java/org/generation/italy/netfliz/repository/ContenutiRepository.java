package org.generation.italy.netfliz.repository;
import java.util.List;

import org.generation.italy.netfliz.model.Contenuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenutiRepository extends JpaRepository<Contenuto, Integer>{
	//List<Contenuto> findByTitolo(String titolo);
	List<Contenuto> findByGenere(String genere);
	List<Contenuto> findByTipologia(String tipologia);
	List<Contenuto> findByAnnoProduzione(int annoProduzione);
	
	List<Contenuto> findByTitoloAndGenere(String titolo, String genere);
	List<Contenuto> findByTitoloAndTipologia(String titolo, String tipologia);
	List<Contenuto> findByTitoloAndAnnoProduzione(String titolo, int annoProduzione);
	
	List<Contenuto> findByGenereAndTipologia(String genere, String tipologia);
	List<Contenuto> findByGenereAndAnnoProduzione(String genere, int annoProduzione);
	
	List<Contenuto> findByTipologiaAndAnnoProduzione(String tipologia, int annoProduzione);
	
	List<Contenuto> findByTitoloLike(String titolo);

	List<Contenuto> findByAnnoProduzioneBetween(int annoInizio, int annoFine);

}

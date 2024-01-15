package org.generation.italy.netfliz.model;


import java.time.LocalDate;

import org.generation.italy.netfliz.model.Contenuto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contenuto implements Comparable<Contenuto>{
	
	@Id		//è una chiave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)			//l'ID verrà autogenerato ad ogni inserimento di riga
		private int id;
	
	@Column(nullable = false, length=50)
		private String titolo;
	
	@Column(nullable = false, length=30)
		private String tipologia;
	
	@Column(length=30)
		private String genere;
	
	@Column(nullable = false)
		private LocalDate annoProduzione;
	
	@Column(nullable = false)
		private int durata;


	public Contenuto() {		//necessario per Spring
		super();
	}

	public Contenuto(String titolo, String tipologia, String genere, LocalDate annoProduzione, int durata) {
		super();
		this.titolo = titolo;
		this.tipologia = tipologia;
		this.genere = genere;
		this.annoProduzione = annoProduzione;
		this.durata = durata;
	}

	public int getId() {
		return id;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getTipologia() {
		return tipologia;
	}

	public String getGenere() {
		return genere;
	}

	public LocalDate getAnnoProduzione() {
		return annoProduzione;
	}

	public int getDurata() {
		return durata;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", Titolo: " + titolo + ", Tipologia: " + tipologia + ", Genere: " + genere
				+ ", AnnoProduzione: " + annoProduzione + ", Durata: " + durata;
	}

	@Override
	public int compareTo(Contenuto c) {
		if(this.titolo.compareTo(c.getTitolo()) != 0) //se i titoli non sono uguali
			return this.titolo.compareTo(c.getTitolo());
		else if(this.annoProduzione.getYear() > c.annoProduzione.getYear()) //se i titoli sono uguali compara gli anni di produzione
				return 1;
		else if(this.annoProduzione.getYear() < c.annoProduzione.getYear())
			return 1;
		else 
			return 0;
	}
	
	
	
	
	
}

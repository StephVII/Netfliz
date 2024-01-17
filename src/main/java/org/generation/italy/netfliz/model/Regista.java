package org.generation.italy.netfliz.model;

import java.util.List;

import org.generation.italy.netfliz.model.Regista;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Regista implements Comparable<Regista>{
	@Id		//è una chiave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)			//l'ID verrà autogenerato ad ogni inserimento di riga
		private int registaId;
	
	@Column(nullable = false, length=30)
		private String nome;
	
	@Column(nullable = false, length=30)
		private String cognome;
	
	@Column(nullable = false, length=30)
		private String nazionalità;
	
	@OneToMany(mappedBy = "regista") //questo fornitore (one) è collegato a più prodotti (many)
	List<Contenuto> elencoContenuti; //i prodotti forniti da questo fornitore

	public Regista() {
		super();
	}

	public Regista(String nome, String cognome, String nazionalità) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.nazionalità = nazionalità;
	}

	
	
	public int getId() {
		return registaId;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNazionalità() {
		return nazionalità;
	}

	@Override
	public String toString() {
		return nome+" - Id: " + registaId + ", Nominativo: " + nome + cognome + ", Nazionalità: " + nazionalità;
	}

	@Override
	public int compareTo(Regista o) {
		if(this.nome.compareTo(o.getNome()) != 0)
			return this.nome.compareTo(o.getNome());
		else
			return this.cognome.compareTo(o.getCognome());
	}

	
	
	
	
	
}





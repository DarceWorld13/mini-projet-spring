package fr.topcollegues;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Collegues")
public class Collegues {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	@Column(name="nom")
	private String nom; 
	@Column(name="prenoms")
	private String prenoms; 
	@Column(name="score")
	private int score;
	public Collegues(int id, String nom, String prenoms, int score) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenoms = prenoms;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	} 
	
	
	
}

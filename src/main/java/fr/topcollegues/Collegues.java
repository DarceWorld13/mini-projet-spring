package fr.topcollegues;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.client.RestTemplate;

@Entity
@Table(name="Collegues")
public class Collegues {

	@Id
    private String matricule; 
    @Column(name = "nom")
    private String nom; 
    @Column(name = "prenoms")
    private String prenoms; 
    @Column(name = "email")
    private String email;
    @Column(name = "dateDeNaissance")
    private LocalDate dateDeNaissance;
    @Column(name = "photoUrl")
    private String photoUrl;
    @Column(name = "motDePasse")
    private String motDePasse;
    @Column(name="score")
    private int score = 0; 
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();
    
    
	public Collegues(String matricule, String nom, String prenoms, String email, LocalDate dateDeNaissance,
			String photoUrl, String motDePasse, int score) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenoms = prenoms;
		this.email = email;
		this.dateDeNaissance = dateDeNaissance;
		this.photoUrl = photoUrl;
		this.motDePasse = motDePasse;
		this.score=score; 
	}
	
	
	
	
	
	public int getScore() {
		return score;
	}





	public void setScore(int score) {
		this.score = score;
	}





	public Collegues(String email, String motDePasse) {
		super();
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Collegues() {
		super();
	}
	





	public Collegues(String email, String nom, String prenoms, String photoUrl, int score, List<String> roles) {
		this.email = email; 
		this.nom = nom; 
		this.prenoms=prenoms; 
		this.photoUrl = photoUrl; 
		this.score = score; 
		this.roles=roles; 
	}





	public List<String> getRoles() {
		return roles;
	}





	public void setRoles(List<String> roles) {
		this.roles = roles;
	}





	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}





	@Override
	public String toString() {
		return "Collegues [matricule=" + matricule + ", nom=" + nom + ", prenoms=" + prenoms + ", email=" + email
				+ ", dateDeNaissance=" + dateDeNaissance + ", photoUrl=" + photoUrl + ", motDePasse=" + motDePasse
				+ "]";
	}
    
    
	
	
}

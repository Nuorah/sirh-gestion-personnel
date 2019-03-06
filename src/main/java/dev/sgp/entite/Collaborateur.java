package dev.sgp.entite;

import java.time.*;

import javax.persistence.*;

@Entity
@Table(name="collaborateur")
public class Collaborateur {
	
	private static int compteur = 0;
	
	@Id
	private Integer id;
	@Column(name = "MATRICULE", length = 64, nullable = false, unique = true)
	private String matricule;
	@Column(name = "NOM", length = 64, nullable = false)
	private String nom;
	@Column(name = "PRENOM", length = 64, nullable = false)
	private String prenom;
	@Column
	private LocalDate dateDeNaissance;
	@Column(name = "ADRESSE", length = 200, nullable = false)
	private String adresse;
	@Column(name = "SECU", length = 64, nullable = false)
	private String numeroDeSecuriteSociale;
	@Column(name = "EMAIL", length = 64, nullable = false)
	private String emailPro;
	@Column(name = "PHOTO", length = 64, nullable = false)
	private String photo;
	@Column
	private ZonedDateTime dateHeureCreation;
	@Column(name = "ACTIF")
	private boolean actif;
	private String intitulePoste;
	private Departement departement;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule() {
		this.matricule = "" + Collaborateur.compteur;
		Collaborateur.compteur++;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumeroDeSecuriteSociale() {
		return numeroDeSecuriteSociale;
	}
	public void setNumeroDeSecuriteSociale(String numeroDeSecuriteSociale) {
		this.numeroDeSecuriteSociale = numeroDeSecuriteSociale;
	}
	public String getEmailPro() {
		return emailPro;
	}
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}
	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	} 


}

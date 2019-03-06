package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class CreerCollaborateurController extends HttpServlet{

	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	

	private boolean validateName(String name) {
		String nameRegx = "^[a-zàâçéèêëîïôûùüÿñæœ .-]*$";
		Pattern pattern = Pattern.compile(nameRegx,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(name);
		return matcher.find();
	}

	private boolean validateNumeroSecu(String numeroSecu){
		String numeroRegx = "^[0-9]{15}";
		Pattern pattern = Pattern.compile(numeroRegx,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(numeroSecu);
		return matcher.find();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/collab/creerCollaborateurs.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		boolean valid = true;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Collaborateur collaborateur = new Collaborateur();

		collaborateur.setMatricule();

		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");

		System.out.println(nom);
		System.out.println(prenom);

		if(validateName(nom) && validateName(prenom)){
			collaborateur.setNom(nom);
			collaborateur.setPrenom(prenom);
		} else {
			valid = false;
			resp.sendError(400, "Nom ou prénom invalide");
		}

		LocalDate dateDeNaissance = LocalDate.parse(req.getParameter("dateDeNaissance"), formatter);
		collaborateur.setDateDeNaissance(dateDeNaissance);

		String adresse = req.getParameter("adresse");
		collaborateur.setAdresse(adresse);

		String numeroDeSecuriteSociale = req.getParameter("numeroDeSecuriteSociale");
		if(validateNumeroSecu(numeroDeSecuriteSociale)){
			collaborateur.setNumeroDeSecuriteSociale(numeroDeSecuriteSociale);
		} else {
			valid = false;
			resp.sendError(400, "Numéro de sécurité sociale invalide");
		}

		String emailPro = prenom + "." + nom + "@societe.com";
		collaborateur.setEmailPro(emailPro);

		String photo = "https://www.stevensegallery.com/g/200/300";
		collaborateur.setPhoto(photo);

		ZonedDateTime dateHeureCreation = ZonedDateTime.now();
		collaborateur.setDateHeureCreation(dateHeureCreation);

		boolean actif = true;
		collaborateur.setActif(actif);

		if(valid){
			collabService.sauvegarderCollaborateur(collaborateur);
			resp.sendRedirect("lister");
		}

	}



}

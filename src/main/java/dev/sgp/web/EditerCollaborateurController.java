package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricule = req.getParameter("matricule");
		if(matricule == null) {
			resp.sendError(400, "Un matricule est attendu");
		} else {
			resp.setContentType("text/html");
			resp.getWriter().write("<h1>Edition de collaborateur</h1>"
					+ "<p>matricule=" + matricule + "</p>");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<String> nullList = new ArrayList<String>();
		
		String matricule = req.getParameter("matricule");
		if (matricule == null) {nullList.add("matricule");}
		String titre = req.getParameter("titre");
		if (titre == null) {nullList.add("titre");}
		String nom = req.getParameter("nom");
		if (nom == null) {nullList.add("nom");}
		String prenom = req.getParameter("prenom");
		if (prenom == null) {nullList.add("prenom");}
		
		if (nullList.size() == 0) {
			resp.setContentType("text/html");
			resp.getWriter().write("<p>Creation d’un collaborateur avec les informations suivantes</p>"
					+ "<p>matricule=" + matricule + ", titre=" + titre + ","
							+ "nom=" + nom + ", prenom=" + prenom + "</p>");
		} else {
			String errorMessage = "Les paramètres suivants sont incorrects : ";
			for (String nullParam : nullList) {
				
				errorMessage = errorMessage + nullParam + " ";
			}
			resp.sendError(400, errorMessage);
		}
	}
	
}

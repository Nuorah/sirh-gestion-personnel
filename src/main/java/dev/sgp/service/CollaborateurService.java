package dev.sgp.service;

import java.util.*;

import dev.sgp.entite.*;

public class CollaborateurService {
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	
	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}
	
	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}
}

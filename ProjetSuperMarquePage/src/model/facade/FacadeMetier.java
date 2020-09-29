package model.facade;

import java.util.List;

import model.entities.Anime;
import model.entities.Jeu;

public interface FacadeMetier {

	public List<Anime> recupererListeAnimes()throws Exception;

	public void creerAnime(final Anime a) throws Exception;

	public void modifierAnime(final Anime a) throws Exception;

	public void supprimerAnime(final Anime a) throws Exception;

	public void initialiserAnimes();
	
	public List<Jeu> recupererListeJeux()throws Exception;

	public void creerJeu(final Jeu j) throws Exception;

	public void modifierJeu(final Jeu j) throws Exception;

	public void supprimerJeu(final Jeu j) throws Exception;

	public void initialiserJeux();
	
	
	
	
}

package view;

import java.util.List;

import model.entities.Anime;
import model.entities.Jeu;
import view.exceptions.VueException;

public interface FacadeVue {

	public void afficherMessage(final String message);
	
	public int afficherMenu(final String[] menu, final String titre);
	
	public int afficherMenuPrincipal();
	
	public Anime saisirAnime() throws VueException;
	
	public Anime modifierAnime(List<Anime> Animes);
	
	public void afficherListingAnime(List<Anime> Animes);

	public void afficherListingJeu(List<Jeu> jeux);

	public Jeu saisirJeu() throws VueException;

	public Jeu recupererChoixJeuSupprimer(List<Jeu> jeux);

	public Anime recupererChoixAnimeSupprimer(List<Anime> animes);
	
}

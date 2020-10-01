package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.view.util.AffichageConsole;
import common.view.util.LectureConsole;
import model.entities.Anime;
import model.entities.EntitiesFactory;
import model.entities.Jeu;
import model.entities.exceptions.AnimeException;
import model.entities.exceptions.ConstructionException;
import model.entities.exceptions.JeuException;
import model.entities.references.TypeLangue;
import view.exceptions.VueException;
import view.references.C;

public class FacadeVueImpl implements FacadeVue{

	@Override
	public void afficherMessage(String message) {
		AffichageConsole.afficherMessageAvecSautLigne(message);
		
	}

	@Override
	public int afficherMenu(String[] menu, String titre) {
		AffichageConsole.afficherMenuEntoureAvecOptionSortie(Arrays.asList(menu), titre);
		return LectureConsole.lectureChoixInt(0, menu.length);
	}

	@Override
	public int afficherMenuPrincipal() {
		return afficherMenu(C.MENU_PRINCIPAL, C.TITRE_MENU_PRINCIPAL);
	}

	@Override
	public Anime saisirAnime() throws VueException {
		String nomAnime = LectureConsole.lectureChaineCaracteres(C.DEMANDER_NOM_ANIME);
		AffichageConsole.afficherMessageSansSautLigne(C.DEMANDER_NUMEPISODE);
		int numeroEp = LectureConsole.lectureChoixInt(1, C.MAX_NB_EPISODE);
		TypeLangue langue = demanderLangue();
		
		try {
			return EntitiesFactory.fabriquerAnime(nomAnime, numeroEp, langue);
		} catch (Exception e) {
			throw new VueException(C.FACADE_VUE_ERREUR_FABRIQUER_ANIME);
		}
		

	}

	private TypeLangue demanderLangue() {
		int choix = 0;
		
		List<String> lesLangues = new ArrayList<>();
		for (TypeLangue l : TypeLangue.values()) {
			lesLangues.add(l.toString());
		}
		AffichageConsole.afficherMessageAvecSautLigne(C.DEMANDER_LANGUE_ANIME);
		AffichageConsole.afficherMenuSimple(lesLangues);
		choix = LectureConsole.lectureChoixInt(0, TypeLangue.values().length);
		
		return TypeLangue.values()[choix -1];
	}


	
	@Override
	public void afficherListingAnime(List<Anime> Animes) {
		for (Anime a : Animes) {
			AffichageConsole.afficherMessageSansSautLigne(String.format(C.FORMATAGE_ANIME, a.getNomAnime(), a.getNumeroEp(), a.getLangue()));
		}
	}

	@Override
	public void afficherListingJeu(List<Jeu> jeux) {
		for (Jeu j : jeux) {
			AffichageConsole.afficherMessageSansSautLigne(String.format(C.FORMATAGE_JEU, j.getNomJeu(),j.getPourcentageAvancement(), j.getIndiceAvancement()));
		}
		
	}

	@Override
	public Jeu saisirJeu() throws VueException {

		String nomJeu = LectureConsole.lectureChaineCaracteres(C.DEMANDER_NOM_JEU);
		AffichageConsole.afficherMessageSansSautLigne(C.DEMANDER_AVANCEMENT);
		int avancement = LectureConsole.lectureChoixInt(0, C.MAX_JEU_AVANCEMENT);
		String indice = LectureConsole.lectureChaineCaracteres(C.DEMANDER_INDICE_JEU);
		
		try {
			return EntitiesFactory.fabriquerJeu(nomJeu, avancement, indice);
		} catch (Exception e) {
			throw new VueException(C.FACADE_VUE_ERREUR_FABRIQUER_JEU);
		}
	}
	
	@Override
	public Jeu recupererChoixJeuSupprimer(List<Jeu> jeux) {
		int choix;
		afficherListingJeu(jeux);
		afficherMessage(C.DEMANDER_CHOIX_JEU);
		choix = LectureConsole.lectureChoixInt(1, jeux.size());
		return jeux.get(choix-1);
	}

	@Override
	public Anime recupererChoixAnimeSupprimer(List<Anime> animes) {
		int choix;
		afficherListingAnime(animes);
		afficherMessage(C.DEMANDER_CHOIX_ANIME);
		choix = LectureConsole.lectureChoixInt(1, animes.size());
		return animes.get(choix-1);

	}

	@Override
	public Anime recupererChoixAnimeModifier(List<Anime> recupererListeAnimes) {
		int choix;
		afficherListingAnime(recupererListeAnimes);
		afficherMessage(C.DEMANDER_CHOIX_ANIME_MODIFICATION);
		choix = LectureConsole.lectureChoixInt(1, recupererListeAnimes.size());
		return recupererListeAnimes.get(choix-1);
	}

	@Override
	public void modifierAnime(Anime anime) throws VueException {
		String nomAnime = LectureConsole.lectureChaineCaracteres(C.DEMANDER_NOM_ANIME);
		AffichageConsole.afficherMessageAvecSautLigne(C.DEMANDER_NUMEPISODE);
		int numEpisode = LectureConsole.lectureEntier();
		TypeLangue langue = demanderLangue();
		
		try {
			anime.setNomAnime(nomAnime);
			anime.setNumeroEp(numEpisode);
			anime.setLangue(langue);
		} catch( AnimeException e) {
			throw new VueException(C.FACADE_VUE_ERREUR_MODIFICATION);
		}

	}


	@Override
	public Jeu modifierJeu(Jeu jeu) throws VueException {
		String nomJeu = LectureConsole.lectureChaineCaracteres(C.DEMANDER_NOM_JEU);
		AffichageConsole.afficherMessageSansSautLigne(C.DEMANDER_AVANCEMENT);
		int avancement = LectureConsole.lectureChoixInt(0, C.MAX_JEU_AVANCEMENT);
		String indice = LectureConsole.lectureChaineCaracteres(C.DEMANDER_INDICE_JEU);
		
		try {
			return EntitiesFactory.fabriquerJeu(nomJeu, avancement, indice);
//			jeu.setNomJeu(nomJeu);
//			jeu.setPourcentageAvancement(avancement);
//			jeu.setIndiceAvancement(indice);
		} catch( ConstructionException e) {
			throw new VueException(C.FACADE_VUE_ERREUR_MODIFICATION);
		}
		
		
	}

	@Override
	public Jeu recupererChoixJeuModifier(List<Jeu> ListeJeux) {
		int choix;
		afficherListingJeu(ListeJeux);
		afficherMessage(C.DEMANDER_CHOIX_JEU_MODIFICATION);
		choix = LectureConsole.lectureChoixInt(1, ListeJeux.size());
		return ListeJeux.get(choix);
		
	}
	

}

package view;

import java.util.Arrays;
import java.util.List;

import common.view.util.AffichageConsole;
import common.view.util.LectureConsole;
import model.entities.Anime;
import model.entities.EntitiesFactory;
import model.entities.Jeu;
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
		int numeroEp = LectureConsole.lectureChoixInt(0, 1000);
		String langue = LectureConsole.lectureChaineCaracteres(C.DEMANDER_LANGUE_ANIME);
		
		try {
			return EntitiesFactory.fabriquerAnime(nomAnime, numeroEp, langue);
		} catch (Exception e) {
			throw new VueException(C.FACADE_VUE_ERREUR_FABRIQUER_ANIME);
		}
		

	}

	@Override
	public Anime modifierAnime(List<Anime> Animes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afficherListingAnime(List<Anime> Animes) {
		for (Anime a : Animes) {
			AffichageConsole.afficherMessageSansSautLigne(a.getNomAnime()+"\t\t"+a.getNumeroEp()+"\t\t"+a.getLangue()+"\n");
		}
	}

	@Override
	public void afficherListingJeu(List<Jeu> jeux) {
		for (Jeu j : jeux) {
			AffichageConsole.afficherMessageSansSautLigne(j.getNomJeu()+"\t\t"+j.getPourcentageAvancement()+"\t\t"+j.getIndiceAvancement()+"\n");
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
}

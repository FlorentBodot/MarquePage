package presenter;

import model.facade.FacadeMetier;
import view.FacadeVue;
import view.references.C;

/**
 * 
 * @author anthony.giboz
 * Fait le lien entre la facade vue qui affiche ou la face métier qui fait les traitements.
 */
public class Presenter {
	/**
	 * création d'un objet FacadeMetier
	 */
	private FacadeMetier metier;

	/**
	 * création d'un objet FacadeVue
	 */
	private FacadeVue vue;

	/**
	 * création du constructeur avec en paramètre une vue et un métier
	 * @param metier
	 * @param vue
	 */
	public Presenter(FacadeMetier metier, FacadeVue vue) {
		this.metier=metier;
		this.vue=vue;
	}

	public void exec() {
		
		int choix = 0;
		do {
			choix = vue.afficherMenuPrincipal();
			traiterChoix(choix);
			
		} while (choix !=0);


	}

	private void traiterChoix(int choix) {
		switch (choix) {
		case 1:
			choixListing();
			break;
		case 2:
			choixAjouter();
			break;
		case 3:
			//choixModifier();
			break;
		case 4:
			choixSupprimer();
			break;

		default:
			break;
		}
	}



	private void choixListing() {
		int choix;
		choix = vue.afficherMenu(C.MENU_LISTING, C.TITRE_MENU_LISTING);
		switch (choix) {
		case 1:
			listingAnimes();
			break;
		case 2:
			listingJeux();
			break;
		default:
			break;
		}
	}
	
	private void choixAjouter() {
		int choix;
		choix = vue.afficherMenu(C.MENU_AJOUT_LISTING, C.TITRE_MENU_AJOUT);
		switch (choix) {
		case 1:
			ajoutAnime();
			break;
		case 2:
			ajoutJeu();
			break;
		default:
			break;
		}
		
	}

	private void listingJeux() {
		try {
			vue.afficherListingJeu(metier.recupererListeJeux());
		} catch (Exception e) {
			vue.afficherMessage(e.getMessage());
		}
		
	}

	private void listingAnimes() {
		try {
			vue.afficherListingAnime(metier.recupererListeAnimes());
		} catch (Exception e) {
			vue.afficherMessage(e.getMessage());
		}
		
	}

	private void ajoutAnime() {
		try {
			this.metier.creerAnime(this.vue.saisirAnime());
		} catch (Exception e) {
			this.vue.afficherMessage(e.getMessage());
		}
		
	}
	private void ajoutJeu() {
		
		try {
			this.metier.creerJeu(this.vue.saisirJeu());
		}  catch (Exception e) {
			this.vue.afficherMessage(e.getMessage());
		}
		
	}
	private void choixSupprimer() {
		int choix;
		choix = vue.afficherMenu(C.MENU_SUPPRIMER, C.TITRE_MENU_SUPPRIMER);
		switch (choix) {
		case 1:
			supprimerAnime();
			break;
		case 2:
			supprimerJeu();
			break;
		default:
			break;
		}
		
	}

	private void supprimerJeu() {
		try {
			metier.supprimerJeu(vue.recupererChoixJeuSupprimer(metier.recupererListeJeux()));
			vue.afficherMessage(C.MESSAGE_SUPPRESSION_EFFECTUE);
		} catch (Exception e) {
			vue.afficherMessage(e.getMessage());
		}
		
	}

	private void supprimerAnime() {
		try {
			metier.supprimerAnime(vue.recupererChoixAnimeSupprimer(metier.recupererListeAnimes()));
			vue.afficherMessage(C.MESSAGE_SUPPRESSION_EFFECTUE);
		} catch (Exception e) {
			vue.afficherMessage(e.getMessage());
		}
		
	}

	










}

package start;

import model.facade.FacadeMetier;
import model.facade.FacadeMetierFactory;
import presenter.Presenter;
import view.FacadeVue;
import view.FacadeVueFactory;

/**
 * 
 * @author anthony.giboz
 * @author florent.bodot
 * Programme �crivant en dur comme un marque page les noms num�ros d'episode
 * et la langue que rentre l'utilisateur de l'anim� en question.
 * �crivant aussi en dur comme un marque page les noms pourcentage d'avancement
 * et un indice de positionnement dans le jeu que rentre l'utilisateur du jeu en question.
 */

public class Lanceur {

	private static FacadeMetier metier = FacadeMetierFactory.fabriquerFacadeMetier();
	private static FacadeVue vue = FacadeVueFactory.fabriquerFacadeVue();
	public static void main(String[] args) {



	
		metier.initialiserAnimes();
		metier.initialiserJeux();
	Presenter p = new Presenter(metier, vue);

	p.exec();

//	Coucou les bitos, c'est l'adjudant Tifrice !
}
}
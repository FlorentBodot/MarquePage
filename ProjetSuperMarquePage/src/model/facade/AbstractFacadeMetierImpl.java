/**
 * 
 */
package model.facade;

import common.dao.Dao;
import model.dao.AbstractAnimeDao;
import model.dao.DaoFactory;
import model.entities.Jeu;

/**
 * @author anthony.giboz
 *
 */
public abstract class AbstractFacadeMetierImpl implements FacadeMetier{

	/**
	 * repr�sente la dao pour les Animes
	 */
	protected AbstractAnimeDao daoAnime = DaoFactory.fabriquerAnimeDao();	
	public void initialiserAnimes() {
		daoAnime.init();
			
}

	/**
	 * repr�sente la dao pour les Jeux
	 */
	protected Dao<Jeu, String> daoJeu = DaoFactory.fabriquerJeuDao();	
	public void initialiserJeux() {
		
		daoJeu.init();
			
}
}

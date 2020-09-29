/**
 * 
 */
package model.facade;

import common.dao.Dao;
import model.dao.DaoFactory;
import model.entities.Anime;
import model.entities.Jeu;

/**
 * @author anthony.giboz
 *
 */
public abstract class AbstractFacadeMetierImpl implements FacadeMetier{

	/**
	 * représente la dao pour les Animes
	 */
	protected Dao<Anime, String> daoAnime = DaoFactory.fabriquerAnimeDao();	
	public void initialiserAnimes() {
		daoAnime.init();
			
}

	/**
	 * représente la dao pour les Jeux
	 */
	protected Dao<Jeu, String> daoJeu = DaoFactory.fabriquerJeuDao();	
	public void initialiserJeux() {
		
		daoJeu.init();
			
}
}

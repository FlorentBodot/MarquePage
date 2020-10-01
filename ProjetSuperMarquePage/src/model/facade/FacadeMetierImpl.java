/**
 * 
 */
package model.facade;

import java.util.List;

import common.dao.exceptions.DaoException;
import model.entities.Anime;
import model.entities.Jeu;

/**
 * @author anthony.giboz
 *
 */
public final class FacadeMetierImpl extends AbstractFacadeMetierImpl {
	
	private final static FacadeMetier SINGLETON = new FacadeMetierImpl();
	
	public List<Anime> recupererListeAnimes()throws Exception{

		try {
			return daoAnime.readAll();
		} catch (DaoException e) {
			throw new Exception(e);
		}

	}

	public void creerAnime(Anime a) throws Exception {
		try {
			daoAnime.create(a);
		}catch(DaoException e) {
			throw new Exception(e);
		}
	}
	public void modifierAnime(Anime a)throws Exception{

		try {
			daoAnime.update(a);
		} catch (DaoException e) {
			throw new Exception(e);
		}


	}
	public void supprimerAnime(Anime a)throws Exception{

		try {
			daoAnime.delete(a);
		} catch (DaoException e) {
			throw new Exception(e);
		}

	}



	@Override
	public List<Jeu> recupererListeJeux() throws Exception {
		try {
			return daoJeu.readAll();
		} catch (DaoException e) {
			throw new Exception(e);
		}
	}

	@Override
	public void creerJeu(Jeu j) throws Exception {
		try {
			daoJeu.create(j);
		}catch(DaoException e) {
			throw new Exception(e);
		}
		
	}

	@Override
	public void modifierJeu(Jeu j) throws Exception {
		try {
			daoJeu.create(j);
		} catch (DaoException e) {
			throw new Exception(e);
		}
		
	}
	
	@Override
	public void supprimerJeu(Jeu j) throws Exception {
		try {
			daoJeu.delete(j);
		} catch (DaoException e) {
			throw new Exception(e);
		}
		
	}

	public static FacadeMetier getInstance() {
		return SINGLETON;
	}


}

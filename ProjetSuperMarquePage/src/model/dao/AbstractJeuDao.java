package model.dao;

import common.dao.Dao;
import common.dao.exceptions.DaoException;
import model.entities.EntitiesFactory;
import model.entities.Jeu;
import model.entities.exceptions.ConstructionException;

public abstract class AbstractJeuDao implements Dao<Jeu, String>{

	@Override
	public void init() {

		try {
			create(EntitiesFactory.fabriquerJeu("DOOM", 0, "Non commencé"));
		} catch (DaoException | ConstructionException e) {
			e.printStackTrace();
		}
	}
}

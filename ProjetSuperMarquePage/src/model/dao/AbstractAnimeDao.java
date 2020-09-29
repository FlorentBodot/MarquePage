package model.dao;

import common.dao.Dao;
import common.dao.exceptions.DaoException;
import model.entities.Anime;
import model.entities.EntitiesFactory;
import model.entities.exceptions.ConstructionException;

public abstract class AbstractAnimeDao implements Dao<Anime, String>{
	
	@Override
	public void init() {
		try {
			create(EntitiesFactory.fabriquerAnime("Bleach",336,"VOSTFR"));
		} catch (DaoException |ConstructionException e) {
			e.printStackTrace();

		}

	}

}

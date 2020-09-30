package model.dao;

import common.dao.Dao;
import common.dao.exceptions.DaoException;
import model.entities.Anime;
import model.entities.EntitiesFactory;
import model.entities.exceptions.ConstructionException;
import model.entities.references.TypeLangue;

public abstract class AbstractAnimeDao implements Dao<Anime, String>{
	
	@Override
	public void init() {
		try {
			create(EntitiesFactory.fabriquerAnime("Bleach",336, TypeLangue.VOSTFR));
			create(EntitiesFactory.fabriquerAnime("Baki",25, TypeLangue.VF));
		} catch (DaoException |ConstructionException e) {
			e.printStackTrace();

		}

	}

}

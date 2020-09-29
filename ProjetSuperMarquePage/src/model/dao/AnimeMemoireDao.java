package model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.dao.exceptions.DaoException;
import model.dao.references.C;
import model.entities.Anime;


public class AnimeMemoireDao extends AbstractAnimeDao {
	/** Contient toutes les instances de Anime.*/
	private List<Anime> persistence = new ArrayList<>();

	


	@Override
	public Anime read(String t) throws DaoException{

		for (Anime anime : persistence)  {
			if (anime.getNomAnime().equals(t)) {
				return anime;
			}
		}

		throw new DaoException(C.ANIMEDAO_READ_EXCEPTION);
	}

	@Override
	public List<Anime> readAll() {

		return Collections.unmodifiableList(persistence);
	}

	@Override
	public boolean exist(Anime t) {

		return this.persistence.contains(t);
	}

	@Override
	public void delete(Anime t) throws DaoException {

		if (! this.exist(t)) {
			throw new DaoException(C.ANIMEDAO_DELETE_EXCEPTION);
		}
		this.persistence.remove(t);
	}

	@Override
	public void create(Anime t) throws DaoException {

		if (this.exist(t)) {
			throw new DaoException(C.ANIMEDAO_CREATE_EXCEPTION);

		}
		this.persistence.add(t);
	}

	@Override
	public void update(Anime t) throws DaoException {
		if (! this.exist(t)) {
			throw new DaoException(C.ANIMEDAO_UPDATE_EXCEPTION);	
		}


		this.delete(t);
		this.create(t);

	}



}

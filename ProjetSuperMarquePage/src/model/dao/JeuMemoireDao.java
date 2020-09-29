package model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.dao.exceptions.DaoException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.dao.references.C;
import model.entities.Jeu;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JeuMemoireDao extends AbstractJeuDao {

	/** Contient toutes les instances de Jeu. */
	private List<Jeu> persistence = new ArrayList<>();
	
	


	@Override
	public void create(Jeu j) throws DaoException {

		if (this.exist(j)) {
			throw new DaoException(C.JEUDAO_CREATE_EXCPETION);
		}
		this.persistence.add(j);
	} 

	@Override
	public Jeu read(String nom) throws DaoException {

		for (Jeu j : persistence) {
			if (j.getNomJeu().equals(nom)) {
				return j;
			}
		}
		
		throw new DaoException(C.JEUDAO_READ_EXCEPTION);
	}
	
	
	@Override
	public void update(Jeu j) throws DaoException {
		
		if (!this.exist(j)) {
			throw new DaoException(C.JEUDAO_UPDATE_EXCEPTION);
		}
		
		
		this.delete(j);
		this.create(j);
		

	}
	
	@Override
	public void delete(Jeu j) throws DaoException {

		if (!this.exist(j)) {
			throw new DaoException(C.JEUDAO_DELETE_EXCEPTION);
		}
		
		this.persistence.remove(j);
	}

	@Override
	public boolean exist(Jeu j) throws DaoException {
				
		return this.persistence.contains(j);
	}
	
	

	@Override
	public List<Jeu> readAll() throws DaoException {
	
		return Collections.unmodifiableList(this.persistence);
	}

}

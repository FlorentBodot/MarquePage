package model.entities;
import java.util.Objects;

import model.entities.exceptions.AnimeException;
import model.entities.references.C;

/**
 * @author anthony.giboz
 * Classe permettant de créer un objet de type Anime
 * prenant en paramètre un nom un numéro et une langue
 */

public class Anime {
	
	private String nomAnime;
	
	private int numeroEp;
	
	private String langue;

	/**
	 * 
	 * @param nomAnime
	 * @throws AnimeException
	 */
	public void setNomAnime(String nomAnime) throws AnimeException {
		if (Objects.isNull(nomAnime)) {
			throw new AnimeException(C.NOMANIME_NULL);
		}
		nomAnime=nomAnime.trim();
		if (nomAnime.isEmpty()) {
			throw new AnimeException(C.NOMANIME_VIDE);
		}
		this.nomAnime=nomAnime;
	}	
	/**
	 * 
	 * @param numeroEp
	 * @throws AnimeException
	 */
	public void setNumeroEp(int numeroEp) throws AnimeException {
		if (Objects.isNull(numeroEp)) {
			throw new AnimeException(C.NUMEROANIME_NULL);
		}
		if (numeroEp<0) {
			throw new AnimeException(C.NUMEROANIME_NEGATIF);
		}

		this.numeroEp=numeroEp;
	}
	/**
	 * 
	 * @param langue
	 * @throws AnimeException
	 */
	public void setLangue(String langue) throws AnimeException {
		if (Objects.isNull(langue)) {
			throw new AnimeException(C.LANGUEANIME_NULL);
		}
		langue=langue.trim();
		if (langue.isEmpty()) {
			throw new AnimeException(C.LANGUEANIME_VIDE);
		}
		if (! (langue=="VF"| langue=="VOSTFR")) {
			throw new AnimeException(C.LANGUEANIME_INCORRECT,C.MAJ_APPLI_LANGUE_ANIME);
		}

		this.langue=langue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomAnime == null) ? 0 : nomAnime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anime other = (Anime) obj;
		if (nomAnime == null) {
			if (other.nomAnime != null)
				return false;
		} else if (!nomAnime.equals(other.nomAnime))
			return false;
		return true;
	}
	public String getNomAnime(){
		return this.nomAnime;
	}
	public int getNumeroEp() {
		return this.numeroEp;
	}
	public String getLangue() {
		return this.langue;
	}
	
	protected Anime() {}
}

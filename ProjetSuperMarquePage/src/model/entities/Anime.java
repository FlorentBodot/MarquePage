package model.entities;
import java.util.Objects;

import lombok.Getter;
import model.entities.exceptions.AnimeException;
import model.entities.references.C;
import model.entities.references.TypeLangue;

/**
 * @author anthony.giboz
 * Classe permettant de créer un objet de type Anime
 * prenant en paramètre un nom un numéro et une langue
 */

@Getter
public class Anime {
	
	private String nomAnime;
	
	private int numeroEp;
	
	private TypeLangue langue;

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
		if (numeroEp < 0) {
			throw new AnimeException(C.NUMEROANIME_NEGATIF);
		}

		this.numeroEp=numeroEp;
	}
	/**
	 * 
	 * @param langue
	 * @throws AnimeException
	 */
	public void setLangue(TypeLangue langue) throws AnimeException {
		if (Objects.isNull(langue)) {
			throw new AnimeException(C.LANGUEANIME_NULL);
		}

		this.langue=langue;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((langue == null) ? 0 : langue.hashCode());
		result = prime * result + ((nomAnime == null) ? 0 : nomAnime.hashCode());
		result = prime * result + numeroEp;
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
		if (langue != other.langue)
			return false;
		if (nomAnime == null) {
			if (other.nomAnime != null)
				return false;
		} else if (!nomAnime.equals(other.nomAnime))
			return false;
		if (numeroEp != other.numeroEp)
			return false;
		return true;
	}

	
	

	
}

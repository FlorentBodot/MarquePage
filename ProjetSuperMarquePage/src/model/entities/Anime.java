package model.entities;
import java.util.Objects;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import model.entities.exceptions.AnimeException;
import model.entities.references.I18nC;
import model.entities.references.TypeLangue;

/**
 * @author anthony.giboz
 * Classe permettant de créer un objet de type Anime
 * prenant en paramètre un nom un numéro et une langue
 */

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
			throw new AnimeException(I18nC.get("NOMANIME_NULL"));
		}
		nomAnime=nomAnime.trim();
		if (nomAnime.isEmpty()) {
			throw new AnimeException(I18nC.get("NOMANIME_VIDE"));
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
			throw new AnimeException(I18nC.get("NUMEROANIME_NULL"));
		}
		if (numeroEp < 0) {
			throw new AnimeException(I18nC.get("NUMEROANIME_NEGATIF"));
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
			throw new AnimeException(I18nC.get("LANGUEANIME_NULL"));
		}

		this.langue=langue;
	}
	
}

package model.entities;

import java.util.Objects;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import model.entities.exceptions.JeuException;
import model.entities.references.I18nC;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
public class Jeu {

	private String nomJeu;
	
	private int pourcentageAvancement;
	
	private String indiceAvancement;
	

	/**
	 * @param nomJeux the nomJeux to set
	 * @throws JeuException 
	 */
	public void setNomJeu(String nomJeu) throws JeuException {
		if (Objects.isNull(nomJeu)) {
			throw new JeuException(I18nC.get("JEU_NOM_NULL_EXCEPTION"));
		}
		nomJeu = nomJeu.trim();
		if (nomJeu.isEmpty()) {
			throw new JeuException(I18nC.get("JEU_NOM_VIDE_EXCEPTION"));
		}
		this.nomJeu = nomJeu;
	}


	/**
	 * @param pourcentageAvancement the pourcentageAvancement to set
	 * @throws JeuException 
	 */
	public void setPourcentageAvancement(int pourcentageAvancement) throws JeuException {
		if (pourcentageAvancement < 0) {
			throw new JeuException(I18nC.get("JEU_AVANCEMENT_NEGATIF_EXCEPTION"));
		}
		if (pourcentageAvancement > 100) {
			throw new JeuException(I18nC.get("JEU_AVANCEMENT_IMPOSSIBLE_EXCEPTION"));
		}
		this.pourcentageAvancement = pourcentageAvancement;
	}


	/**
	 * @param indiceAvancement the indiceAvancement to set
	 * @throws JeuException 
	 */
	public void setIndiceAvancement(String indiceAvancement) throws JeuException {
		if (Objects.isNull(indiceAvancement)) {
			throw new JeuException(I18nC.get("JEU_INDICE_NULL_EXCEPTION"));
		}
		indiceAvancement = indiceAvancement.trim();
		if (indiceAvancement.isEmpty()) {
			throw new JeuException(I18nC.get("JEU_INDICE_VIDE_EXCEPTION"));
		}
		this.indiceAvancement = indiceAvancement;
	}

	
}

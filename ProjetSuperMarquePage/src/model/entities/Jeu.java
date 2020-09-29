package model.entities;

import java.util.Objects;

import model.entities.exceptions.JeuException;
import model.entities.references.C;


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
			throw new JeuException(C.JEU_NOM_NULL_EXCEPTION);
		}
		nomJeu = nomJeu.trim();
		if (nomJeu.isEmpty()) {
			throw new JeuException(C.JEU_NOM_VIDE_EXCEPTION);
		}
		this.nomJeu = nomJeu;
	}


	/**
	 * @param pourcentageAvancement the pourcentageAvancement to set
	 * @throws JeuException 
	 */
	public void setPourcentageAvancement(int pourcentageAvancement) throws JeuException {
		if (pourcentageAvancement < 0) {
			throw new JeuException(C.JEU_AVANCEMENT_NEGATIF_EXCEPTION);
		}
		if (pourcentageAvancement > 100) {
			throw new JeuException(C.JEU_AVANCEMENT_IMPOSSIBLE_EXCEPTION);
		}
		this.pourcentageAvancement = pourcentageAvancement;
	}


	/**
	 * @param indiceAvancement the indiceAvancement to set
	 * @throws JeuException 
	 */
	public void setIndiceAvancement(String indiceAvancement) throws JeuException {
		if (Objects.isNull(indiceAvancement)) {
			throw new JeuException(C.JEU_INDICE_NULL_EXCEPTION);
		}
		indiceAvancement = indiceAvancement.trim();
		if (indiceAvancement.isEmpty()) {
			throw new JeuException(C.JEU_INDICE_VIDE_EXCEPTION);
		}
		this.indiceAvancement = indiceAvancement;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomJeu == null) ? 0 : nomJeu.hashCode());
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
		Jeu other = (Jeu) obj;
		if (nomJeu == null) {
			if (other.nomJeu != null)
				return false;
		} else if (!nomJeu.equals(other.nomJeu))
			return false;
		return true;
	}

	public Object getNomJeu() {
		
		return this.nomJeu;
	}
	public Object getPourcentageAvancement() {
		
		return this.pourcentageAvancement;
	}
	public Object getIndiceAvancement() {
		
		return this.indiceAvancement;
	}
	protected Jeu() {}
	
	
	
}

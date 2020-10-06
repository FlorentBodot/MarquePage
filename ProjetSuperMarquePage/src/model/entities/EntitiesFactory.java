package model.entities;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.entities.exceptions.AnimeException;
import model.entities.exceptions.ConstructionException;
import model.entities.exceptions.JeuException;
import model.entities.references.TypeLangue;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EntitiesFactory {

	public static Jeu fabriquerJeu(final String nom, final int pourcentage, final String indice) throws ConstructionException {

		
		try {
			Jeu j = new Jeu();
			j.setNomJeu(nom);
			j.setPourcentageAvancement(pourcentage);
			j.setIndiceAvancement(indice);
			return j;
		} catch (JeuException e) {
			throw new ConstructionException(e);
		}
		
		
	}

	public static Anime fabriquerAnime(final String nomAnime,final int numeroEp,final TypeLangue langue) throws ConstructionException {
		
				
		try {
			Anime a = new Anime();
			a.setNomAnime(nomAnime);
			a.setNumeroEp(numeroEp);
			a.setLangue(langue);
			return a;
		} catch (AnimeException e) {
			throw new ConstructionException(e);
		}
		
		
		
	}
}

package model.entities.references;
@Deprecated
public class C {

	public static final String NOMANIME_NULL = "Le nom de l'animé ne peut être null";
	public static final String NOMANIME_VIDE = "Le nom de l'animé ne peut être vide";
	public static final String NUMEROANIME_NULL = "Le numéro de l'épisode ne peut être null";
	public static final String NUMEROANIME_NEGATIF = "Le numéro de l'épisode ne peut être inférieur a 0";
	public static final String LANGUEANIME_NULL = "La langue ne peut être null";
	public static final String LANGUEANIME_VIDE = "La langue ne peut être vide";
	public static final String LANGUEANIME_INCORRECT = "La langue ne peut être autre que 'VF' ou 'VOSTFR'";
	public static final String MAJ_APPLI_LANGUE_ANIME = "Attendre une future mise a jour du système pour pouvoir choisir une autre langue";
	
	public static final String JEU_NOM_NULL_EXCEPTION = "Le nom du jeu doit être attaché";
	public static final String JEU_NOM_VIDE_EXCEPTION = "Le nom du jeu ne doit pas être vide";
	public static final String JEU_AVANCEMENT_NEGATIF_EXCEPTION = "L'avancement ne peut pas être inférieur à 0";
	public static final String JEU_AVANCEMENT_IMPOSSIBLE_EXCEPTION = "L'avancement ne peut pas être supérieur à 100%";
	public static final String JEU_INDICE_NULL_EXCEPTION = "L'indice ne peut pas être null, renseigné 'non commencé' si nouveau jeu";
	public static final String JEU_INDICE_VIDE_EXCEPTION = "L'indice ne peut pas être vide, renseigné 'non commencé' si nouveau jeu.";
	
}

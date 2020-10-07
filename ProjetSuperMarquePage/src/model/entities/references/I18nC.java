package model.entities.references;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nC {
	
	private static final String FILE_BASE_NAME = "constantesModelEntities";

	private static ResourceBundle rb;
	
	static {
		I18nC.rb = ResourceBundle.getBundle(I18nC.FILE_BASE_NAME);
	}
	
	public static void changeLocal(Locale pLocale) {
		I18nC.rb = ResourceBundle.getBundle(I18nC.FILE_BASE_NAME, pLocale);
	}
	
	public static String get(String pKey) {
		return I18nC.rb.getString(pKey);
	}
	
}

package model.facade;

public class FacadeMetierFactory {
	private FacadeMetierFactory() {}
	/**
	 * retourne une instance de FacadeMetierImpl
	 * @return
	 */
	public static FacadeMetier fabriquerFacadeMetier() {
		return new FacadeMetierImpl();
}
}

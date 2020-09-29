package view;
/**
 * 
 * @author anthony.giboz
 *
 */
public final class FacadeVueFactory {

	public static FacadeVue fabriquerFacadeVue() {

		return new FacadeVueImpl();
	}
}

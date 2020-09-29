package model.dao;

public class DaoFactory {
	private DaoFactory() {}
	/**
	 * @return la Dao Anime
	 * 
	 */
	public static AbstractAnimeDao fabriquerAnimeDao() {

		return new AnimeMemoireDao();
	}
	public static JeuMemoireDao fabriquerJeuDao() {
		
		return new JeuMemoireDao();
	}
}

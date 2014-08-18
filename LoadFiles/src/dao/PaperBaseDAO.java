package dao;

import java.util.ArrayList;

import model.PaperBean;

/**
 * @author miamarti
 *
 */
public enum PaperBaseDAO {
	getInstance;

	/**
	 * @param novoPipo
	 */
	public void setPipo(ArrayList<PaperBean> novoPipo) {

		// TODO: Here you persist the beans
		for (PaperBean pipoBean : novoPipo) {
			System.out.println(pipoBean);
		}
	}
}

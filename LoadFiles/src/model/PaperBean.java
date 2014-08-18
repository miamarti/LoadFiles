package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author miamarti
 *
 */
public class PaperBean {

	private String colA;
	private String colB;
	private String colC;
	private String colD;
	private String colE;
	private String colF;
	private String colG;
	private String colH;
	private String colI;

	/**
	 * @return the nsAeron
	 */
	public String getColA() {
		return colA;
	}

	/**
	 * @param nsAeron
	 *            the nsAeron to set
	 */
	public void setColA(String colA) {
		this.colA = colA;
	}

	/**
	 * @return the programa
	 */
	public String getColB() {
		return colB;
	}

	/**
	 * @param programa
	 *            the programa to set
	 */
	public void setColB(String colB) {
		this.colB = colB;
	}

	/**
	 * @return the dataAFA
	 */
	public Date getColC() {
		try {
			return (new SimpleDateFormat("dd/MM/yyyy")).parse(colC);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param dataAFA
	 *            the dataAFA to set
	 */
	public void setColC(String colC) {
		this.colC = colC;
	}

	/**
	 * @return the cliente
	 */
	public String getColD() {
		return colD;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setColD(String colD) {
		this.colD = colD;
	}

	/**
	 * @return the efetiv
	 */
	public String getColE() {
		return colE;
	}

	/**
	 * @param efetiv
	 *            the efetiv to set
	 */
	public void setColE(String colE) {
		this.colE = colE;
	}

	/**
	 * @return the modMrp
	 */
	public String getColF() {
		return colF;
	}

	/**
	 * @param modMrp
	 *            the modMrp to set
	 */
	public void setColF(String colF) {
		this.colF = colF;
	}

	/**
	 * @return the modPa
	 */
	public String getColG() {
		return colG;
	}

	/**
	 * @param modPa
	 *            the modPa to set
	 */
	public void setColG(String colG) {
		this.colG = colG;
	}

	/**
	 * @return the homolog
	 */
	public String getColH() {
		return colH;
	}

	/**
	 * @param homolog
	 *            the homolog to set
	 */
	public void setColH(String colH) {
		this.colH = colH;
	}

	/**
	 * @return the motor
	 */
	public String getColI() {
		return colI;
	}

	/**
	 * @param motor
	 *            the motor to set
	 */
	public void setColI(String colI) {
		this.colI = colI;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"nsAeron\":\"" + colA + "\", \"programa\":\"" + colB + "\", \"dataAFA\":\"" + colC + "\", \"cliente\":\"" + colD + "\", \"efetiv\":\"" + colE + "\", \"modMrp\":\"" + colF + "\", \"modPa\":\"" + colG + "\", \"homolog\":\"" + colH + "\", \"motor\":\"" + colI + "\"}";
	}

}

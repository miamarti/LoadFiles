package business;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.PaperBean;
import dao.PaperBaseDAO;

/**
 * @author miamarti
 *
 */
public class PaperBO implements Runnable {

	int qtdColunas = 9;
	private String cabecalho = "NSaeron;Programa;DataAFA;Cliente;Efetiv;Mod MRP;ModPA;Homolog;Motor";
	private String caminhoArquivo = "C:\\Documents and Settings\\miamarti\\Desktop\\TXT\\PIPO\\PIPO.csv";
	private int qtdLinhas = 0;
	private SwingConstants jLabel;
	private boolean returnLabel = false;
	private String separador = ";";

	/**
	 * @param msn
	 */
	private void setMsnLabel(String msn) {
		if (this.returnLabel) {
			((JLabel) jLabel).setText(msn);
		} else {
			System.out.println(msn);
		}
	}

	/**
	 * @return
	 */
	public String getTxtImport() {
		String linha = "";
		int qtdLinhasValidas = 0;
		String retorno = "";
		PaperBean bean;
		StringTokenizer stk;
		int countBatch = 0;

		try {
			this.setMsnLabel("O carregamento esta sendo executado...");
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(getParent());
			this.setCaminhoArquivo(fc.getSelectedFile().getAbsolutePath());
		} catch (HeadlessException e1) {
			this.setMsnLabel("Erro ao carregar o arquivo...");
			e1.printStackTrace();
		}

		try {
			FileReader reader = new FileReader(caminhoArquivo);
			BufferedReader leitor = new BufferedReader(reader);
			this.setMsnLabel("Iniciando PIPO as " + new Date());
			linha = leitor.readLine();

			if (validarCabecalho((cabecalho.replace(" ", "")).trim(), (linha.replace(" ", "")).trim())) {
				while (true) {
					linha = leitor.readLine();
					if (linha == null) {
						break;
					}

					this.setMsnLabel("Lendo linha n.: " + qtdLinhas);
					qtdLinhas++;

					try {
						linha = linha.replace(";", "; ");
						stk = new StringTokenizer(linha, separador);

						ArrayList<PaperBean> novoPipo = new ArrayList<PaperBean>();
						if (stk.countTokens() == qtdColunas) {
							bean = new PaperBean();
							bean.setColA(stk.nextToken().trim());
							bean.setColB(stk.nextToken().trim());
							bean.setColC(stk.nextToken().trim());
							bean.setColD(stk.nextToken().trim());
							bean.setColE(stk.nextToken().trim());
							bean.setColF(stk.nextToken().trim());
							bean.setColG(stk.nextToken().trim());
							bean.setColH(stk.nextToken().trim());
							bean.setColI(stk.nextToken().trim());
							qtdLinhasValidas++;
							novoPipo.add(bean);
						}
						PaperBaseDAO.getInstance.setPipo(novoPipo);

					} catch (Exception e) {
						System.out.println("Problemas na leitura da linha: " + qtdLinhas);
					}

				}
			} else {
				this.setMsnLabel("Arquivo inválido");
				retorno = "Arquivo inválido";
			}

			leitor.close();
			reader.close();

			this.setMsnLabel("Batch nº: " + countBatch);
			this.setMsnLabel("Batch executado! " + new Date());

			retorno = "Leitura do Arquivo PIPO finalizada. Total de linhas " + qtdLinhas + ". Linhas Válidas: " + qtdLinhasValidas;

		} catch (Exception erroGeral) {
			erroGeral.printStackTrace();
		}

		this.setMsnLabel(retorno);
		return retorno;
	}

	/**
	 * @param pCabecalho
	 * @param pLinha
	 * @return
	 */
	public static boolean validarCabecalho(String pCabecalho, String pLinha) {
		if (pCabecalho.equals(pLinha.replace(" ", ""))) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @return
	 */
	private Component getParent() {
		return null;
	}

	/**
	 * @return
	 */
	public int getQtdLinhas() {
		return qtdLinhas;
	}

	/**
	 * @param qtdLinhas
	 */
	public void setQtdLinhas(int qtdLinhas) {
		this.qtdLinhas = qtdLinhas;
	}

	/**
	 * @return
	 */
	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	/**
	 * @param caminhoArquivo
	 */
	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

	/**
	 * @return
	 */
	public SwingConstants getJLabel() {
		return jLabel;
	}

	/**
	 * @param jLabel
	 */
	public void setJLabel(JLabel jLabel) {
		try {
			this.jLabel = jLabel;
			this.setReturnLabel(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	public boolean isReturnLabel() {
		return returnLabel;
	}

	/**
	 * @param returnLabel
	 */
	private void setReturnLabel(boolean returnLabel) {
		this.returnLabel = returnLabel;
	}

	/**
	 * @return
	 */
	public String getCabecalho() {
		return cabecalho;
	}

	/**
	 * @param cabecalho
	 */
	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
	}

	/**
	 * @return
	 */
	public String getSeparador() {
		return separador;
	}

	/**
	 * @param separador
	 */
	public void setSeparador(String separador) {
		this.separador = separador;
	}

	@Override
	public void run() {
		System.out.println(this.getTxtImport());
	}
}

package view;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Calculations;

/**
 * Classe que listará os resultados.
 * 
 * @author Emmanuel Kant
 */
public class ResultFrame extends JDialog {

	/**
	 * Construtor da Classe.
	 * 
	 * @param mainFrame
	 *            Passando a classe principal para ser colocada no
	 *            setLocationRelativeTo().
	 * @param revenueOld
	 *            Receita posta pelo usuário.
	 */
	public ResultFrame(MainFrame mainFrame, float revenue) {
		build(mainFrame, revenue);
	}

	/**
	 * Método que constrói a dialog.
	 * 
	 * @param mainFrame
	 *            Passando a classe principal para ser colocada no
	 *            setLocationRelativeTo().
	 * @param revenue
	 *            Receita posta pelo usuário.
	 */
	private void build(MainFrame mainFrame, float revenue) {
		buildComponets(revenue);
		pack();
		setResizable(false);
		setTitle("Resultados");
		setLayout(new GridBagLayout());
		setLocationRelativeTo(mainFrame);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Método que constrói e coloca os componente na frame.
	 * 
	 * @param revenue
	 *            Receita para ser calculada pelos métodos.
	 */
	private void buildComponets(float revenue) {
		JPanel panel = new JPanel(new GridBagLayout());
		buildTitleOfFrame(panel);
		buildPisArea(revenue, panel);
		buildCofinsArea(revenue, panel);
		buildCsslArea(revenue, panel);
		buildIrpjArea(revenue, panel);
		// É preciso criar um JTextField da Base de Calculo pois o sistema usará
		// provisoriamente como parametro de outro método.
		JTextField bcField = buildBcArea(revenue, panel);
		buildIpaArea(panel, bcField);
		buildBackButton(panel);
		add(panel);
	}

	private void buildTitleOfFrame(JPanel panel) {
		JLabel titleLabel = new JLabel("Resultados");
		titleLabel.setFont(new Font(null, 0, 18));
		panel.add(titleLabel, new GBC(0, 0).gridwh(0, 1));
	}

	/**
	 * Método que constrói o label e o text field do Imposto Adicional (IPA).
	 * 
	 * @param panel
	 *            Componente para a inserção dos objetos criados.
	 * @param bcField
	 *            O valor armazenado no field da Base de Cálculo.
	 */
	private void buildIpaArea(JPanel panel, JTextField bcField) {
		float valueOfBcField = Float.parseFloat(bcField.getText().replace(",", "."));
		if (valueOfBcField >= 20000.00) {
			JLabel ipaLabel = new JLabel("Imposto Adicional:");
			panel.add(ipaLabel, new GBC(0, 6).left().insets(0, 5, 0, 5));
			JTextField ipaField = new JTextField(15);
			ipaField.setEditable(false);
			ipaField.setText(Calculations.calcOfIpa(valueOfBcField));
			panel.add(ipaField, new GBC(1, 6).insets(10, 0, 10, 10));
		}
	}

	/**
	 * Método que constrói o label e o text field da Base de Calculo (BC).
	 * 
	 * @param revenue
	 *            Receita to usuário.
	 * @param panel
	 *            Componente para a inserção dos objetos criados.
	 * @return Somente o field da base de calculo com o valor nele.
	 */
	private JTextField buildBcArea(float revenue, JPanel panel) {
		JLabel bcLabel = new JLabel("Base de Calcúlo:");
		panel.add(bcLabel, new GBC(0, 5).left().insets(0, 5, 0, 5));
		JTextField bcField = new JTextField(15);
		bcField.setEditable(false);
		bcField.setText(Calculations.calcOfBc(revenue));
		panel.add(bcField, new GBC(1, 5).insets(10, 0, 10, 10));
		return bcField;
	}

	/**
	 * Método que constrói o label e o text field da Imposto de Renda de Pessoa
	 * Juridica (IRPJ).
	 * 
	 * @param revenue
	 *            Receita to usuário.
	 * @param panel
	 *            Componente para a inserção dos objetos criados.
	 */
	private void buildIrpjArea(float revenue, JPanel panel) {
		JLabel irpjLabel = new JLabel("Irpj:");
		panel.add(irpjLabel, new GBC(0, 4).left().insets(0, 5, 0, 5));
		JTextField irpjField = new JTextField(15);
		irpjField.setEditable(false);
		irpjField.setText(Calculations.calcOfIrpj(revenue));
		panel.add(irpjField, new GBC(1, 4).insets(10, 0, 10, 10));
	}

	/**
	 * Método que constrói o label e o text field da Contribuição Social Sobre
	 * Lucro (CSSL).
	 * 
	 * @param revenue
	 *            Receita to usuário.
	 * @param panel
	 *            Componente para a inserção dos objetos criados.
	 */
	private void buildCsslArea(float revenue, JPanel panel) {
		JLabel csslLabel = new JLabel("Cssl:");
		panel.add(csslLabel, new GBC(0, 3).left().insets(0, 5, 0, 5));
		JTextField csslField = new JTextField(15);
		csslField.setEditable(false);
		csslField.setText(Calculations.calcOfCssl(revenue));
		panel.add(csslField, new GBC(1, 3).insets(10, 0, 10, 10));
	}

	/**
	 * Método que constrói o label e o text field da Contribuição para o
	 * Financiamento da Seguridade Social (Cofins).
	 * 
	 * @param revenue
	 *            Receita to usuário.
	 * @param panel
	 *            Componente para a inserção dos objetos criados.
	 */
	private void buildCofinsArea(float revenue, JPanel panel) {
		JLabel cofinsLabel = new JLabel("Cofins:");
		panel.add(cofinsLabel, new GBC(0, 2).left().insets(0, 5, 0, 5));
		JTextField cofinsField = new JTextField(15);
		cofinsField.setEditable(false);
		cofinsField.setText(Calculations.calcOfCofins(revenue));
		panel.add(cofinsField, new GBC(1, 2).insets(10, 0, 10, 10));
	}

	/**
	 * Método que constrói o label e o text field da Programa de Integração
	 * Social (PIS).
	 * 
	 * @param revenue
	 *            Receita to usuário.
	 * @param panel
	 *            Componente para a inserção dos objetos criados.
	 */
	private void buildPisArea(float revenue, JPanel panel) {
		JLabel pisLabel = new JLabel("Pis:");
		panel.add(pisLabel, new GBC(0, 1).left().insets(0, 5, 0, 5));
		JTextField pisField = new JTextField(15);
		pisField.setEditable(false);
		pisField.setText(Calculations.calcOfPis(revenue));
		panel.add(pisField, new GBC(1, 1).insets(10, 0, 10, 10));
	}

	/**
	 * Método que cria o botão de voltar.
	 * 
	 * @param panel
	 *            Parametro referenciado dentro do método
	 */
	private void buildBackButton(JPanel panel) {
		JButton backButton = new JButton("Voltar");
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResultFrame.this.dispose();
			}
		});
		panel.add(backButton, new GBC(1, 7).right().insets(10, 0, 10, 10));
	}

}

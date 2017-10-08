package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Report;

/**
 * Classe principal do sistema.
 * 
 * @author Emmanuel Kant
 *
 */
public class WorkFrame extends JFrame {
	/**
	 * Tabela que exibir� os cadastros de quem entrou no local e ainda est� no
	 * local.
	 */
	private JTable tableIn;
	/** Tabela que exibir� os cadastros de quem saiu do local. */
	private JTable tableOut;
	/**
	 * Modelo da tabela que armazena os dados de quem entrou no local. OBS:
	 * Quando uma pessoa entra no sistema, ela precisa estar cadastrada no
	 * sistema e caso esteja na lista de sa�da, ele ser� excluido da lista de
	 * sa�da e s� ent�o ser� adicionando na lista de entrada.
	 */
	private PersonInTableModel personInTM = new PersonInTableModel();
	/**
	 * Modelo da tabela que armazena os dados de quem saiu do local. As
	 * observa��es acima s�o v�lidas para esse atributo tamb�m. Caso a pessoa
	 * esteja na listaa dde entrada, ela ser� exclu�da da lista de entrada e
	 * ser� adicionada a lista de sa�da.
	 */
	private PersonOutTableModel personOutTM = new PersonOutTableModel();

	/**
	 * Costrutor da classe.
	 */
	public WorkFrame(JFrame jMainFrame) {
		buildFrame(jMainFrame);
	}

	/**
	 * M�todo que cria a janela es seus componentes.
	 * 
	 */
	private void buildFrame(JFrame jMainFrame) {
		setLayout(new GridBagLayout());
		buildComponents();
		buildContents();
		setTitle("Controle de Entrada e Sa�da");
		setSize(650, 300);
		setMinimumSize(new Dimension(650, 300));
		setLocationRelativeTo(jMainFrame);
		setDefaultCloseOperation(WorkFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			/**
			 * M�todo criado para confirmar a parada do sistema.
			 */
			public void windowClosing(WindowEvent e) {
				int answer = JOptionPane.showConfirmDialog(WorkFrame.this, "Voc� deseja realmente deslogar do programa?",
						"Aviso", JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					System.out.println(new Report().toString());
					new MainFrame();
					dispose();
					JOptionPane.showMessageDialog(null, "Usu�rio Deslogado!!!");
				}
			}
		});
		setVisible(true);
	}

	/**
	 * Constr�i o conte�do da tela.
	 */
	private void buildContents() {
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel inLabel = new JLabel("Tabela de Entrada");
		JLabel outLabel = new JLabel("Tabela de Sa�da");
		JButton newEntranceButton = new JButton("Nova Entrada");
		JButton newOutButton = new JButton("Nova Sa�da");
		// Configuran��es
		inLabel.setFont(new Font("SansSerif", 1, 18));
		outLabel.setFont(new Font("SansSerif", 1, 18));
		// A��es.
		newEntranceButton.addActionListener(new ActionListener() {

			/**
			 * M�todo que adiciona o um resgistro na lista de entrada.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				new EntranceRegistreDialog(WorkFrame.this);
				refreshTables();
			}
		});
		newOutButton.addActionListener(new ActionListener() {

			/**
			 * M�todo que adiciona o um resgistro na lista de sa�da.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				new OutRegistreDialog(WorkFrame.this);
				refreshTables();
			}
		});

		// Setando as posi��es.
		buildTables(panel);
		panel.add(inLabel, new GBC(0, 0).center().insets(5, 5, 5, 5));
		panel.add(outLabel, new GBC(1, 0).center().insets(5, 5, 5, 5));
		panel.add(newEntranceButton, new GBC(0, 2).center().insets(5, 5, 5, 5).horizontal());
		panel.add(newOutButton, new GBC(1, 2).center().insets(5, 5, 5, 5).horizontal());
		add(panel, new GBC(0, 0).both());
	}

	/**
	 * Constr�i os componentes que comp�e a tela.
	 */
	private void buildComponents() {
		// Criando todos os componentes do menu.
		JMenuBar menuBar = new JMenuBar();
		JMenu functionsMenu = new JMenu("Fun��es");
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem registreMenuItem = new JMenuItem("Cadastrar");
		JMenuItem consultMenuItem = new JMenuItem("Consultar");
		JMenuItem aboutMenuItem = new JMenuItem("Sobre");
		JMenuItem exitMenuItem = new JMenuItem("Deslogar");
		// Atribuindo a��es.
		consultMenuItem.addActionListener(new ActionListener() {

			/**
			 * M�todo que incializa a janela de consulta do sistema.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultDialog(WorkFrame.this);
				refreshTables();
			}
		});
		registreMenuItem.addActionListener(new ActionListener() {

			/**
			 * M�todo que inicializa a janela que criar� uma nova pessoa.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				new PersonDialog(WorkFrame.this);
				refreshTables();
			}
		});
		aboutMenuItem.addActionListener(new ActionListener() {
			
			/**
			 * M�todo que inicializa a janela com as informa��es dos criadores.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				new About(WorkFrame.this);
			}
		});
		exitMenuItem.addActionListener(new ActionListener() {
			
			/**
			 * M�todo que desloga o usuario, retornando para tela de loguin.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(WorkFrame.this, "Voc� deseja realmente deslogar do programa?",
						"Aviso", JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					System.out.println(new Report().toString());
					new MainFrame();
					dispose();
					JOptionPane.showMessageDialog(null, "Usu�rio Deslogado!!!");
				}
			}
		});
		// Colocando os bot�es na janela.
		menuBar.add(functionsMenu);
		functionsMenu.add(registreMenuItem);
		functionsMenu.add(consultMenuItem);
		menuBar.add(helpMenu);
		helpMenu.add(aboutMenuItem);
		helpMenu.add(exitMenuItem);
		setJMenuBar(menuBar);
	}

	/**
	 * M�todo que constr�i a tabela da janela.
	 * 
	 * @param panel
	 *            Painel da janela.
	 */
	private void buildTables(JPanel panel) {
		this.tableIn = new JTable(personInTM);
		this.tableOut = new JTable(personOutTM);
		JScrollPane scrollPaneIn = new JScrollPane(tableIn);
		JScrollPane scrollPaneOut = new JScrollPane(tableOut);
		panel.add(scrollPaneIn, new GBC(0, 1).both().insets(5, 5, 5, 5));
		panel.add(scrollPaneOut, new GBC(1, 1).both().insets(5, 5, 5, 5));
	}

	/**
	 * M�t�do utilizado para atualizar ambas as tabelas dessa janela.
	 */
	public void refreshTables() {
		personInTM.fireTableDataChanged();
		personOutTM.fireTableDataChanged();
	}

}

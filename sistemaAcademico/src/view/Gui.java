package view;

// EventQueue é usado para iniciar a interface gráfica na fila correta de eventos do Swing
import java.awt.EventQueue;

// Importações principais do Swing para criar a janela, painéis e componentes visuais
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

// Importações usadas para atalhos de teclado e eventos
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Importações dos componentes gráficos usados nas abas
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

/*
 * A classe Gui representa a tela principal do sistema.
 * 
 * Como ela extends JFrame, significa que essa classe é uma janela.
 */
public class Gui extends JFrame {

	/*
	 * serialVersionUID é criado automaticamente em classes que herdam JFrame.
	 * Ele é usado internamente pelo Java para controle de serialização.
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * contentPane é o painel principal da janela.
	 * É dentro dele que os outros componentes serão adicionados.
	 */
	private JPanel contentPane;
	
	/*
	 * Campos de texto declarados como atributos da classe.
	 * 
	 * Eles ficam aqui em cima porque podem ser usados em outros métodos futuramente,
	 * por exemplo, quando você for fazer botão de consultar, salvar, alterar etc.
	 */
	private JTextField tf_Resultado_Busca_Nome;
	private JTextField tf_Resultado_Busca_Curso;
	private JTextField tf_NomeBoletim;
	private JTextField tf_RgmBoletim;
	private JTextField tf_CursoBoletim;
	private JTextField tf_DisciplinaPoo;
	private JTextField tf_NotaBoletim;
	private JTextField tf_FaltasBoletim;
	private JTextField tf_BancoDadosBoletim;
	private JTextField tf_NotaBancoDadosBoletim;
	private JTextField tf_FaltasBancoDadosBoletim;
	private JTextField textField;
	private JTextField tf_NotaProgramacaoWebBoletim;
	private JTextField tf_FaltasProgramacaoWebBoletim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		/*
		 * EventQueue.invokeLater garante que a janela seja criada na thread correta do Swing.
		 * 
		 * Isso evita alguns problemas de carregamento da interface gráfica.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					// Cria um objeto da tela Gui
					Gui frame = new Gui();
					
					// Deixa a janela visível para o usuário
					frame.setVisible(true);
					
				} catch (Exception e) {
					
					// Caso aconteça algum erro ao abrir a tela, mostra o erro no console
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//============================================================================= INICIO DO FRAME =====================================================================
	// throws Exception serve para garantir que nao tenha erros no MaskFormatter
	public Gui() throws Exception {
		
		/*
		 * Define o comportamento ao clicar no X da janela.
		 * EXIT_ON_CLOSE fecha a janela e encerra o programa.
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * Define posição e tamanho da janela.
		 * 
		 * setBounds(x, y, largura, altura)
		 * x = posição horizontal na tela
		 * y = posição vertical na tela
		 */
		setBounds(100, 100, 573, 379);
		
		//Margem que guarda o menu superior
		
		// Cria a barra de menu superior da janela
		JMenuBar menuBar = new JMenuBar();
		
		// Adiciona a barra de menu ao JFrame
		setJMenuBar(menuBar);
		
		// Cria o menu "Aluno"
		JMenu mnAluno = new JMenu("Aluno");
		
		// Adiciona o menu "Aluno" na barra superior
		menuBar.add(mnAluno);
		
		// Cria o item "Salvar" dentro do menu Aluno
		JMenuItem mntmSalvar_Aluno = new JMenuItem("Salvar");
		
		/*
		 * Define um atalho para o item Salvar.
		 * Neste caso: CTRL + S
		 */
		mntmSalvar_Aluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		
		// Adiciona o item Salvar dentro do menu Aluno
		mnAluno.add(mntmSalvar_Aluno);
		
		// Cria o item Alterar dentro do menu Aluno
		JMenuItem mntmAlterar_Aluno = new JMenuItem("Alterar");
		mnAluno.add(mntmAlterar_Aluno);
		
		// Cria o item Consultar dentro do menu Aluno
		JMenuItem mntmConsultar_Aluno = new JMenuItem("Consultar");
		mnAluno.add(mntmConsultar_Aluno);
		
		// Cria o item Excluir dentro do menu Aluno
		JMenuItem mntmExcluir_Aluno = new JMenuItem("Excluir");
		mnAluno.add(mntmExcluir_Aluno);
		
		// Cria uma linha separadora dentro do menu
		JSeparator separator = new JSeparator();
		mnAluno.add(separator);
		
		//Botao para sair que esta dentro do menu superior Aluno
		JMenuItem mntmSair_Aluno = new JMenuItem("Sair");
		
		/*
		 * Adiciona uma ação ao item Sair.
		 * Quando o usuário clicar nesse item, o código dentro do actionPerformed será executado.
		 */
		mntmSair_Aluno.addActionListener(new ActionListener() {
			
			//Metodo para fechar o aplicativo
			public void actionPerformed(ActionEvent e) {
				
				// Encerra o programa
				System.exit(0);
			}
		});
		
		/*
		 * Define atalho para sair.
		 * Neste caso: SHIFT + R
		 */
		mntmSair_Aluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_DOWN_MASK));
		
		// Adiciona o item Sair dentro do menu Aluno
		mnAluno.add(mntmSair_Aluno);
		
		// Cria o menu Notas e Faltas
		JMenu mnNotasFaltas = new JMenu("Notas e Faltas");
		
		// Adiciona o menu Notas e Faltas na barra superior
		menuBar.add(mnNotasFaltas);
		
		// Cria item Salvar dentro do menu Notas e Faltas
		JMenuItem mntmSalvar_Nf = new JMenuItem("Salvar");
		mnNotasFaltas.add(mntmSalvar_Nf);
		
		// Cria item Alterar dentro do menu Notas e Faltas
		JMenuItem mntmAlterar_Nf = new JMenuItem("Alterar");
		
		// Define atalho CTRL + A para Alterar
		mntmAlterar_Nf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		mnNotasFaltas.add(mntmAlterar_Nf);
		
		// Cria item Excluir dentro do menu Notas e Faltas
		JMenuItem mntmExcluir_Nf = new JMenuItem("Excluir");
		mnNotasFaltas.add(mntmExcluir_Nf);
		
		// Cria item Consultar dentro do menu Notas e Faltas
		JMenuItem mntmConsultar_Nf = new JMenuItem("Consultar");
		mnNotasFaltas.add(mntmConsultar_Nf);
		
		//Menu Ajuda
		
		// Cria o menu Ajuda
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		//Botao Sobre no menu Ajuda
		JMenuItem mntmSobre_Ajuda = new JMenuItem("Sobre");
		
		/*
		 * Adiciona uma ação ao item Sobre.
		 * Quando clicar nele, aparece uma mensagem na tela.
		 */
		mntmSobre_Ajuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//====================
				//Comando para mostrar mensagem em uma nova janela ao apertar o botao
				JOptionPane.showMessageDialog(null,"informações do Menu");
				
				//====================
			}
		});
		
		// Adiciona o item Sobre dentro do menu Ajuda
		mnAjuda.add(mntmSobre_Ajuda);
		
		//====================== INICIO CONTENTPANE ==========================
		//Area de delimitacao do conteudo principal da janela
		
		// Cria o painel principal
		contentPane = new JPanel();
		
		// Define uma margem interna no painel principal
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Define o contentPane como painel principal da janela
		setContentPane(contentPane);
		
		/*
		 * Define layout null.
		 * 
		 * Isso significa que cada componente será posicionado manualmente
		 * usando setBounds().
		 */
		contentPane.setLayout(null);
		
		//======================= INICIO TABBEDPANE ==========================
		// Area de delimitacao do menu interno do sistema
		
		/*
		 * JTabbedPane cria abas dentro da tela.
		 * Exemplo: Dados Pessoais, Curso, Notas e Faltas, Boletim.
		 */
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		// Define posição e tamanho da área de abas
		tabbedPane.setBounds(10, 63, 537, 244);
		//======================= FIM TABBEDPANE ==========================
		
		// Adiciona o painel de abas dentro do painel principal
		contentPane.add(tabbedPane);
		
		//==================== INICIO MENU DADOS PESSOAIS ==========================
		/*
		 * lbl == LABEL
		 * ftf == FormattedTextField
		 * cb == COMBO BOX
		 * 
		 * JLabel = texto fixo na tela
		 * JFormattedTextField = campo de texto, podendo ter máscara
		 * JComboBox = caixa de seleção
		 * 
		 *==================== */
		
		// Cria o painel da aba Dados Pessoais
		JPanel panel_Dados_Pessoais = new JPanel();
		
		// Adiciona a aba Dados Pessoais no tabbedPane
		tabbedPane.addTab("Dados Pessoais", null, panel_Dados_Pessoais, null);
		
		// Define posicionamento manual dos componentes
		panel_Dados_Pessoais.setLayout(null);
		
		// Texto "RGM"
		JLabel lblRgm = new JLabel("RGM");
		lblRgm.setBounds(10, 11, 46, 14);
		panel_Dados_Pessoais.add(lblRgm);
		
		/*
		 * Campo de texto formatado para RGM.
		 * Máscara "########" permite 8 números.
		 */
		JFormattedTextField ftf_Rgm = new JFormattedTextField(new MaskFormatter("########"));
		ftf_Rgm.setBounds(48, 8, 103, 20);
		panel_Dados_Pessoais.add(ftf_Rgm);
		
		
		// Texto "Nome"
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(185, 11, 46, 14);
		panel_Dados_Pessoais.add(lblNome);
		
		// Campo para digitar o nome
		JFormattedTextField ftf_Nome = new JFormattedTextField();
		ftf_Nome.setBounds(241, 8, 281, 20);
		panel_Dados_Pessoais.add(ftf_Nome);
		
		// Texto "Data de Nascimento"
		JLabel lblDt_Nascmento = new JLabel("Data de Nascimento");
		lblDt_Nascmento.setBounds(10, 52, 103, 14);
		panel_Dados_Pessoais.add(lblDt_Nascmento);
		
		// Texto "CPF"
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(257, 52, 46, 14);
		panel_Dados_Pessoais.add(lblCpf);
		
		/*
		 * Campo formatado para CPF.
		 * A máscara definida é ###.###.###-#
		 */
		JFormattedTextField ftf_Cpf = new JFormattedTextField(new MaskFormatter("###.###.###-#"));
		ftf_Cpf.setBounds(293, 49, 229, 20);
		panel_Dados_Pessoais.add(ftf_Cpf);
		
		// Texto "Email"
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 98, 46, 14);
		panel_Dados_Pessoais.add(lblEmail);
		
		// Campo para digitar email
		JFormattedTextField ftf_Email = new JFormattedTextField();
		ftf_Email.setBounds(48, 95, 474, 20);
		panel_Dados_Pessoais.add(ftf_Email);
		
		// Texto "End."
		JLabel lblEndereco = new JLabel("End.");
		lblEndereco.setBounds(10, 135, 46, 14);
		panel_Dados_Pessoais.add(lblEndereco);
		
		// Campo para digitar endereço
		JFormattedTextField ftf_Endereco = new JFormattedTextField();
		ftf_Endereco.setBounds(48, 132, 474, 20);
		panel_Dados_Pessoais.add(ftf_Endereco);
		
		// Texto "Município"
		JLabel lblMunicipio = new JLabel("Município");
		lblMunicipio.setBounds(10, 171, 59, 14);
		panel_Dados_Pessoais.add(lblMunicipio);
		
		// Campo para digitar município
		JFormattedTextField ftf_Municipio = new JFormattedTextField();
		ftf_Municipio.setBounds(72, 168, 120, 20);
		panel_Dados_Pessoais.add(ftf_Municipio);
		
		// Texto "UF"
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(202, 171, 46, 14);
		panel_Dados_Pessoais.add(lblUf);
		
		// Texto "Celular"
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(278, 171, 46, 14);
		panel_Dados_Pessoais.add(lblCelular);
		
		/*
		 * Campo formatado para celular.
		 * Máscara: (##)#####-####
		 */
		JFormattedTextField ftf_Celular = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		ftf_Celular.setBounds(330, 168, 192, 20);
		panel_Dados_Pessoais.add(ftf_Celular);
		
		/*
		 * ComboBox para selecionar UF.
		 * DefaultComboBoxModel define as opções disponíveis na lista.
		 */
		JComboBox cb_Uf = new JComboBox();
		cb_Uf.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cb_Uf.setBounds(222, 167, 46, 22);
		panel_Dados_Pessoais.add(cb_Uf);
		
		// new MaskFormatter serve para formatar o campo
		
		// Campo formatado para data de nascimento no formato ##/##/####
		JFormattedTextField ftf_Dt_Nasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		ftf_Dt_Nasc.setBounds(113, 49, 118, 20);
		panel_Dados_Pessoais.add(ftf_Dt_Nasc);
		
		//==================== FIM MENU DADOS PESSOAIS ==========================
		
		//==================== INICIO MENU CURSO ==========================
		/*
		 * lbl == LABEL
		 * cb == COMBO BOX
		 * rdbtn == RADIO BUTTON
		 * btn == BUTTOM
		 * 
		 *==================== */
		
		// Cria painel da aba Curso
		JPanel panel_Curso = new JPanel();
		tabbedPane.addTab("Curso", null, panel_Curso, null);
		panel_Curso.setLayout(null);
		
		// Texto "Curso"
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(10, 11, 46, 14);
		panel_Curso.add(lblCurso);
		
		// ComboBox para selecionar o curso
		JComboBox cb_Curso = new JComboBox();
		cb_Curso.setModel(new DefaultComboBoxModel(new String[] {"Analise e desenvolvimento de sistemas", "Ciencia da computação"}));
		cb_Curso.setBounds(63, 7, 459, 22);
		panel_Curso.add(cb_Curso);
		
		// Texto "Campus"
		JLabel lblCampus = new JLabel("Campus");
		lblCampus.setBounds(10, 42, 46, 14);
		panel_Curso.add(lblCampus);
		
		// ComboBox para selecionar o campus
		JComboBox cb_Campus = new JComboBox();
		cb_Campus.setModel(new DefaultComboBoxModel(new String[] {"Tatuape", "Pinheiros/Villa-Lobos", "EAD"}));
		cb_Campus.setBounds(63, 40, 459, 22);
		panel_Curso.add(cb_Campus);
		
		// Texto "Período"
		JLabel lblNewLabel = new JLabel("Período");
		lblNewLabel.setBounds(10, 88, 46, 14);
		panel_Curso.add(lblNewLabel);
		
		
		// RadioButton para escolher período Matutino
		JRadioButton rdbtn_Matutino = new JRadioButton("Matutino");
		rdbtn_Matutino.setBounds(65, 84, 93, 23);
		panel_Curso.add(rdbtn_Matutino);
		
		// RadioButton para escolher período Vespertino
		JRadioButton rdbtn_Vespertino = new JRadioButton("Vespertino");
		rdbtn_Vespertino.setBounds(160, 84, 109, 23);
		panel_Curso.add(rdbtn_Vespertino);
		
		// RadioButton para escolher período Noturno
		JRadioButton rdbtn_Noturno = new JRadioButton("Noturno");
		rdbtn_Noturno.setBounds(267, 84, 109, 23);
		panel_Curso.add(rdbtn_Noturno);
		
		//Criação do objeto PERIODO, que tem a função de fazer com que todos os RadioButtons façam parte do mesmo grupo.
		ButtonGroup periodo = new ButtonGroup();
		
		//.ADD adiciona todos no mesmo grupo
		// Isso faz com que só uma opção de período possa ser selecionada por vez
		periodo.add(rdbtn_Matutino);
		periodo.add(rdbtn_Vespertino);
		periodo.add(rdbtn_Noturno);
		
		//---------------------------- BOTOES QUE NAO SABEMOS OQ FAZER ----------------------------------
		
		/*
		 * Botões criados na aba Curso.
		 * Ainda estão com texto "New button", então provavelmente serão renomeados depois
		 * para ações como Salvar, Alterar, Consultar, Excluir ou Limpar.
		 */
		
		JButton btnCursoSalvar = new JButton("");
		btnCursoSalvar.setIcon(new ImageIcon("C:\\Users\\Pichau\\Documents\\Projeto-Sistema-Academico-JAVA\\sistemaAcademico\\img\\salvar.png"));
		btnCursoSalvar.setBounds(10, 126, 93, 66);
		panel_Curso.add(btnCursoSalvar);
		
		JButton btnCursoAlterar = new JButton("");
		btnCursoAlterar.setIcon(new ImageIcon("C:\\Users\\Pichau\\Documents\\Projeto-Sistema-Academico-JAVA\\sistemaAcademico\\img\\alterar.png"));
		btnCursoAlterar.setBounds(138, 126, 93, 66);
		panel_Curso.add(btnCursoAlterar);
		
		JButton btnCursoConsultar = new JButton("");
		btnCursoConsultar.setIcon(new ImageIcon("C:\\Users\\Pichau\\Documents\\Projeto-Sistema-Academico-JAVA\\sistemaAcademico\\img\\consultar.png"));
		btnCursoConsultar.setBounds(298, 126, 89, 66);
		panel_Curso.add(btnCursoConsultar);
		
		JButton btnCursoExcluir = new JButton("");
		btnCursoExcluir.setIcon(new ImageIcon("C:\\Users\\Pichau\\Documents\\Projeto-Sistema-Academico-JAVA\\sistemaAcademico\\img\\excluir.png"));
		btnCursoExcluir.setBounds(433, 126, 89, 66);
		panel_Curso.add(btnCursoExcluir);
		
		
		//==================== FIM MENU CURSO ==========================
		
		//==================== INICIO MENU NOTAS E FALTAS ==========================
		/*
		 * lbl == LABEL
		 * cb == COMBO BOX
		 * rdbtn == RADIO BUTTON
		 * tf == TEXT FIELD
		 * btn == BUTTOM
		 * 
		 * Essa aba parece ser usada para pesquisar um aluno pelo RGM
		 * e cadastrar/consultar disciplina, semestre, nota e faltas.
		 * 
		 *==================== */
		
		// Cria painel da aba Notas e Faltas
		JPanel panel_Notas_Faltas = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_Notas_Faltas, null);
		panel_Notas_Faltas.setLayout(null);
		
		// Texto "RGM"
		JLabel lblRGM = new JLabel("RGM");
		lblRGM.setBounds(10, 11, 46, 14);
		panel_Notas_Faltas.add(lblRGM);
		
		// Campo para pesquisar o RGM
		JFormattedTextField ftf_Rgm_pesquisa = new JFormattedTextField();
		ftf_Rgm_pesquisa.setBounds(53, 8, 116, 20);
		panel_Notas_Faltas.add(ftf_Rgm_pesquisa);
		
		// Campo que provavelmente mostra o nome encontrado na pesquisa
		tf_Resultado_Busca_Nome = new JTextField();
		tf_Resultado_Busca_Nome.setBounds(179, 8, 343, 20);
		panel_Notas_Faltas.add(tf_Resultado_Busca_Nome);
		tf_Resultado_Busca_Nome.setColumns(10);
		
		//setEditable(false) serve para deixar o campo impossivel de adicionar texto
		// O usuário não digita aqui; o sistema preenche automaticamente
		tf_Resultado_Busca_Nome.setEditable(false);
		
		// Campo que provavelmente mostra o curso encontrado na pesquisa
		tf_Resultado_Busca_Curso = new JTextField();
		tf_Resultado_Busca_Curso.setBounds(10, 37, 512, 20);
		panel_Notas_Faltas.add(tf_Resultado_Busca_Curso);
		tf_Resultado_Busca_Curso.setColumns(10);
		
		// Campo bloqueado para edição manual
		tf_Resultado_Busca_Curso.setEditable(false);
		
		// Texto "Disciplina"
		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(10, 73, 64, 14);
		panel_Notas_Faltas.add(lblDisciplina);
		
		// ComboBox para selecionar disciplina
		JComboBox cb_Disciplina = new JComboBox();
		cb_Disciplina.setModel(new DefaultComboBoxModel(new String[] {"Programação Orientada a Objeto", "Banco de dados", "Programação WEB"}));
		cb_Disciplina.setBounds(72, 69, 450, 22);
		panel_Notas_Faltas.add(cb_Disciplina);
		
		// Texto "Semestre"
		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setBounds(10, 105, 64, 14);
		panel_Notas_Faltas.add(lblSemestre);
		
		// ComboBox para selecionar semestre
		JComboBox cb_Semestre = new JComboBox();
		cb_Semestre.setModel(new DefaultComboBoxModel(new String[] {"2025-1", "2025-2", "2026-1", "2026-2"}));
		cb_Semestre.setBounds(72, 101, 64, 22);
		panel_Notas_Faltas.add(cb_Semestre);
		
		// Texto "Nota"
		JLabel lblNota = new JLabel("Nota");
		lblNota.setBounds(146, 105, 46, 14);
		panel_Notas_Faltas.add(lblNota);
		
		// ComboBox para selecionar nota
		JComboBox cb_Nota = new JComboBox();
		cb_Nota.setModel(new DefaultComboBoxModel(new String[] {"0", "0,5", "1", "1,5", "2", "2,5", "3", "3,5", "4", "4,5", "5", "5,5", "6", "6,5", "7", "7,5", "8", "8,5", "9", "9,5", "10"}));
		cb_Nota.setBounds(179, 102, 46, 22);
		panel_Notas_Faltas.add(cb_Nota);
		
		// Texto "Faltas"
		JLabel lblFaltas = new JLabel("Faltas");
		lblFaltas.setBounds(235, 106, 46, 14);
		panel_Notas_Faltas.add(lblFaltas);
		
		// Campo para digitar quantidade de faltas
		JFormattedTextField ftf_Faltas = new JFormattedTextField();
		ftf_Faltas.setBounds(277, 102, 81, 20);
		panel_Notas_Faltas.add(ftf_Faltas);
		
		JButton btnNfSalvar = new JButton("");
		btnNfSalvar.setIcon(new ImageIcon("C:\\Users\\Pichau\\Documents\\Projeto-Sistema-Academico-JAVA\\sistemaAcademico\\img\\salvar.png"));
		btnNfSalvar.setBounds(10, 139, 93, 66);
		panel_Notas_Faltas.add(btnNfSalvar);
		
		JButton btnNfAlterar = new JButton("");
		btnNfAlterar.setIcon(new ImageIcon("C:\\Users\\Pichau\\Documents\\Projeto-Sistema-Academico-JAVA\\sistemaAcademico\\img\\alterar.png"));
		btnNfAlterar.setBounds(138, 139, 93, 66);
		panel_Notas_Faltas.add(btnNfAlterar);
		
		JButton btnNfConsultar = new JButton("");
		btnNfConsultar.setIcon(new ImageIcon("C:\\Users\\Pichau\\Documents\\Projeto-Sistema-Academico-JAVA\\sistemaAcademico\\img\\consultar.png"));
		btnNfConsultar.setBounds(298, 139, 89, 66);
		panel_Notas_Faltas.add(btnNfConsultar);
		
		JButton btnNfExcluir = new JButton("");
		btnNfExcluir.setIcon(new ImageIcon("C:\\Users\\Pichau\\Documents\\Projeto-Sistema-Academico-JAVA\\sistemaAcademico\\img\\excluir.png"));
		btnNfExcluir.setBounds(433, 139, 89, 66);
		panel_Notas_Faltas.add(btnNfExcluir);
		
		//==================== FIM MENU NOTAS E FALTAS ==========================
		
		//==================== INICIO MENU BOLETIM ==========================
		
		/*
		 * Aba Boletim.
		 * Essa aba tem vários campos bloqueados com setEditable(false),
		 * então ela parece ser feita mais para exibir informações do aluno.
		 */
		JPanel panel_Boletim = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_Boletim, null);
		panel_Boletim.setLayout(null);
		
		// Texto "Nome"
		JLabel lblNomeBoletim = new JLabel("Nome ");
		lblNomeBoletim.setBounds(10, 11, 46, 14);
		panel_Boletim.add(lblNomeBoletim);
		
		// Campo que mostra o nome no boletim
		tf_NomeBoletim = new JTextField();
		tf_NomeBoletim.setBounds(50, 8, 294, 20);
		panel_Boletim.add(tf_NomeBoletim);
		tf_NomeBoletim.setColumns(10);
		
		// Campo bloqueado para edição manual
		tf_NomeBoletim.setEditable(false);
		
		// Texto "RGM"
		JLabel lblRgmBoletim = new JLabel("RGM");
		lblRgmBoletim.setBounds(354, 11, 35, 14);
		panel_Boletim.add(lblRgmBoletim);
		
		// Campo que mostra o RGM no boletim
		tf_RgmBoletim = new JTextField();
		tf_RgmBoletim.setBounds(399, 8, 123, 20);
		panel_Boletim.add(tf_RgmBoletim);
		tf_RgmBoletim.setColumns(10);
		tf_RgmBoletim.setEditable(false);
		
		// Texto "Curso"
		JLabel lblCursoBoletim = new JLabel("Curso");
		lblCursoBoletim.setBounds(10, 39, 46, 14);
		panel_Boletim.add(lblCursoBoletim);
		
		// Campo que mostra o curso no boletim
		tf_CursoBoletim = new JTextField();
		tf_CursoBoletim.setBounds(50, 36, 472, 20);
		panel_Boletim.add(tf_CursoBoletim);
		tf_CursoBoletim.setColumns(10);
		tf_CursoBoletim.setEditable(false);
		
		// Texto da disciplina Programação Orientada a Objetos
		JLabel lblPooBoletim = new JLabel("Programação Orientada a Objetos");
		lblPooBoletim.setBounds(10, 64, 233, 14);
		panel_Boletim.add(lblPooBoletim);
		
		// Campo relacionado à disciplina POO
		tf_DisciplinaPoo = new JTextField();
		tf_DisciplinaPoo.setBounds(216, 61, 152, 20);
		panel_Boletim.add(tf_DisciplinaPoo);
		tf_DisciplinaPoo.setColumns(10);
		tf_DisciplinaPoo.setEditable(false);
		
		// Texto "Nota" da disciplina POO
		JLabel lblNotaPooBoletim = new JLabel("Nota");
		lblNotaPooBoletim.setBounds(10, 89, 46, 14);
		panel_Boletim.add(lblNotaPooBoletim);
		
		// Campo da nota de POO
		tf_NotaBoletim = new JTextField();
		tf_NotaBoletim.setBounds(48, 89, 46, 20);
		panel_Boletim.add(tf_NotaBoletim);
		tf_NotaBoletim.setColumns(10);
		tf_NotaBoletim.setEditable(false);
		
		// Texto "Faltas" da disciplina POO
		JLabel lblFaltasPooBoletim = new JLabel("Faltas");
		lblFaltasPooBoletim.setBounds(125, 89, 46, 14);
		panel_Boletim.add(lblFaltasPooBoletim);
		
		// Campo de faltas de POO
		tf_FaltasBoletim = new JTextField();
		tf_FaltasBoletim.setBounds(170, 89, 46, 20);
		panel_Boletim.add(tf_FaltasBoletim);
		tf_FaltasBoletim.setColumns(10);
		tf_FaltasBoletim.setEditable(false);
		
		// Texto da disciplina Banco de Dados
		JLabel lblBancoDadosBoletim = new JLabel("Banco de Dados");
		lblBancoDadosBoletim.setBounds(10, 120, 95, 14);
		panel_Boletim.add(lblBancoDadosBoletim);
		
		// Campo relacionado à disciplina Banco de Dados
		tf_BancoDadosBoletim = new JTextField();
		tf_BancoDadosBoletim.setBounds(115, 117, 138, 20);
		panel_Boletim.add(tf_BancoDadosBoletim);
		tf_BancoDadosBoletim.setColumns(10);
		tf_BancoDadosBoletim.setEditable(false);
		
		// Texto "Nota" de Banco de Dados
		JLabel lblNotaBancoDadosBoletim = new JLabel("Nota");
		lblNotaBancoDadosBoletim.setBounds(10, 145, 46, 14);
		panel_Boletim.add(lblNotaBancoDadosBoletim);
		
		// Campo da nota de Banco de Dados
		tf_NotaBancoDadosBoletim = new JTextField();
		tf_NotaBancoDadosBoletim.setEditable(false);
		tf_NotaBancoDadosBoletim.setColumns(10);
		tf_NotaBancoDadosBoletim.setBounds(48, 142, 46, 20);
		panel_Boletim.add(tf_NotaBancoDadosBoletim);
		
		// Texto "Faltas" de Banco de Dados
		JLabel lblFaltasBancoDadosBoletim = new JLabel("Faltas");
		lblFaltasBancoDadosBoletim.setBounds(125, 145, 46, 14);
		panel_Boletim.add(lblFaltasBancoDadosBoletim);
		
		// Campo de faltas de Banco de Dados
		tf_FaltasBancoDadosBoletim = new JTextField();
		tf_FaltasBancoDadosBoletim.setEditable(false);
		tf_FaltasBancoDadosBoletim.setColumns(10);
		tf_FaltasBancoDadosBoletim.setBounds(170, 142, 46, 20);
		panel_Boletim.add(tf_FaltasBancoDadosBoletim);
		
		// Texto da disciplina Programação WEB
		JLabel lblProgramacaoWebBoletim = new JLabel("Programação WEB");
		lblProgramacaoWebBoletim.setBounds(10, 170, 116, 14);
		panel_Boletim.add(lblProgramacaoWebBoletim);
		
		// Campo relacionado à disciplina Programação WEB
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(135, 167, 138, 20);
		panel_Boletim.add(textField);
		
		// Texto "Nota" de Programação WEB
		JLabel lblNotaProgramacaoWebBoletim = new JLabel("Nota");
		lblNotaProgramacaoWebBoletim.setBounds(10, 198, 46, 14);
		panel_Boletim.add(lblNotaProgramacaoWebBoletim);
		
		// Campo da nota de Programação WEB
		tf_NotaProgramacaoWebBoletim = new JTextField();
		tf_NotaProgramacaoWebBoletim.setEditable(false);
		tf_NotaProgramacaoWebBoletim.setColumns(10);
		tf_NotaProgramacaoWebBoletim.setBounds(48, 195, 46, 20);
		panel_Boletim.add(tf_NotaProgramacaoWebBoletim);
		
		// Texto "Faltas" de Programação WEB
		JLabel lblFaltasProgramacaoWebBoletim = new JLabel("Faltas");
		lblFaltasProgramacaoWebBoletim.setBounds(125, 198, 46, 14);
		panel_Boletim.add(lblFaltasProgramacaoWebBoletim);
		
		// Campo de faltas de Programação WEB
		tf_FaltasProgramacaoWebBoletim = new JTextField();
		tf_FaltasProgramacaoWebBoletim.setEditable(false);
		tf_FaltasProgramacaoWebBoletim.setColumns(10);
		tf_FaltasProgramacaoWebBoletim.setBounds(170, 195, 46, 20);
		panel_Boletim.add(tf_FaltasProgramacaoWebBoletim);
		
		//==================== FIM MENU BOLETIM ==========================
		//======================== FIM CONTENTPANE ==========================

	}	//============================================================================= FIM DO FRAME =====================================================================
}
package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import dao.LeitorDAO;
import model.Aluno;
import model.AlunoCursoNota;
import model.Curso;
import model.Nota;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField tf_Resultado_Busca_Nome;
	private JTextField tf_Resultado_Busca_Curso;
	private JTextField tf_NomeBoletim;
	private JTextField tf_RgmBoletim;
	private JTextField tf_CursoBoletim;
	private JTextField tf_NotaBoletim;
	private JTextField tf_FaltasBoletim;
	private JTextField tf_NotaBancoDadosBoletim;
	private JTextField tf_FaltasBancoDadosBoletim;
	private JTextField tf_NotaProgramacaoWebBoletim;
	private JTextField tf_FaltasProgramacaoWebBoletim;

	private Aluno aluno;
	private Curso curso;
	private Nota nota;
	private AlunoCursoNota alunoCursoNota;
	private LeitorDAO dao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gui() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 379);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAluno = new JMenu("Aluno e Curso");
		menuBar.add(mnAluno);

		JMenuItem mntmSalvar_Aluno_Curso = new JMenuItem("Salvar");
		mntmSalvar_Aluno_Curso.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnAluno.add(mntmSalvar_Aluno_Curso);

		JMenuItem mntmAlterar_Aluno = new JMenuItem("Alterar");
		mnAluno.add(mntmAlterar_Aluno);

		JMenuItem mntmConsultar_Aluno = new JMenuItem("Consultar");
		mnAluno.add(mntmConsultar_Aluno);

		JMenuItem mntmExcluir_Aluno = new JMenuItem("Excluir");
		mnAluno.add(mntmExcluir_Aluno);

		JSeparator separator = new JSeparator();
		mnAluno.add(separator);

		JMenuItem mntmSair_Aluno = new JMenuItem("Sair");
		mntmSair_Aluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_DOWN_MASK));
		mnAluno.add(mntmSair_Aluno);

		JMenu mnNotasFaltas = new JMenu("Notas e Faltas");
		menuBar.add(mnNotasFaltas);

		JMenuItem mntmSalvar_Nf = new JMenuItem("Salvar");
		mnNotasFaltas.add(mntmSalvar_Nf);

		JMenuItem mntmAlterar_Nf = new JMenuItem("Alterar");
		mntmAlterar_Nf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		mnNotasFaltas.add(mntmAlterar_Nf);

		JMenuItem mntmExcluir_Nf = new JMenuItem("Excluir");
		mnNotasFaltas.add(mntmExcluir_Nf);

		JMenuItem mntmConsultar_Nf = new JMenuItem("Consultar");
		mnNotasFaltas.add(mntmConsultar_Nf);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobre_Ajuda = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre_Ajuda);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 63, 537, 244);
		contentPane.add(tabbedPane);

		JPanel panel_Dados_Pessoais = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel_Dados_Pessoais, null);
		panel_Dados_Pessoais.setLayout(null);

		JLabel lblRgm = new JLabel("RGM");
		lblRgm.setBounds(10, 11, 46, 14);
		panel_Dados_Pessoais.add(lblRgm);

		JFormattedTextField ftf_Rgm = new JFormattedTextField(new MaskFormatter("########"));
		ftf_Rgm.setBounds(48, 8, 103, 20);
		panel_Dados_Pessoais.add(ftf_Rgm);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(185, 11, 46, 14);
		panel_Dados_Pessoais.add(lblNome);

		JFormattedTextField ftf_Nome = new JFormattedTextField();
		ftf_Nome.setBounds(241, 8, 281, 20);
		panel_Dados_Pessoais.add(ftf_Nome);

		JLabel lblDt_Nascmento = new JLabel("Data de Nascimento");
		lblDt_Nascmento.setBounds(10, 52, 103, 14);
		panel_Dados_Pessoais.add(lblDt_Nascmento);

		JFormattedTextField ftf_Dt_Nasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		ftf_Dt_Nasc.setBounds(113, 49, 118, 20);
		panel_Dados_Pessoais.add(ftf_Dt_Nasc);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(257, 52, 46, 14);
		panel_Dados_Pessoais.add(lblCpf);

		JFormattedTextField ftf_Cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		ftf_Cpf.setBounds(293, 49, 229, 20);
		panel_Dados_Pessoais.add(ftf_Cpf);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 98, 46, 14);
		panel_Dados_Pessoais.add(lblEmail);

		JFormattedTextField ftf_Email = new JFormattedTextField();
		ftf_Email.setBounds(48, 95, 474, 20);
		panel_Dados_Pessoais.add(ftf_Email);

		JLabel lblEndereco = new JLabel("End.");
		lblEndereco.setBounds(10, 135, 46, 14);
		panel_Dados_Pessoais.add(lblEndereco);

		JFormattedTextField ftf_Endereco = new JFormattedTextField();
		ftf_Endereco.setBounds(48, 132, 474, 20);
		panel_Dados_Pessoais.add(ftf_Endereco);

		JLabel lblMunicipio = new JLabel("Município");
		lblMunicipio.setBounds(10, 171, 59, 14);
		panel_Dados_Pessoais.add(lblMunicipio);

		JFormattedTextField ftf_Municipio = new JFormattedTextField();
		ftf_Municipio.setBounds(72, 168, 120, 20);
		panel_Dados_Pessoais.add(ftf_Municipio);

		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(202, 171, 46, 14);
		panel_Dados_Pessoais.add(lblUf);

		JComboBox cb_Uf = new JComboBox();
		cb_Uf.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cb_Uf.setBounds(222, 167, 46, 22);
		panel_Dados_Pessoais.add(cb_Uf);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(278, 171, 46, 14);
		panel_Dados_Pessoais.add(lblCelular);

		JFormattedTextField ftf_Celular = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		ftf_Celular.setBounds(330, 168, 192, 20);
		panel_Dados_Pessoais.add(ftf_Celular);

		JPanel panel_Curso = new JPanel();
		tabbedPane.addTab("Curso", null, panel_Curso, null);
		panel_Curso.setLayout(null);

		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(10, 11, 46, 14);
		panel_Curso.add(lblCurso);

		JComboBox cb_Curso = new JComboBox();
		cb_Curso.setModel(new DefaultComboBoxModel(new String[] {"Analise e desenvolvimento de sistemas", "Ciencia da computação"}));
		cb_Curso.setBounds(63, 7, 459, 22);
		panel_Curso.add(cb_Curso);

		JLabel lblCampus = new JLabel("Campus");
		lblCampus.setBounds(10, 42, 59, 14);
		panel_Curso.add(lblCampus);

		JComboBox cb_Campus = new JComboBox();
		cb_Campus.setModel(new DefaultComboBoxModel(new String[] {"Tatuape", "Villa-Lobos", "EAD"}));
		cb_Campus.setBounds(63, 40, 459, 22);
		panel_Curso.add(cb_Campus);

		JLabel lblPeriodo = new JLabel("Período");
		lblPeriodo.setBounds(10, 88, 46, 14);
		panel_Curso.add(lblPeriodo);

		JRadioButton rdbtn_Matutino = new JRadioButton("Matutino");
		rdbtn_Matutino.setBounds(65, 84, 93, 23);
		panel_Curso.add(rdbtn_Matutino);

		JRadioButton rdbtn_Vespertino = new JRadioButton("Vespertino");
		rdbtn_Vespertino.setBounds(160, 84, 109, 23);
		panel_Curso.add(rdbtn_Vespertino);

		JRadioButton rdbtn_Noturno = new JRadioButton("Noturno");
		rdbtn_Noturno.setBounds(267, 84, 109, 23);
		panel_Curso.add(rdbtn_Noturno);

		ButtonGroup periodo = new ButtonGroup();
		periodo.add(rdbtn_Matutino);
		periodo.add(rdbtn_Vespertino);
		periodo.add(rdbtn_Noturno);

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

		JPanel panel_Notas_Faltas = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_Notas_Faltas, null);
		panel_Notas_Faltas.setLayout(null);

		JLabel lblRGM = new JLabel("RGM");
		lblRGM.setBounds(10, 11, 46, 14);
		panel_Notas_Faltas.add(lblRGM);

		JFormattedTextField ftf_Rgm_pesquisa = new JFormattedTextField(new MaskFormatter("########"));
		ftf_Rgm_pesquisa.setBounds(53, 8, 116, 20);
		panel_Notas_Faltas.add(ftf_Rgm_pesquisa);

		tf_Resultado_Busca_Nome = new JTextField();
		tf_Resultado_Busca_Nome.setBounds(179, 8, 343, 20);
		panel_Notas_Faltas.add(tf_Resultado_Busca_Nome);
		tf_Resultado_Busca_Nome.setColumns(10);
		tf_Resultado_Busca_Nome.setEditable(false);

		tf_Resultado_Busca_Curso = new JTextField();
		tf_Resultado_Busca_Curso.setBounds(10, 37, 512, 20);
		panel_Notas_Faltas.add(tf_Resultado_Busca_Curso);
		tf_Resultado_Busca_Curso.setColumns(10);
		tf_Resultado_Busca_Curso.setEditable(false);

		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(10, 73, 64, 14);
		panel_Notas_Faltas.add(lblDisciplina);

		JComboBox cb_Disciplina = new JComboBox();
		cb_Disciplina.setModel(new DefaultComboBoxModel(new String[] {"Programação Orientada a Objeto", "Banco de dados", "Programação WEB"}));
		cb_Disciplina.setBounds(72, 69, 450, 22);
		panel_Notas_Faltas.add(cb_Disciplina);

		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setBounds(10, 105, 64, 14);
		panel_Notas_Faltas.add(lblSemestre);

		JComboBox cb_Semestre = new JComboBox();
		cb_Semestre.setModel(new DefaultComboBoxModel(new String[] {"1º", "2º", "3º", "4º", "5º", "6º", "7º", "8º"}));
		cb_Semestre.setBounds(72, 101, 64, 22);
		panel_Notas_Faltas.add(cb_Semestre);

		JLabel lblNota = new JLabel("Nota");
		lblNota.setBounds(146, 105, 46, 14);
		panel_Notas_Faltas.add(lblNota);

		JComboBox cb_Nota = new JComboBox();
		cb_Nota.setModel(new DefaultComboBoxModel(new String[] {"0", "0,5", "1", "1,5", "2", "2,5", "3", "3,5", "4", "4,5", "5", "5,5", "6", "6,5", "7", "7,5", "8", "8,5", "9", "9,5", "10"}));
		cb_Nota.setBounds(179, 102, 46, 22);
		panel_Notas_Faltas.add(cb_Nota);

		JLabel lblFaltas = new JLabel("Faltas");
		lblFaltas.setBounds(235, 106, 46, 14);
		panel_Notas_Faltas.add(lblFaltas);

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

		JPanel panel_Boletim = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_Boletim, null);
		panel_Boletim.setLayout(null);

		JLabel lblNomeBoletim = new JLabel("Nome ");
		lblNomeBoletim.setBounds(183, 11, 46, 14);
		panel_Boletim.add(lblNomeBoletim);

		tf_NomeBoletim = new JTextField();
		tf_NomeBoletim.setBounds(226, 8, 296, 20);
		panel_Boletim.add(tf_NomeBoletim);
		tf_NomeBoletim.setColumns(10);
		tf_NomeBoletim.setEditable(false);

		JLabel lblRgmBoletim = new JLabel("RGM");
		lblRgmBoletim.setBounds(10, 11, 35, 14);
		panel_Boletim.add(lblRgmBoletim);

		tf_RgmBoletim = new JFormattedTextField(new MaskFormatter("########"));
		tf_RgmBoletim.setBounds(50, 8, 123, 20);
		panel_Boletim.add(tf_RgmBoletim);

		JLabel lblCursoBoletim = new JLabel("Curso");
		lblCursoBoletim.setBounds(10, 39, 46, 14);
		panel_Boletim.add(lblCursoBoletim);

		tf_CursoBoletim = new JTextField();
		tf_CursoBoletim.setBounds(50, 36, 472, 20);
		panel_Boletim.add(tf_CursoBoletim);
		tf_CursoBoletim.setColumns(10);
		tf_CursoBoletim.setEditable(false);

		JLabel lblPooBoletim = new JLabel("Programação Orientada a Objetos");
		lblPooBoletim.setBounds(10, 64, 233, 14);
		panel_Boletim.add(lblPooBoletim);

		JLabel lblNotaPooBoletim = new JLabel("Nota");
		lblNotaPooBoletim.setBounds(10, 89, 46, 14);
		panel_Boletim.add(lblNotaPooBoletim);

		tf_NotaBoletim = new JTextField();
		tf_NotaBoletim.setBounds(50, 89, 46, 20);
		panel_Boletim.add(tf_NotaBoletim);
		tf_NotaBoletim.setColumns(10);
		tf_NotaBoletim.setEditable(false);

		JLabel lblFaltasPooBoletim = new JLabel("Faltas");
		lblFaltasPooBoletim.setBounds(125, 89, 46, 14);
		panel_Boletim.add(lblFaltasPooBoletim);

		tf_FaltasBoletim = new JTextField();
		tf_FaltasBoletim.setBounds(170, 89, 46, 20);
		panel_Boletim.add(tf_FaltasBoletim);
		tf_FaltasBoletim.setColumns(10);
		tf_FaltasBoletim.setEditable(false);

		JLabel lblBancoDadosBoletim = new JLabel("Banco de Dados");
		lblBancoDadosBoletim.setBounds(10, 120, 95, 14);
		panel_Boletim.add(lblBancoDadosBoletim);

		JLabel lblNotaBancoDadosBoletim = new JLabel("Nota");
		lblNotaBancoDadosBoletim.setBounds(10, 145, 46, 14);
		panel_Boletim.add(lblNotaBancoDadosBoletim);

		tf_NotaBancoDadosBoletim = new JTextField();
		tf_NotaBancoDadosBoletim.setEditable(false);
		tf_NotaBancoDadosBoletim.setColumns(10);
		tf_NotaBancoDadosBoletim.setBounds(50, 145, 46, 20);
		panel_Boletim.add(tf_NotaBancoDadosBoletim);

		JLabel lblFaltasBancoDadosBoletim = new JLabel("Faltas");
		lblFaltasBancoDadosBoletim.setBounds(125, 145, 46, 14);
		panel_Boletim.add(lblFaltasBancoDadosBoletim);

		tf_FaltasBancoDadosBoletim = new JTextField();
		tf_FaltasBancoDadosBoletim.setEditable(false);
		tf_FaltasBancoDadosBoletim.setColumns(10);
		tf_FaltasBancoDadosBoletim.setBounds(170, 142, 46, 20);
		panel_Boletim.add(tf_FaltasBancoDadosBoletim);

		JLabel lblProgramacaoWebBoletim = new JLabel("Programação WEB");
		lblProgramacaoWebBoletim.setBounds(10, 170, 116, 14);
		panel_Boletim.add(lblProgramacaoWebBoletim);

		JLabel lblNotaProgramacaoWebBoletim = new JLabel("Nota");
		lblNotaProgramacaoWebBoletim.setBounds(10, 198, 46, 14);
		panel_Boletim.add(lblNotaProgramacaoWebBoletim);

		tf_NotaProgramacaoWebBoletim = new JTextField();
		tf_NotaProgramacaoWebBoletim.setEditable(false);
		tf_NotaProgramacaoWebBoletim.setColumns(10);
		tf_NotaProgramacaoWebBoletim.setBounds(50, 195, 46, 20);
		panel_Boletim.add(tf_NotaProgramacaoWebBoletim);

		JLabel lblFaltasProgramacaoWebBoletim = new JLabel("Faltas");
		lblFaltasProgramacaoWebBoletim.setBounds(125, 198, 46, 14);
		panel_Boletim.add(lblFaltasProgramacaoWebBoletim);

		tf_FaltasProgramacaoWebBoletim = new JTextField();
		tf_FaltasProgramacaoWebBoletim.setEditable(false);
		tf_FaltasProgramacaoWebBoletim.setColumns(10);
		tf_FaltasProgramacaoWebBoletim.setBounds(170, 195, 46, 20);
		panel_Boletim.add(tf_FaltasProgramacaoWebBoletim);

		JButton btnConsultarBoletim = new JButton("");
		btnConsultarBoletim.setIcon(new ImageIcon("C:\\Users\\Pichau\\Documents\\Projeto-Sistema-Academico-JAVA\\sistemaAcademico\\img\\consultar.png"));
		btnConsultarBoletim.setBounds(451, 132, 71, 73);
		panel_Boletim.add(btnConsultarBoletim);
		
		JLabel lblSelecionarSemestre = new JLabel("Selecionar Semestre");
		lblSelecionarSemestre.setBounds(343, 64, 123, 14);
		panel_Boletim.add(lblSelecionarSemestre);
		
		JComboBox bc_Selecionar_Semestre = new JComboBox();
		bc_Selecionar_Semestre.setModel(new DefaultComboBoxModel(new String[] {"1º", "2º", "3º", "4º", "5º", "6º", "7º", "8º"}));
		bc_Selecionar_Semestre.setBounds(476, 62, 46, 22);
		panel_Boletim.add(bc_Selecionar_Semestre);

		// Botões gerais da tela principal, posicionados abaixo das abas/campos
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(458, 39, 89, 23);
		contentPane.add(btnNovo);

		mntmSalvar_Aluno_Curso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					aluno = new Aluno();

					aluno.setRgm(ftf_Rgm.getText());
					aluno.setNome(ftf_Nome.getText());

					String dataTela = ftf_Dt_Nasc.getText();
					String[] partes = dataTela.split("/");
					String dataBanco = partes[2] + "-" + partes[1] + "-" + partes[0];
					aluno.setData_nasc(dataBanco);

					aluno.setCpf(ftf_Cpf.getText().replace(".", "").replace("-", ""));
					aluno.setEmail(ftf_Email.getText());
					aluno.setEndereco(ftf_Endereco.getText());
					aluno.setMunicipio(ftf_Municipio.getText());
					aluno.setUf((String) cb_Uf.getSelectedItem());
					aluno.setNumero(ftf_Celular.getText());

					curso = new Curso();

					curso.setCurso((String) cb_Curso.getSelectedItem());
					curso.setCampus((String) cb_Campus.getSelectedItem());

					String periodoSelecionado = "";

					if (rdbtn_Matutino.isSelected()) {
						periodoSelecionado = "Matutino";
					} else if (rdbtn_Vespertino.isSelected()) {
						periodoSelecionado = "Vespertino";
					} else if (rdbtn_Noturno.isSelected()) {
						periodoSelecionado = "Noturno";
					}

					if (periodoSelecionado.equals("")) {
						JOptionPane.showMessageDialog(null, "Selecione um período!");
						return;
					}

					curso.setPeriodo(periodoSelecionado);

					alunoCursoNota = new AlunoCursoNota(aluno, curso, null);

					dao = new LeitorDAO();
					dao.salvarAlunoCurso(alunoCursoNota);

					JOptionPane.showMessageDialog(null, "Aluno e curso salvos com sucesso!");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO: " + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});

		btnCursoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Reaproveita a mesma ação do menu Salvar Aluno e Curso
				mntmSalvar_Aluno_Curso.doClick();
			}
		});

		mntmSalvar_Nf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nota = new Nota();
					
					nota.setRgm(ftf_Rgm_pesquisa.getText());
					nota.setDisciplina((String) cb_Disciplina.getSelectedItem());
					nota.setSemestre((String) cb_Semestre.getSelectedItem());
					nota.setNota((String) cb_Nota.getSelectedItem());
					nota.setFaltas(Integer.parseInt(ftf_Faltas.getText()));
					
					dao = new LeitorDAO();
					dao.salvarNota(nota);
					
					JOptionPane.showMessageDialog(null, "Nota salva com sucesso!");
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO: " + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});

		btnNfSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmSalvar_Nf.doClick();
			}
		});

		mntmSair_Aluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		mntmSobre_Ajuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "informações do Menu");
			}
		});

		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ftf_Rgm.setText(null);
				ftf_Nome.setText(null);
				ftf_Dt_Nasc.setText(null);
				ftf_Cpf.setText(null);
				ftf_Email.setText(null);
				ftf_Endereco.setText(null);
				ftf_Municipio.setText(null);
				ftf_Celular.setText(null);
				ftf_Rgm_pesquisa.setText(null);
				tf_Resultado_Busca_Nome.setText(null);
				tf_Resultado_Busca_Curso.setText(null);
				ftf_Faltas.setText(null);
				tf_RgmBoletim.setText(null);
				tf_NomeBoletim.setText(null);
				tf_CursoBoletim.setText(null);
				tf_NotaBoletim.setText(null);
				tf_FaltasBoletim.setText(null);
				tf_NotaBancoDadosBoletim.setText(null);
				tf_FaltasBancoDadosBoletim.setText(null);
				tf_NotaProgramacaoWebBoletim.setText(null);
				tf_FaltasProgramacaoWebBoletim.setText(null);
				cb_Uf.setSelectedIndex(0);
				cb_Curso.setSelectedIndex(0);
				cb_Campus.setSelectedIndex(0);
				cb_Disciplina.setSelectedIndex(0);
				cb_Semestre.setSelectedIndex(0);
				cb_Nota.setSelectedIndex(0);
				periodo.clearSelection();
			}
		});
	}
}
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Curso;
import model.AlunoCurso;
import util.ConnectionFactory;

// Classe DAO responsável por fazer o CRUD no banco de dados.
public class LeitorDAO {
	
	// Objetos usados dentro dos métodos
	private Aluno aluno;
	private Curso curso;
	private AlunoCurso alunoCurso;
	
	// Objeto responsável pela conexão com o banco
	private Connection conn;
	
	// Objeto usado para preparar e executar comandos SQL com ?
	private PreparedStatement ps;
	
	// Objeto usado para receber resultados de SELECT
	private ResultSet rs;
	
	/*
	 * Construtor da classe.
	 * Toda vez que você cria um LeitorDAO, ele tenta abrir conexão com o banco.
	 */
	public LeitorDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection(); 
		} catch(Exception e) {
			throw new Exception("ERRO AO CONECTAR: " + e.getMessage());
		}
	}
	
	/*
	 * MÉTODO SALVAR
	 * 
	 * Salva os dados nas duas tabelas:
	 * 1º salva o aluno na tb_aluno
	 * 2º salva o curso na tb_curso usando o RGM do aluno como fk_rgm
	 */
	public void salvar(AlunoCurso alunoCurso) throws Exception {
		try {
			
			// Pegando o Aluno e o Curso que estão dentro do objeto AlunoCurso
			Aluno aluno = alunoCurso.getAluno();
			Curso curso = alunoCurso.getCurso();
			
			/*
			 * INSERT da tabela tb_aluno.
			 * Cada ? será preenchido com ps.setString(), seguindo a ordem.
			 */
			String sqlAluno = "INSERT INTO tb_aluno(pk_rgm, pk_cpf, nome, data_nasc, email, numero, endereco, complemento, municipio, uf) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sqlAluno);
			
			// 1º ? = pk_rgm
			ps.setString(1, aluno.getRgm());
			
			// 2º ? = pk_cpf
			ps.setString(2, aluno.getCpf());
			
			// 3º ? = nome
			ps.setString(3, aluno.getNome());
			
			// 4º ? = data_nasc
			ps.setString(4, aluno.getData_nasc());
			
			// 5º ? = email
			ps.setString(5, aluno.getEmail());
			
			// 6º ? = numero
			ps.setString(6, aluno.getNumero());
			
			// 7º ? = endereco
			ps.setString(7, aluno.getEndereco());
			
			// 8º ? = complemento
			ps.setString(8, aluno.getComplemento());
			
			// 9º ? = municipio
			ps.setString(9, aluno.getMunicipio());
			
			// 10º ? = uf
			ps.setString(10, aluno.getUf());
			
			// Executa o INSERT na tb_aluno
			ps.executeUpdate();
			
			/*
			 * INSERT da tabela tb_curso.
			 * 
			 * O fk_rgm recebe aluno.getRgm().
			 * Isso liga o curso ao aluno cadastrado.
			 */
			String sqlCurso = "INSERT INTO tb_curso(curso, campus, periodo, nota, semestre, faltas, disciplina, fk_rgm) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sqlCurso);
			
			// 1º ? = curso
			ps.setString(1, curso.getCurso());
			
			// 2º ? = campus
			ps.setString(2, curso.getCampus());
			
			// 3º ? = periodo
			ps.setString(3, curso.getPeriodo());
			
			// 4º ? = nota
			ps.setFloat(4, curso.getNota());
			
			// 5º ? = semestre
			ps.setString(5, curso.getSemestre());
			
			// 6º ? = faltas
			ps.setInt(6, curso.getFaltas());
			
			// 7º ? = disciplina
			ps.setString(7, curso.getDisciplina());
			
			// 8º ? = fk_rgm
			ps.setString(8, aluno.getRgm());
			
			// Executa o INSERT na tb_curso
			ps.executeUpdate();
			
		} catch(Exception e) {
			throw new Exception("ERRO AO SALVAR: " + e.getMessage());
		}
	}
	
	/*
	 * MÉTODO ALTERAR
	 * 
	 * Altera os dados nas duas tabelas:
	 * 1º altera tb_aluno pelo pk_rgm
	 * 2º altera tb_curso pelo fk_rgm
	 */
	public void alterar(AlunoCurso alunoCurso) throws Exception {
		try {
			
			Aluno aluno = alunoCurso.getAluno();
			Curso curso = alunoCurso.getCurso();
			
			/*
			 * UPDATE da tabela tb_aluno.
			 * 
			 * O WHERE pk_rgm = ? define qual aluno será alterado.
			 */
			String sqlAluno = "UPDATE tb_aluno SET pk_cpf = ?, nome = ?, data_nasc = ?, email = ?, numero = ?, endereco = ?, complemento = ?, municipio = ?, uf = ? "
					+ "WHERE pk_rgm = ?";
			
			ps = conn.prepareStatement(sqlAluno);
			
			ps.setString(1, aluno.getCpf());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getData_nasc());
			ps.setString(4, aluno.getEmail());
			ps.setString(5, aluno.getNumero());
			ps.setString(6, aluno.getEndereco());
			ps.setString(7, aluno.getComplemento());
			ps.setString(8, aluno.getMunicipio());
			ps.setString(9, aluno.getUf());
			
			// Esse último ? é do WHERE pk_rgm = ?
			ps.setString(10, aluno.getRgm());
			
			ps.executeUpdate();
			
			/*
			 * UPDATE da tabela tb_curso.
			 * 
			 * O WHERE fk_rgm = ? altera o curso ligado ao aluno.
			 */
			String sqlCurso = "UPDATE tb_curso SET curso = ?, campus = ?, periodo = ?, nota = ?, semestre = ?, faltas = ?, disciplina = ? "
					+ "WHERE fk_rgm = ?";
			
			ps = conn.prepareStatement(sqlCurso);
			
			ps.setString(1, curso.getCurso());
			ps.setString(2, curso.getCampus());
			ps.setString(3, curso.getPeriodo());
			ps.setFloat(4, curso.getNota());
			ps.setString(5, curso.getSemestre());
			ps.setInt(6, curso.getFaltas());
			ps.setString(7, curso.getDisciplina());
			
			// Esse último ? é do WHERE fk_rgm = ?
			ps.setString(8, aluno.getRgm());
			
			ps.executeUpdate();
			
		} catch(Exception e) {
			throw new Exception("ERRO AO ALTERAR: " + e.getMessage());
		}
	}
	
	/*
	 * MÉTODO EXCLUIR
	 * 
	 * Exclui primeiro da tb_curso e depois da tb_aluno.
	 * 
	 * Por que nessa ordem?
	 * Porque tb_curso tem fk_rgm, ou seja, depende do aluno.
	 * Se tentar excluir o aluno primeiro, o banco pode bloquear por causa da chave estrangeira.
	 */
	public void excluir(String rgm) throws Exception {
		try {
			
			// Primeiro exclui o curso ligado ao aluno
			String sqlCurso = "DELETE FROM tb_curso WHERE fk_rgm = ?";
			
			ps = conn.prepareStatement(sqlCurso);
			ps.setString(1, rgm);
			ps.executeUpdate();
			
			// Depois exclui o aluno
			String sqlAluno = "DELETE FROM tb_aluno WHERE pk_rgm = ?";
			
			ps = conn.prepareStatement(sqlAluno);
			ps.setString(1, rgm);
			ps.executeUpdate();
			
		} catch(Exception e) {
			throw new Exception("ERRO AO EXCLUIR: " + e.getMessage());
		}
	}
	
	/*
	 * MÉTODO LISTAR TODOS
	 * 
	 * Lista todos os alunos junto com seus cursos.
	 * 
	 * O INNER JOIN junta as duas tabelas:
	 * tb_aluno.pk_rgm = tb_curso.fk_rgm
	 */
	public List<AlunoCurso> listarTodos() throws Exception {
		
		// Lista que vai guardar vários objetos AlunoCurso
		List<AlunoCurso> lista = new ArrayList<AlunoCurso>();

		try {
			
			String sql = "SELECT "
					+ "a.pk_rgm, a.pk_cpf, a.nome, a.data_nasc, a.email, a.numero, a.endereco, a.complemento, a.municipio, a.uf, "
					+ "c.curso, c.campus, c.periodo, c.nota, c.semestre, c.faltas, c.disciplina "
					+ "FROM tb_aluno a "
					+ "INNER JOIN tb_curso c ON a.pk_rgm = c.fk_rgm";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			/*
			 * Enquanto existir uma linha no resultado do SELECT,
			 * ele cria um Aluno, cria um Curso e coloca os dois dentro de AlunoCurso.
			 */
			while(rs.next()) {
				
				// Dados vindos da tb_aluno
				String rgm = rs.getString("pk_rgm");
				String cpf = rs.getString("pk_cpf");
				String nome = rs.getString("nome");
				String dataNasc = rs.getString("data_nasc");
				String email = rs.getString("email");
				String numero = rs.getString("numero");
				String endereco = rs.getString("endereco");
				String complemento = rs.getString("complemento");
				String municipio = rs.getString("municipio");
				String uf = rs.getString("uf");
				
				// Dados vindos da tb_curso
				String nomeCurso = rs.getString("curso");
				String campus = rs.getString("campus");
				String periodo = rs.getString("periodo");
				float nota = rs.getFloat("nota");
				String semestre = rs.getString("semestre");
				int faltas = rs.getInt("faltas");
				String disciplina = rs.getString("disciplina");
				
				// Criando o objeto Aluno
				aluno = new Aluno(rgm, cpf, nome, dataNasc, email, numero, endereco, complemento, municipio, uf);
				
				// Criando o objeto Curso
				curso = new Curso(nomeCurso, campus, periodo, nota, semestre, faltas, disciplina);
				
				// Juntando Aluno e Curso dentro de AlunoCurso e adicionando na lista
				lista.add(new AlunoCurso(aluno, curso));
			}
			
			return lista;
			
		} catch(Exception e) {
			throw new Exception("ERRO AO LISTAR: " + e.getMessage());
		}
	}
	
	/*
	 * MÉTODO CONSULTAR
	 * 
	 * Consulta um aluno pelo RGM e já traz os dados do curso junto.
	 * 
	 * Esse é o método ideal para usar no botão "Consultar".
	 */
	public AlunoCurso consultar(String rgm) throws Exception {
		try {
			
			String sql = "SELECT "
					+ "a.pk_rgm, a.pk_cpf, a.nome, a.data_nasc, a.email, a.numero, a.endereco, a.complemento, a.municipio, a.uf, "
					+ "c.curso, c.campus, c.periodo, c.nota, c.semestre, c.faltas, c.disciplina "
					+ "FROM tb_aluno a "
					+ "INNER JOIN tb_curso c ON a.pk_rgm = c.fk_rgm "
					+ "WHERE a.pk_rgm = ?";
			
			ps = conn.prepareStatement(sql);
			
			// Esse ? é o RGM digitado pelo usuário
			ps.setString(1, rgm);
			
			rs = ps.executeQuery();
			
			/*
			 * Se encontrar o aluno, cria os objetos com os dados encontrados.
			 */
			if(rs.next()) {
				
				// Dados da tb_aluno
				String cpf = rs.getString("pk_cpf");
				String nome = rs.getString("nome");
				String dataNasc = rs.getString("data_nasc");
				String email = rs.getString("email");
				String numero = rs.getString("numero");
				String endereco = rs.getString("endereco");
				String complemento = rs.getString("complemento");
				String municipio = rs.getString("municipio");
				String uf = rs.getString("uf");
				
				// Dados da tb_curso
				String nomeCurso = rs.getString("curso");
				String campus = rs.getString("campus");
				String periodo = rs.getString("periodo");
				float nota = rs.getFloat("nota");
				String semestre = rs.getString("semestre");
				int faltas = rs.getInt("faltas");
				String disciplina = rs.getString("disciplina");
				
				// Cria o objeto Aluno
				aluno = new Aluno(rgm, cpf, nome, dataNasc, email, numero, endereco, complemento, municipio, uf);
				
				// Cria o objeto Curso
				curso = new Curso(nomeCurso, campus, periodo, nota, semestre, faltas, disciplina);
				
				// Junta os dois objetos em um AlunoCurso
				alunoCurso = new AlunoCurso(aluno, curso);
			} else {
				// Se não encontrar ninguém, retorna null
				alunoCurso = null;
			}
			
			return alunoCurso;
			
		} catch(Exception e) {
			throw new Exception("ERRO AO CONSULTAR: " + e.getMessage());
		}
	}
}
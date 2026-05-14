package model;

/*
 * Essa classe serve para juntar os dados de Aluno e Curso em um único objeto.
 * 
 * Por que ela existe?
 * Porque o método consultar() precisa retornar dados das duas tabelas:
 * - tb_aluno
 * - tb_curso
 * 
 * Como Java retorna um tipo de objeto por vez, essa classe funciona como uma "caixinha"
 * que guarda um Aluno e um Curso juntos.
 */
public class AlunoCurso {

	// Objeto da classe Aluno
	private Aluno aluno;
	
	// Objeto da classe Curso
	private Curso curso;
	
	// Construtor que recebe um aluno e um curso
	public AlunoCurso(Aluno aluno, Curso curso) {
		this.aluno = aluno;
		this.curso = curso;
	}

	// Retorna o objeto aluno
	public Aluno getAluno() {
		return aluno;
	}

	// Altera o objeto aluno
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	// Retorna o objeto curso
	public Curso getCurso() {
		return curso;
	}

	// Altera o objeto curso
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
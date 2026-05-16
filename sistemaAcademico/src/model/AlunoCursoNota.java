package model;

public class AlunoCursoNota {

    private Aluno aluno;
    private Curso curso;
    private Nota nota;

    public AlunoCursoNota(Aluno aluno, Curso curso, Nota nota) {
        this.aluno = aluno;
        this.curso = curso;
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
}
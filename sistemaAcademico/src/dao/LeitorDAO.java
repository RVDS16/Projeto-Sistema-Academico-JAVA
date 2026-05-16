package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Aluno;
import model.Curso;
import model.Nota;
import model.AlunoCursoNota;
import util.ConnectionFactory;

public class LeitorDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public LeitorDAO() throws Exception {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            throw new Exception("ERRO AO CONECTAR: " + e.getMessage());
        }
    }

    public void salvarAlunoCurso(AlunoCursoNota alunoCursoNota) throws Exception {
        try {
            Aluno aluno = alunoCursoNota.getAluno();
            Curso curso = alunoCursoNota.getCurso();

            String sqlAluno = "INSERT INTO tb_aluno(pk_rgm, pk_cpf, nome, data_nasc, email, numero, endereco, municipio, uf) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sqlAluno);

            ps.setString(1, aluno.getRgm());
            ps.setString(2, aluno.getCpf());
            ps.setString(3, aluno.getNome());
            ps.setString(4, aluno.getData_nasc());
            ps.setString(5, aluno.getEmail());
            ps.setString(6, aluno.getNumero());
            ps.setString(7, aluno.getEndereco());
            ps.setString(8, aluno.getMunicipio());
            ps.setString(9, aluno.getUf());

            ps.executeUpdate();

            String sqlCurso = "INSERT INTO tb_curso(curso, campus, periodo, fk_rgm) "
                    + "VALUES(?, ?, ?, ?)";

            ps = conn.prepareStatement(sqlCurso);

            ps.setString(1, curso.getCurso());
            ps.setString(2, curso.getCampus());
            ps.setString(3, curso.getPeriodo());
            ps.setString(4, aluno.getRgm());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new Exception("ERRO AO SALVAR ALUNO E CURSO: " + e.getMessage());
        }
    }

    public void salvarNota(Nota nota) throws Exception {
        try {
            String sqlNota = "INSERT INTO tb_notas(disciplina, semestre, nota, faltas, fk_rgm) "
                    + "VALUES(?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sqlNota);

            ps.setString(1, nota.getDisciplina());
            ps.setString(2, nota.getSemestre());
            ps.setString(3, nota.getNota());
            ps.setInt(4, nota.getFaltas());
            ps.setString(5, nota.getRgm());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new Exception("ERRO AO SALVAR NOTA: " + e.getMessage());
        }
    }

    public AlunoCursoNota consultarAlunoCurso(String rgm) throws Exception {
        try {
            String sql = "SELECT "
                    + "a.pk_rgm, a.pk_cpf, a.nome, a.data_nasc, a.email, a.numero, a.endereco, a.municipio, a.uf, "
                    + "c.curso, c.campus, c.periodo "
                    + "FROM tb_aluno a "
                    + "INNER JOIN tb_curso c ON a.pk_rgm = c.fk_rgm "
                    + "WHERE a.pk_rgm = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, rgm);

            rs = ps.executeQuery();

            if (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getString("pk_rgm"),
                        rs.getString("pk_cpf"),
                        rs.getString("nome"),
                        rs.getString("data_nasc"),
                        rs.getString("email"),
                        rs.getString("numero"),
                        rs.getString("endereco"),
                        rs.getString("municipio"),
                        rs.getString("uf")
                );

                Curso curso = new Curso(
                        rs.getString("curso"),
                        rs.getString("campus"),
                        rs.getString("periodo")
                );

                return new AlunoCursoNota(aluno, curso, null);
            }

            return null;

        } catch (Exception e) {
            throw new Exception("ERRO AO CONSULTAR ALUNO E CURSO: " + e.getMessage());
        }
    }

    public void excluirAluno(String rgm) throws Exception {
        try {
            String sqlNotas = "DELETE FROM tb_notas WHERE fk_rgm = ?";
            ps = conn.prepareStatement(sqlNotas);
            ps.setString(1, rgm);
            ps.executeUpdate();

            String sqlCurso = "DELETE FROM tb_curso WHERE fk_rgm = ?";
            ps = conn.prepareStatement(sqlCurso);
            ps.setString(1, rgm);
            ps.executeUpdate();

            String sqlAluno = "DELETE FROM tb_aluno WHERE pk_rgm = ?";
            ps = conn.prepareStatement(sqlAluno);
            ps.setString(1, rgm);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new Exception("ERRO AO EXCLUIR ALUNO: " + e.getMessage());
        }
    }
}
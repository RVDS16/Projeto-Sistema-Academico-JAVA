package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Curso;
import util.ConnectionFactory;

// Esse metodo ao todo é responsavel por realizar a conexao com o banco de dados atraves da class ConnectionFactury
public class LeitorDAO { // CRUD
	
	//Criando objetos para utilizar no CRUD
	private Aluno aluno;
	private Curso curso;
	private Connection conn; // O objeto Connection é uma importacao do Java.SQL
	private PreparedStatement ps; // Permite utilizar comandos SQL
	private ResultSet rs; //Objeto que é utilizado para buscar no banco de dados
	
	public LeitorDAO() throws Exception {
		try {
			//Pega a class ConnectionFactury que se conecta com o banco de dados
			conn = ConnectionFactory.getConnection(); 
		}catch(Exception e){
			//Caso de um erro ele ira mostrar a mensagem de ERRO
			throw new Exception("ERRO"+ e.getMessage());
		}
	}
	
	public void salvar(Aluno aluno) throws Exception {
		try {
			
			//Está realizando o comando SQL
			String sql="INSERT INTO tb_Aluno(pk_rgm, pk_cpf, nome, data_nasc, email, numero, endereco, complemento, municipio, uf)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//Executa o insert e envia ao banco
			ps = conn.prepareStatement(sql);
			/*
			 O numero no comando no comando a baixo representa o valor no comando de cima, 
			 1 = pk_rgm e tambem é igual a primeira " ? "
			 * */
			ps.setString(1, aluno.getRgm());
			ps.setString(2, aluno.getCpf());
			ps.setString(3, aluno.getNome());
			ps.setString(4, aluno.getData_nasc());
			ps.setString(5, aluno.getEmail());
			ps.setString(6, aluno.getNumero());
			ps.setString(7, aluno.getEndereco());
			ps.setString(8, aluno.getComplemento());
			ps.setString(9, aluno.getMunicipio());
			ps.setString(10, aluno.getUf());
			ps.executeUpdate();
			
		}catch(Exception e){
			//Caso de um erro ele ira mostrar a mensagem de ERRO
			throw new Exception("ERRO AO SALVAR"+ e.getMessage());
		}
	}
	
	public void alterar(Aluno aluno) throws Exception {
		try {
			
			//Está realizando o comando SQL
			String sql="UPDATE tb_Aluno SET pk_cpf = ?, nome = ?, data_nasc = ?, email = ?, numero = ?, endereco = ?, complemento = ?, municipio = ?, uf = ?)"
					+ "WHERE(pk_rgm = ?)"; 
			//Executa o insert e envia ao banco
			ps = conn.prepareStatement(sql);
			/*
			 O numero no comando no comando a baixo representa o valor no comando de cima, 
			 1 = pk_rgm e tambem é igual a primeira " ? "
			 * */
			ps.setString(1, aluno.getCpf());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getData_nasc());
			ps.setString(4, aluno.getEmail());
			ps.setString(5, aluno.getNumero());
			ps.setString(6, aluno.getEndereco());
			ps.setString(7, aluno.getComplemento());
			ps.setString(8, aluno.getMunicipio());
			ps.setString(9, aluno.getUf());
			ps.setString(10, aluno.getRgm());
			ps.executeUpdate();
			
		}catch(Exception e){
			//Caso de um erro ele ira mostrar a mensagem de ERRO
			throw new Exception("ERRO AO ALTERAR"+ e.getMessage());
		}
	}
	
	public void excluir(String rgm) throws Exception {
		try {
			
			//Está realizando o comando SQL
			String sql="DELETE FROM tb_Aluno)"
					+ "WHERE(pk_rgm = ?)"; 
			//Executa o insert e envia ao banco
			ps = conn.prepareStatement(sql);
			/*
			 O numero no comando no comando a baixo representa o valor no comando de cima, 
			 1 = pk_rgm e tambem é igual a primeira " ? "
			 * */
			ps.setString(1, rgm);
			ps.executeUpdate();
			
		}catch(Exception e){
			//Caso de um erro ele ira mostrar a mensagem de ERRO
			throw new Exception("ERRO AO EXCLUIR"+ e.getMessage());
		}
	}
	public List listarTodos() throws Exception{
		List<Aluno> lista = new ArrayList<Aluno>();

		try {
			ps = conn.prepareStatement("SELECT * FROM tb_Aluno");
			rs = ps.executeQuery();
			while(rs.next()) {
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
				lista.add(new Aluno(rgm, cpf, nome, dataNasc, email, numero, endereco, complemento, municipio, uf));
			}
			return lista;
		}catch(Exception e){
			//Caso de um erro ele ira mostrar a mensagem de ERRO
			throw new Exception("ERRO AO LISTAR"+ e.getMessage());
		}
	}
	public Aluno consultar(String rgm) throws Exception{
		try {
			ps = conn.prepareStatement("SELECT * FROM tb_Aluno WHERE pk_rgm = ?");
			ps.setString(1, rgm);
			rs = ps.executeQuery();
			if(rs.next()) {
				String cpf = rs.getString("pk_cpf");
				String nome = rs.getString("nome");
				String dataNasc = rs.getString("data_nasc");
				String email = rs.getString("email");
				String numero = rs.getString("numero");
				String endereco = rs.getString("endereco");
				String complemento = rs.getString("complemento");
				String municipio = rs.getString("municipio");
				String uf = rs.getString("uf");
				aluno = new Aluno(rgm, cpf, nome, dataNasc, email, numero, endereco, complemento, municipio, uf);
			}
			return aluno;
		}catch(Exception e){
			//Caso de um erro ele ira mostrar a mensagem de ERRO
			throw new Exception("ERRO AO LISTAR"+ e.getMessage());
		}
	}

}

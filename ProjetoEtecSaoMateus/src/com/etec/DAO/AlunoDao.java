package com.etec.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.etec.aluno.Aluno;

public class AlunoDao {
	
	//a conexão é apenas com banco local
	//criar tabela "alunos" com 3 atributos varchar2, "RM","nome","status"
	//deixei pré-setado user: root / senha: 1234 , mas pode mudar de acordo com o usuario do banco local do PC
	
	//Essas Strings abaixo você pode colocar a variável que quiser que será
	//substituído nos parametros para se conectar no banco e na base
	String banco = "etec";
	String usuario = "root";
	String senha = "1234";
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	//teste
	public String readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://localhost/"+banco+"?"
                    + "user="+usuario+"&password="+senha);
			
			statement = connect.createStatement();
			
			resultSet = statement.executeQuery("select * from "+banco+".alunos");
			
			return "sucesso";
		}catch(Exception e) {
			throw e;
			
		}finally {
			close();
		}
	}
	

	public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }


	//inserir dados
	public String InsertDataBase(Aluno aluno) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://localhost/"+banco+"?"
					+ "user="+usuario+"&password="+senha);
			//Parametros 
			preparedStatement = connect.prepareStatement("insert into etec.alunos values (?,?,?)");
			//Dados dos Parâmetros
			preparedStatement.setString(1, aluno.getRM());
			preparedStatement.setString(2, aluno.getNome());
			preparedStatement.setString(3, aluno.getStatus());
			preparedStatement.executeUpdate();
			
			return "sucesso";
		}catch(Exception e) {
			throw e;
			
		}finally {
			close();
		}
	}
	
	public Aluno pesquisarAluno(String nome) throws Exception {
		
		Aluno a = new Aluno();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://localhost/"+banco+"?"
					+ "user="+usuario+"&password="+senha);
			/*//Parametros 
			preparedStatement = connect.prepareStatement("select rm,nome,status from alunos where nome like %?%");
			//Dados dos Parâmetros
			preparedStatement.setString(1, nome);
			preparedStatement.executeQuery();
			
			return encontrado;*/
			
			preparedStatement = connect.prepareStatement("select rm,nome,status from alunos where nome like ?");
			preparedStatement.setString(1, nome);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				a.setRM(resultSet.getString(1));
				a.setNome(resultSet.getString(2));
				a.setStatus(resultSet.getString(3));
			}
			return a;
		}catch(Exception e) {
			throw e;
			
		}finally {
			close();
		}
	}
		
	}



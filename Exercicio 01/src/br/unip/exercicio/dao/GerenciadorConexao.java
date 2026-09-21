package br.unip.exercicio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GerenciadorConexao {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/sakila";
	private static final String user = "aluno";
	private static final String password = "unip";
	
	public static Connection getConnection() throws DadosException {
		try {
			
			return DriverManager.getConnection(URL, user, password);
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DadosException("Não foi possivel conectar ao banco de dados");
		}
	}
	
	public static void fechar(Connection conexao) throws DadosException {
		try {
			if(conexao != null) {
				conexao.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DadosException("Não foi possivel desconectar o banco de dados" + e);
		}
	}
	
	public static void fechar(Connection conexao, PreparedStatement pstatement) throws DadosException {
		try {
			if(pstatement != null) {
				pstatement.close();
			}
			if(conexao != null) {
				conexao.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DadosException("Não foi possivel desconectar o banco de dados" + e);
		}
	}
	
	public static void fechar(Connection conexao, PreparedStatement pstatement, ResultSet result) throws DadosException {
		try {
			if(pstatement != null) {
				pstatement.close();
			}
			if(result != null) {
				result.close();
			}
			if(conexao != null) {
				conexao.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DadosException("Não foi possivel desconectar o banco de dados" + e);
		}
	}
}




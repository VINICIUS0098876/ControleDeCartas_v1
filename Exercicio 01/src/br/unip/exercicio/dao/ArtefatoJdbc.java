package br.unip.exercicio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unip.exercicio.model.Artefato;
import br.unip.exercicio.model.Categoria;

public class ArtefatoJdbc implements ArtefatoDao{
	
	private static final String SQL_DELETE = "DELETE FROM TB_ARTEFATO WHERE ID = ?;";
	
	private static final String SQL_INSERT = "INSERT INTO TB_ARTEFATO (NOME, CATEGORIA, FORCA) VALUES (?, ?, ?);";
	
	private static final String SQL_UPDATE = "UPDATE TB_ARTEFATO SET NOME = ?, CATEGORIA = ? , FORCA = ? WHERE ID = ?;";
	
	private static final String SQL_ALL = "SELECT ID, NOME, CATEGORIA, FORCA FROM TB_ARTEFATO;";
	
	private static final String SQL_SELECT_BY_ID = "SELECT ID, NOME, CATEGORIA, FORCA FROM TB_ARTEFATO WHERE ID = ?;";
	
	private static final String SQL_SELECT_BY_CATEGORY = "SELECT ID, NOME, CATEGORIA, FORCA FROM TB_ARTEFATO WHERE CATEGORIA = ?;";
	
	@Override
	public void atualizar(Artefato artefato) throws DadosException {
		
		Connection conexao = null;
		
		PreparedStatement pstatement = null;
		
		try {
			
			conexao = GerenciadorConexao.getConnection();
			
			pstatement = conexao.prepareStatement(SQL_UPDATE);
			
			pstatement.setString(1, artefato.getNome());
			pstatement.setString(2, artefato.getCategoria().name());
			pstatement.setInt(3, artefato.getForca());
			pstatement.setLong(4, artefato.getId());
			
			pstatement.executeUpdate();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
			throw new DadosException("Não foi possível atualizar", e);	
			
		}finally {
			
			GerenciadorConexao.fechar(conexao, pstatement);
			
		}
		
	}

	@Override
	public void incluir(Artefato artefato) throws DadosException {
		Connection conexao = null;
		
		PreparedStatement pstatement = null;
		
		try {
			conexao = GerenciadorConexao.getConnection();
			
			pstatement = conexao.prepareStatement(SQL_INSERT);
			
			pstatement.setString(1, artefato.getNome());
			pstatement.setString(2, artefato.getCategoria().name());
			pstatement.setInt(3, artefato.getForca());
			
			
			pstatement.executeUpdate();
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			throw new DadosException("Não foi possível incluir", e);
			
		}finally {
			
			GerenciadorConexao.fechar(conexao, pstatement);
			
		}
		
	}

	@Override
	public void excluir(Artefato artefato) throws DadosException {
		
		Connection conexao = null;
		
		PreparedStatement pstatement = null;
		
		try {
		
			 conexao = GerenciadorConexao.getConnection();
			
			 pstatement = conexao.prepareStatement(SQL_DELETE);
			
			pstatement.setLong(1, artefato.getId());
			
			pstatement.executeUpdate();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			throw new DadosException("Não foi possível excluir", e);
			
		}finally {
			
			GerenciadorConexao.fechar(conexao, pstatement);
			
		}
	}

	@Override
	public Artefato getPorId(Long id) throws DadosException {
		
		Connection conexao = null;
		
		PreparedStatement pstatement = null;
		
		ResultSet result = null;
		
		Artefato artefato = null;
		
		try {
			
			conexao = GerenciadorConexao.getConnection();
			
			pstatement = conexao.prepareStatement(SQL_SELECT_BY_ID);
			
			pstatement.setLong(1, id);
			
			result = pstatement.executeQuery();
			
			if(result.next()) {
				artefato = new Artefato();
	
				artefato.setId(result.getLong("ID"));
				artefato.setNome(result.getString("NOME"));
				artefato.setCategoria(Categoria.valueOf(result.getString("CATEGORIA")));
				artefato.setForca(result.getInt("FORCA"));
				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DadosException("Não foi possível selecionar", e);
		}finally {
			GerenciadorConexao.fechar(conexao, pstatement, result);
		}
		
		return artefato;
	}

	@Override
	public List<Artefato> getPorCategoria(Categoria categoria) throws DadosException {
		Connection conexao = null;
		
		PreparedStatement pstatement = null;
		
		ResultSet result = null;
		
		List<Artefato> lista = new ArrayList<>();
		
		try {
			conexao = GerenciadorConexao.getConnection();
			
			pstatement = conexao.prepareStatement(SQL_SELECT_BY_CATEGORY);
			
			pstatement.setString(1, categoria.name());
			
			result = pstatement.executeQuery();
			
			while(result.next()) {
				Artefato artefato = new Artefato();
				
				artefato.setId(result.getLong("ID"));
				artefato.setNome(result.getString("NOME"));
				artefato.setCategoria(Categoria.valueOf(result.getString("CATEGORIA")));
				artefato.setForca(result.getInt("FORCA"));
				
				lista.add(artefato);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DadosException("Não foi possível selecionar", e);
		}finally {
			GerenciadorConexao.fechar(conexao, pstatement, result);
		}
		
		return lista;
	}

	@Override
	public List<Artefato> getTodos() throws DadosException {
		
		Connection conexao = null;
		
		PreparedStatement pstatement = null;
		
		ResultSet result = null;
		
		List<Artefato> lista = new ArrayList<>();
		
		try {
			
			conexao = GerenciadorConexao.getConnection();
			
			pstatement = conexao.prepareStatement(SQL_ALL);
			
			result = pstatement.executeQuery();
			
			while(result.next()) {
				
				Artefato artefato = new Artefato();
				
				artefato.setId(result.getLong("ID"));
				artefato.setNome( result.getString("NOME"));
				artefato.setCategoria(Categoria.valueOf(result.getString("CATEGORIA")));
				artefato.setForca( result.getInt("FORCA"));
				
				lista.add(artefato);
			}
			
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
			throw new DadosException("Não foi possível selecionar", e);
			
		}finally {
			
			GerenciadorConexao.fechar(conexao, pstatement, result);
			
		}
		return lista;
	}

	
}

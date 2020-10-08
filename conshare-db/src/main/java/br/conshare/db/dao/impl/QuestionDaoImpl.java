package br.conshare.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.conshare.db.connecction.ConnectionFactory;
import br.conshare.db.dao.QuestionDao;
import br.conshare.model.entities.Duvida;

@Repository
public class QuestionDaoImpl implements QuestionDao {
	
	public static Long USUARIO_ID = Long.valueOf(1);

	public List<Duvida> readAll() {
		
		List <Duvida> questions = new ArrayList<Duvida>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = ConnectionFactory.getConnection();
			
			String sql = "SELECT * FROM duvida;";
			
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Duvida duvida = new Duvida ();
				duvida.setId(resultSet.getLong("id"));
				duvida.setTitulo(resultSet.getString("titulo"));
				duvida.setCategoria(resultSet.getString("categoria"));
				duvida.setDescricao(resultSet.getString("descricao"));
				duvida.setUsuarioId(resultSet.getLong("usuario_id"));
				
				questions.add(duvida);
			}
		} catch (Exception e) {
			
		} finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		return questions;
	}

	public Long create(Duvida entity) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "INSERT INTO duvida(titulo, categoria, descricao, usuario_id)";
		sql += " VALUES ( ?, ?, ?, ?);";
		
		Long id = Long.valueOf(0);

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, entity.getTitulo());
			preparedStatement.setString(2, entity.getCategoria());
			preparedStatement.setString(3, entity.getDescricao());
			preparedStatement.setLong(4, entity.getUsuarioId());

			preparedStatement.execute();
			resultSet = preparedStatement.getGeneratedKeys();
			if(resultSet.next()) {
				id = resultSet.getLong(1);
				
			}

			connection.commit();
			return id;
		} catch (Exception e) {

			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			return id;
		} finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		
		
	}

	public Duvida readById(Long id) {
		
		Duvida questions = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			
			String sql = "SELECT * FROM duvida WHERE id = ? ";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				questions = new Duvida();
				questions.setId(resultSet.getLong("id"));
				questions.setTitulo(resultSet.getString("titulo"));
				questions.setCategoria(resultSet.getString("categoria"));
				questions.setDescricao(resultSet.getString("descricao"));
				
			}
			
			
			
		} catch (Exception e) {
			
		} finally {
			 ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		return questions;
	}

	public boolean update(Duvida entity) {
		
		entity.setUsuarioId(USUARIO_ID);
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "UPDATE duvida SET titulo = ?, categoria = ? , descricao = ? ";
		sql += "WHERE id = ?; ";
		
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, entity.getTitulo());
			preparedStatement.setString(2, entity.getCategoria());
			preparedStatement.setString(3, entity.getDescricao());
			preparedStatement.setLong(4, entity.getId());
			
			
			preparedStatement.execute();
			connection.commit();
			
			return true;
			

			
		} catch (Exception e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return false;
		} finally {
			ConnectionFactory.close(preparedStatement, connection);
			
		}
		
	
		
	}

	public boolean deleteById(Long Id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "DELETE FROM duvida WHERE id = ?";
		
		try {
			
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setLong(1, Id);
			
			preparedStatement.execute();
			connection.commit();
			
			return true;
			
					
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return false;
			
		} finally {
			ConnectionFactory.close(preparedStatement, connection);
		}
		

	
	}

}

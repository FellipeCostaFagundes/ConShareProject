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
import br.conshare.db.dao.UserDao;
import br.conshare.model.entities.Duvida;
import br.conshare.model.entities.Usuario;

@Repository
public class UserDaoImpl implements UserDao {

	public List<Usuario> readAll() {

		List<Usuario> users = new ArrayList<Usuario>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.getConnection();

			String sql = "SELECT * FROM usuario";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Usuario user = new Usuario();
				user.setId(resultSet.getLong("id"));
				user.setNome(resultSet.getString("nome"));
				user.setSobrenome(resultSet.getString("sobrenome"));
				user.setSenha(resultSet.getString("senha"));
				user.setEmail(resultSet.getString("email"));
				user.setCelular(resultSet.getString("celular"));
				user.setCpf(resultSet.getString("cpf"));
				user.setTipo(resultSet.getString("tipo"));
				user.setNickname(resultSet.getString("nickname"));
				user.setAno_nascimento(resultSet.getTimestamp("ano_nascimento"));
				user.setDescricao(resultSet.getString("descricao"));
				user.setFormacao(resultSet.getString("formacao"));
				user.setVerificacao(resultSet.getBoolean("verificacao"));
				user.setInteresses_de_pesquisa(resultSet.getString("interesses_de_pesquisa"));
				
				
				
				users.add(user);

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
			

		} finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}

		return users;
	}

	@Override
	public Long create(Usuario entity) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		

		 

		String sql = "INSERT INTO usuario(nome, sobrenome, senha, email, celular, cpf, tipo, nickname, ano_nascimento, descricao, formacao, verificacao, interesses_de_pesquisa) ";
		sql += " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		Long id = Long.valueOf(1);

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, entity.getNome());
			preparedStatement.setString(2, entity.getSobrenome());
			preparedStatement.setString(3, entity.getSenha());
			preparedStatement.setString(4, entity.getEmail());
			preparedStatement.setString(5, entity.getCelular());
			preparedStatement.setString(6, entity.getCpf());
			preparedStatement.setString(7, entity.getTipo());
			preparedStatement.setString(8, entity.getNickname());
			preparedStatement.setTimestamp(9, entity.getAno_nascimento());
			preparedStatement.setString(10, entity.getDescricao());
			preparedStatement.setString(11, entity.getFormacao());
			preparedStatement.setBoolean(12, entity.isVerificacao());
			preparedStatement.setString(13, entity.getInteresses_de_pesquisa());
			

			preparedStatement.execute();
			resultSet = preparedStatement.getGeneratedKeys();
			
			if(resultSet.next()) {
				id = resultSet.getLong(1);
				
			}
			connection.commit();

			return id;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			
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

	public Usuario readById(Long id) {
		Usuario user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM usuario WHERE id = ? ";

		try {
			connection = ConnectionFactory.getConnection();	

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user = new Usuario();
		
				user.setId(resultSet.getLong("id"));
				user.setNome(resultSet.getString("nome"));
				user.setSobrenome(resultSet.getString("sobrenome"));
				user.setSenha(resultSet.getString("senha"));
				user.setEmail(resultSet.getString("email"));
				user.setCelular(resultSet.getString("celular"));
				user.setCpf(resultSet.getString("cpf"));
				user.setTipo(resultSet.getString("tipo"));
				user.setNickname(resultSet.getString("nickname"));
				user.setAno_nascimento(resultSet.getTimestamp("ano_nascimento"));
				user.setDescricao(resultSet.getString("descricao"));
				user.setFormacao(resultSet.getString("formacao"));
				user.setVerificacao(resultSet.getBoolean("verificacao"));
				user.setInteresses_de_pesquisa(resultSet.getString("interesses_de_pesquisa"));
				
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
			

		} finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}

		return user;
	}

	public boolean update(Usuario entity) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "UPDATE usuario SET nickname = ?, interesses_de_pesquisa = ? , descricao = ?";
		sql += "WHERE id = ?; ";
		
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, entity.getNickname());
			preparedStatement.setString(2, entity.getInteresses_de_pesquisa());
			preparedStatement.setString(3, entity.getDescricao());
			
			preparedStatement.execute();
			connection.commit();
			
			return true;
			

			
		} catch (Exception e) {

			System.out.println(e.getMessage());
			
			
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
		// TODO Auto-generated method stub
		return false;
	}

}

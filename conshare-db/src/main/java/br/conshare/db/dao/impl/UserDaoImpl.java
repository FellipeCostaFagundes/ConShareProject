package br.conshare.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.conshare.db.connecction.ConnectionFactory;
import br.conshare.db.dao.UserDao;
import br.conshare.model.entities.Usuario;

@Repository
public class UserDaoImpl implements UserDao{

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
			
			
			while(resultSet.next()) {
				Usuario user = new Usuario();
				user.setId(resultSet.getLong("id"));
				user.setEmail(resultSet.getString("email"));
				user.setCpf(resultSet.getString("cpf"));
				user.setNome(resultSet.getString("nome"));
				user.setNick_name(resultSet.getString("nickname"));
				user.setSenha(resultSet.getString("senha"));
				user.setTipo(resultSet.getString("tipo"));
				user.setFormacao_academica(resultSet.getString("formacao_academica"));
				user.setVerificacao(resultSet.getBoolean("verificacao"));
				user.setInteresses_de_pesquisa(resultSet.getString("interesses_de_pesquisa"));
				user.setFormacao(resultSet.getString("formacao"));
				
				users.add(user);
				
				
			}
			
		} catch (Exception e){
			
		} finally {
			ConnectionFactory.close (resultSet, preparedStatement, connection);
		}
		
		
		
		return users;
	}

	public boolean create(Usuario entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public Usuario readById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(Usuario entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteById(Long Id) {
		// TODO Auto-generated method stub
		return false;
	}

}

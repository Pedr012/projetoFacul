package br.com.usjt.collegeproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.usjt.collegeproject.model.entities.Patient;

public class PatientDAO {

	public int criar(Patient paciente) {
			 String sqlInsert = "INSERT INTO paciente (nome, cpf, idade, sexo, nascimento, fone, endereco, email, senha) values (?, ?, ?,? ,?, ?, ?, ? ,?, ?, ?);";
	        // usando o try with resources do Java 7, que fecha o que abriu
	        try (Connection conn = ConnectionFactory.obtemConexao();
	                PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
	        	stm.setString(1, paciente.getName());
	            stm.setString(3, paciente.getCpf());
	            stm.setInt(4, paciente.getAge());
	            stm.setString(5, paciente.getSex());
	            stm.setDate(6, paciente.getBirthday());
	            stm.setInt(7, paciente.getNumber());
	            stm.setString(8, paciente.getAddress());
	            stm.setString(9, paciente.getEmail());
	            stm.setString(10, paciente.getPassword());
	            stm.execute();
	            String sqlQuery = "SELECT LAST_INSERT_ID()";
	            try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
	                if (rs.next()) {
	                	paciente.setCpf(rs.getString("0"));
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Integer.parseInt(paciente.getCpf());
	    }

	    public void atualizar(Patient paciente) {
	        String sqlUpdate = "UPDATE paciente SET nome=?, idade=?, sexo=?, nascimento=?, fone=?, endereco=?, email=?, senha=? WHERE cpf=?";
	        // usando o try with resources do Java 7, que fecha o que abriu
	        try (Connection conn = ConnectionFactory.obtemConexao();
	                PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {

	        	stm.setString(1, paciente.getName());
	            stm.setInt(2, paciente.getAge());
	            stm.setString(3, paciente.getSex());
	            stm.setDate(4, paciente.getBirthday());
	            stm.setInt(5, paciente.getNumber());
	            stm.setString(6, paciente.getAddress());
	            stm.setString(7, paciente.getEmail());
	            stm.setString(8, paciente.getPassword());
	            stm.setString(9, paciente.getCpf());

	            stm.execute();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void excluir(Patient paciente) {
	        String sqlDelete = "UPDATE paciente set deletado = true where cpf = ?;";
	        // usando o try with resources do Java 7, que fecha o que abriu
	        try (Connection conn = ConnectionFactory.obtemConexao();
	                PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
	            stm.setString(1, paciente.getCpf());
	            stm.execute();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public Patient carregar(String cpf) {
	    	Patient paciente = new Patient();
	    	paciente.setCpf(cpf);
	        String sqlSelect = "SELECT nome, idade, sexo, nascimento, fone, endereco, email, senha FROM paciente WHERE cpf = ?";
	        // usando o try with resources do Java 7, que fecha o que abriu
	        try (Connection conn = ConnectionFactory.obtemConexao();
	                PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
	            stm.setString(1, paciente.getCpf());
	            try (ResultSet rs = stm.executeQuery();) {
	                if (rs.next()) {

	                	paciente.setName(rs.getString("nome"));
	                	paciente.setAge(rs.getInt("idade"));
	                	paciente.setSex(rs.getString("sexo"));
	                	paciente.setBirthday(rs.getDate("nascimento"));
	                	paciente.setNumber(rs.getInt("fone"));
	                	paciente.setAddress(rs.getString("endereco"));
	                	paciente.setEmail(rs.getString("email"));
	                	paciente.setPassword(rs.getString("senha"));
	                	
	                } else {
	                	paciente.setName(null);
	                	paciente.setAge(0);
	                	paciente.setSex(null);
	                	paciente.setBirthday(null);
	                	paciente.setNumber(0);
	                	paciente.setAddress(null);
	                	paciente.setEmail(null);
	                	paciente.setPassword(null);
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } catch (SQLException e1) {
	            System.out.print(e1.getStackTrace());
	        }
	        return paciente;
	    }
	
}

package br.com.usjt.collegeproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.usjt.collegeproject.model.entities.Professional;


public class ProfessionalDAO {

	public int criar(Professional profissional) {
        String sqlInsert = "INSERT INTO medico ( nome, crm, cpf, idade, sexo, nascimento, fone, endereco, email, senha, idClinica) values (?, ?, ?,? ,?, ?, ?, ? ,?, ?, ?);";

        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
        	stm.setString(1, profissional.getName());
            stm.setString(2, profissional.getCrm());
            stm.setString(3, profissional.getCpf());
            stm.setInt(4, profissional.getAge());
            stm.setString(5, profissional.getSex());
            stm.setDate(6, profissional.getBirthday());
            stm.setInt(7, profissional.getNumber());
            stm.setString(8, profissional.getAddress());
            stm.setString(9, profissional.getEmail());
            stm.setString(10, profissional.getPassword());
            stm.setObject(11, profissional.getClinic());
            stm.execute();
            String sqlQuery = "SELECT LAST_INSERT_ID()";
            try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
                if (rs.next()) {
                	profissional.setCrm(rs.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(profissional.getCrm());
    }

    public void atualizar(Professional profissional) {
        String sqlUpdate = "UPDATE medico SET nome=?, cpf=?, idade=?, sexo=?, nascimento=?, fone=?, endereco=?, email=?, senha=?, idClinica=? WHERE crm=?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {

        	stm.setString(1, profissional.getName());
            stm.setString(3, profissional.getCpf());
            stm.setInt(3, profissional.getAge());
            stm.setString(4, profissional.getSex());
            stm.setDate(5, profissional.getBirthday());
            stm.setInt(6, profissional.getNumber());
            stm.setString(7, profissional.getAddress());
            stm.setString(8, profissional.getEmail());
            stm.setString(9, profissional.getPassword());
            stm.setObject(10, profissional.getClinic());
            stm.setString(11, profissional.getCrm());

            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(Professional profissional) {
        String sqlDelete = "UPDATE medico set deletado = true where crm = ?;";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
            stm.setString(1, profissional.getCrm());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Professional carregar(String crm) {
    	Professional profissional = new Professional();
    	profissional.setCrm(crm);
        String sqlSelect = "SELECT nome, cpf, idade, sexo, nascimento, fone, endereco, email, senha, idClinica FROM medico WHERE crm = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setString(1, profissional.getCrm());
            try (ResultSet rs = stm.executeQuery();) {
                if (rs.next()) {

                	profissional.setName(rs.getString("nome"));
                	profissional.setCpf(rs.getString("cpf"));
                	profissional.setAge(rs.getInt("idade"));
                	profissional.setSex(rs.getString("sexo"));
                	profissional.setBirthday(rs.getDate("nascimento"));
                	profissional.setNumber(rs.getInt("fone"));
                	profissional.setAddress(rs.getString("endereco"));
                	profissional.setEmail(rs.getString("email"));
                	profissional.setPassword(rs.getString("senha"));

                } else {
                	profissional.setCrm(null);
                	profissional.setName(null);
                	profissional.setCpf(null);
                	profissional.setAge(0);
                	profissional.setSex(null);
                	profissional.setBirthday(null);
                	profissional.setNumber(0);
                	profissional.setAddress(null);
                	profissional.setEmail(null);
                	profissional.setPassword(null);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
        }
        return profissional;
    }
	
}

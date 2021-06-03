package br.com.usjt.collegeproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.usjt.collegeproject.model.entities.Patient;
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
            stm.setString(1, profissional.getSexo());
            stm.setString(1, profissional.getBirthday());
            stm.setInt(1, profissional.getNumber());
            stm.setString(1, profissional.getAddress());
            stm.setString(1, profissional.getEmail());
            stm.setString(1, profissional.getPassword());
            stm.setInt(1, profissional.getClinic());
            stm.execute();
            String sqlQuery = "SELECT LAST_INSERT_ID()";
            try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
                if (rs.next()) {
                	profissional.setCrm(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profissional.getCrm();
    }

    public void atualizar(Professional profissional) {
        String sqlUpdate = "UPDATE clinica SET nome=?, fone=?, endereco=? WHERE cnpj=?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {

            stm.setString(1, profissional.getName());
            stm.setInt(2, profissional.getNumber());
            stm.setString(3, profissional.getAddress());
            stm.setString(4, profissional.getCnpj());

            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(Professional profissional) {
        String sqlDelete = "DELETE FROM clinica WHERE cnpj = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
            stm.setString(1, profissional.getCnpj());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Patient carregar(String cnpj) {
    	Professional profissional = new Professional();
    	profissional.setCnpj(cnpj);
        String sqlSelect = "SELECT nome, fone, endereco FROM clinica WHERE cnpj = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setString(1, profissional.getCnpj());
            try (ResultSet rs = stm.executeQuery();) {
                if (rs.next()) {

                	profissional.setName(rs.getString("nome"));
                	profissional.setNumber(rs.getInt("fone"));
                	profissional.setAddress(rs.getString("endereco"));

                } else {
                	profissional.setId(-1);
                	profissional.setName(null);
                	profissional.setNumber(0);
                	profissional.setAddress(null);
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

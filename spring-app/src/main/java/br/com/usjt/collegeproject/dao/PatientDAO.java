package br.com.usjt.collegeproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.usjt.collegeproject.model.entities.Patient;


public class PatientDAO {

	public int criar(Patient clinica) {
        String sqlInsert = "INSERT INTO clinica(cnpj, nome, fone, endereco) values(?, ?, ?, ?)";

        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
        	stm.setString(1, clinica.getCnpj());
            stm.setString(2, clinica.getName());
            stm.setInt(3, clinica.getNumber());
            stm.setString(4, clinica.getAddress());
            stm.execute();
            String sqlQuery = "SELECT LAST_INSERT_ID()";
            try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
                if (rs.next()) {
                	clinica.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clinica.getId();
    }

    public void atualizar(Patient clinica) {
        String sqlUpdate = "UPDATE clinica SET nome=?, fone=?, endereco=? WHERE cnpj=?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {

            stm.setString(1, clinica.getName());
            stm.setInt(2, clinica.getNumber());
            stm.setString(3, clinica.getAddress());
            stm.setString(4, clinica.getCnpj());

            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(Patient clinica) {
        String sqlDelete = "DELETE FROM clinica WHERE cnpj = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
            stm.setString(1, clinica.getCnpj());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Patient carregar(String cnpj) {
        Clinic clinica = new Clinic();
        clinica.setCnpj(cnpj);
        String sqlSelect = "SELECT nome, fone, endereco FROM clinica WHERE cnpj = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setString(1, clinica.getCnpj());
            try (ResultSet rs = stm.executeQuery();) {
                if (rs.next()) {

                	clinica.setName(rs.getString("nome"));
                	clinica.setNumber(rs.getInt("fone"));
                	clinica.setAddress(rs.getString("endereco"));

                } else {
                	clinica.setId(-1);
                	clinica.setName(null);
                	clinica.setNumber(0);
                    clinica.setAddress(null);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
        }
        return clinica;
    }
	
}

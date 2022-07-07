package com.grupo4.model.repository;

import com.grupo4.model.conn.DBConnection;
import com.grupo4.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DBConnection {

    public boolean register(User usuario) {
        PreparedStatement ps = null;
        Connection conn = createConnection();
        String sql = "INSERT INTO users (name, dni, phone, email, destiny) VALUES(?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getName());
            ps.setString(2, usuario.getDni());
            ps.setString(3, usuario.getPhone());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getDestiny());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modify(User usuario) {
        PreparedStatement ps = null;
        Connection conn = createConnection();
        //String sql = "UPDATE users SET name=?, email=?, phone=?, address=?, password=? WHERE phone=?";
        String sql = "UPDATE users SET name=?, phone=?, email=?, destiny=? WHERE dni=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getName());
            ps.setString(2, usuario.getPhone());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getDestiny());
            ps.setString(5, usuario.getDni());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean delete(User usuario) {
        PreparedStatement ps = null;
        Connection conn = createConnection();
//        String sql = "DELETE FROM users WHERE id=?";
        String sql = "DELETE FROM users WHERE dni=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getDni());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean read(User usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = createConnection();
        String sql = "SELECT * FROM users WHERE dni=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getDni());
            rs = ps.executeQuery();

            if (rs.next()) {
                usuario.setId(Integer.parseInt(rs.getString("id")));
                usuario.setName(rs.getString("name"));
                usuario.setDni(rs.getString("dni"));
                usuario.setPhone(rs.getString("phone"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDestiny(rs.getString("destiny"));
                return true;
            }

            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
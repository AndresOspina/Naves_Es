package Modelo;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultar_Nave extends Conexion {

    public boolean registrar(Registrar_Nave pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO tipo (nombre,tamaño,Serial,pais,tipo) VALUES(?,?,?,?,?)";

        try { 
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getTamaño());
            ps.setInt(3, pro.getSerial());
            ps.setString(4, pro.getPais());
            ps.setString(5, pro.getTipo());
            ps.execute();
            return true;  

        } catch (SQLException e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

    }
    
    

    public Boolean modificar(Registrar_Nave pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE tipo SET nombre=?,tamaño=?,serial=?,pais=?,tipo=? WHERE id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getTamaño());
            ps.setInt(3, pro.getSerial());
            ps.setString(4, pro.getPais());
            ps.setString (5, pro.getTipo());
            ps.setInt(6, pro.getId());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

    }

    public Boolean Eliminar(Registrar_Nave pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE from tipo WHERE id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

    }


    public Boolean Buscar(Registrar_Nave pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * from tipo WHERE cedula=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getSerial());
            rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setNombre(rs.getString("nombre"));
                pro.setTamaño((rs.getString("tamaño")));
                pro.setSerial(Integer.parseInt(rs.getString("serial")));
                pro.setPais(rs.getString("pais"));
                pro.setTipo(rs.getString("tipo"));
               
                return true;
            }

            return false;

        } catch (SQLException e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
        

    }
    
    
}
  
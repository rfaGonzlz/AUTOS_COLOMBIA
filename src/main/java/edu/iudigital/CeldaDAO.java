package edu.iudigital;

import java.sql.*;

public class CeldaDAO {

    // Permite buscar celdas libres y actualizar su estado
    public Integer buscarCeldaLibre(){

        String sql = "SELECT numero FROM celda WHERE ocupada=false LIMIT 1";

        try(Connection con = ConexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            if(rs.next()){
                return rs.getInt("numero");
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return null;

    }

    // Cambia el estado de una celda a ocupada
    public void ocuparCelda(int numero){

        String sql = "UPDATE celda SET ocupada=true WHERE numero=?";

        try(Connection con = ConexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,numero);
            ps.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    // Prueba
    public void liberarCelda(int numero){

        String sql = "UPDATE celda SET ocupada=false WHERE numero=?";

        try(Connection con = ConexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,numero);
            ps.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

}

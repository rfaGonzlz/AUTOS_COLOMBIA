package edu.iudigital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehiculoDAO {

    public void guardarVehiculo(Vehiculo vehiculo) {

        String sql = "INSERT INTO vehiculo VALUES(?,?,?,?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getTipo());
            ps.setString(3, vehiculo.getMarca());
            ps.setString(4, vehiculo.getColor());

            ps.executeUpdate();

            System.out.println("Vehiculo guardado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean existeVehiculo(String placa) {

        String sql = "SELECT placa FROM vehiculo WHERE placa=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, placa);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            return false;
        }

    }
}
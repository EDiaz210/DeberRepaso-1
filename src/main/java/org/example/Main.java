package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/estudiantes2024";
        String usuario = "root";
        String password = "123456";

        String nombre = "Melanie Ontaneda";
        String cedula = "1727660903";
        double b1 = 17.60;
        double b2 = 19.40;

        String sql = "INSERT INTO estudiantes (cedula, nombre, b1, b2) VALUES (?, ?, ?, ?)";

        try(Connection connection = DriverManager.getConnection(url, usuario, password)){
            PreparedStatement cadenaPreparada = connection.prepareStatement(sql);
            System.out.println("Conexión con Exito");
            cadenaPreparada.setString(1,cedula);
            cadenaPreparada.setString(2,nombre);
            cadenaPreparada.setDouble(3,b1);
            cadenaPreparada.setDouble(4,b2);

            cadenaPreparada.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

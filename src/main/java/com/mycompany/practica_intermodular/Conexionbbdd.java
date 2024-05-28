/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_intermodular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Conexionbbdd {

        // Configuración de la conexión a la base de datos MySQL
        String url = "jdbc:mysql://localhost:3306/practica_intermodular";
        String usuario = "root";
        String contraseña = "Med@c";
        
        // Sentencia SQL planetas, Sol y satélites
        String queryPlaneta = "SELECT * FROM Planetas WHERE nombre = ?";
        String querySol = "SELECT * FROM Estrellas WHERE nombre = 'Sol'";
        String querySatelites = "SELECT * FROM Satelites WHERE id_planeta = ?";

        // Método para conectarse a la BBDD y obtener los datos de los planetas
        public String[] devolverDatosPlaneta(String nombrePlaneta) {
            // Crear una variable donde guardar los datos
            String[] datosPlaneta = new String[9];

            try {
                // Establecer conexión con la base de datos
                Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

                // Crear una instancia de PreparedStatement para ejecutar sentencias SQL con variables
               PreparedStatement prepStatement = conexion.prepareStatement(queryPlaneta);
               prepStatement.setString(1, nombrePlaneta);

                // Ejecutar la consulta SQL y obtener el conjunto de resultados
                ResultSet resultados = prepStatement.executeQuery();

                // Iterar sobre los resultados y mostrarlos por consola
                while (resultados.next()) {
                    datosPlaneta[0] = resultados.getString("id");
                    datosPlaneta[1] = resultados.getString("nombre");
                    datosPlaneta[2] = resultados.getString("radio");
                    datosPlaneta[3] = resultados.getString("distancia_media_sol");
                    datosPlaneta[4] = resultados.getString("periodo_orbital");
                    datosPlaneta[5] = resultados.getString("temperatura_media");
                    datosPlaneta[6] = resultados.getString("tipo_planeta");
                    datosPlaneta[7] = resultados.getString("num_satelites");
                    datosPlaneta[8] = resultados.getString("fecha_creacion");
                }

                // Cerrar recursos
                prepStatement.close();
                conexion.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }  
            return datosPlaneta;
        }
        
        // Método para conectarse a la BBDD y obtener los datos del Sol
        public String[] devolverDatosSol() {
            // Crear una variable donde guardar los datos
            String[] datosSol = new String[5];

            try {
                // Establecer conexión con la base de datos
                Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

                // Crear una instancia de Statement para ejecutar sentencias SQL
               Statement statement = conexion.createStatement();

                // Ejecutar la consulta SQL y obtener el conjunto de resultados
                ResultSet resultados = statement.executeQuery(querySol);

                // Iterar sobre los resultados y mostrarlos por consola
                while (resultados.next()) {
                    datosSol[0] = resultados.getString("tipo_estrella");
                    datosSol[1] = resultados.getString("radio");
                    datosSol[2] = resultados.getString("temperatura_superficial");
                    datosSol[3] = resultados.getString("distancia_media_tierra");
                    datosSol[4] = resultados.getString("composicion");
                }

                // Cerrar recursos
                statement.close();
                conexion.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }  
            return datosSol;
        }
        
        // Método para conectarse a la BBDD y obtener los datos de los satelites
        public ArrayList<String> devolverDatosSatelite(String nombrePlaneta) {
            // Crear una variable donde guardar los datos
            ArrayList<String> datosSatelite = new ArrayList<String>();

            try {
                // Establecer conexión con la base de datos
                Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

                // Crear una instancia de PreparedStatement para ejecutar sentencias SQL con variables
               PreparedStatement prepStatement = conexion.prepareStatement(querySatelites);
               prepStatement.setString(1, nombrePlaneta);

                // Ejecutar la consulta SQL y obtener el conjunto de resultados
                ResultSet resultados = prepStatement.executeQuery();

                // Iterar sobre los resultados y mostrarlos por consola
                while (resultados.next()) {
                    datosSatelite.add(resultados.getString("nombre"));
                    datosSatelite.add(resultados.getString("radio"));
                    datosSatelite.add(resultados.getString("temperatura_media"));
                    datosSatelite.add(resultados.getString("distancia_media_planeta"));
                    datosSatelite.add(resultados.getString("tipo_cuerpo"));
                    datosSatelite.add(resultados.getString("fecha_creacion"));
                    datosSatelite.add(resultados.getString("periodo_orbital"));
                }
                
                // Hay que borrar el úlitmo registro nulo que devuelve SQL
                datosSatelite.remove(datosSatelite.size() - (datosSatelite.size()/7));
                
                // Cerrar recursos
                prepStatement.close();
                conexion.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }  
            return datosSatelite;
        }
}


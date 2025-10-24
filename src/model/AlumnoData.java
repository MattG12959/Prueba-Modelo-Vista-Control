/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entities.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author matia
 */
public class AlumnoData {
     private Connection con = null;

    public AlumnoData(miConexion conexion) {
        this.con = conexion.buscarConexion();
    }
    
    public Alumno buscarAlumnoPorId(int idAlumno){
        String query = "SELECT * FROM `alumno` WHERE `idAlumno` = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idAlumno);
            Alumno alum = null;
            ResultSet resultado = ps.executeQuery();
            LocalDate fechaNacimiento = null;

            while (resultado.next()) {
                fechaNacimiento = LocalDate.parse(resultado.getString("fechaNacimiento"));
                alum = new Alumno(resultado.getInt("idAlumno"), 
                                resultado.getInt("dni"), 
                                resultado.getString("apellido"), 
                                resultado.getString("nombre"),
                                fechaNacimiento);
            }
            return alum;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al buscar el Alumno en la base de datos.");
        }
        return null;
    }
     
    public void cargarAlumno(Alumno alumno){
        String query = "INSERT INTO alumno(dni, apellido, nombre, fechaNacimiento) VALUES (?,?,?,?)";
        
        System.out.println("--------------");
        System.out.println("dni: "+ alumno.getDni() );
        System.out.println("apellido:" + alumno.getApellido());
        System.out.println("nombre: " + alumno.getNombre());
        System.out.println("FechaNacimiento: " + alumno.getFechaNacimiento());
        System.out.println("--------------");
        
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId(1);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo tener ID.", "", JOptionPane.ERROR_MESSAGE);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al cargar el Alumno en la base de datos.");
        }
    }
     
}

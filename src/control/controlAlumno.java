/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entities.Alumno;
import javax.swing.JOptionPane;
import model.AlumnoData;
import view.vistaMenu;

/**
 *
 * @author matia
 */
public class controlAlumno {

    vistaMenu vistaMenu;
    AlumnoData alumnoData;
    Alumno alumno = null;

    public controlAlumno(vistaMenu vistaMenu, AlumnoData alumnoData) {
        this.vistaMenu = vistaMenu;
        this.alumnoData = alumnoData;
    }

    public void cargarAlumno() {
        try {
            Alumno alumno = new Alumno(
                    vistaMenu.getDNI(),
                    vistaMenu.getApellido(),
                    vistaMenu.getNombre(),
                    vistaMenu.getFechaNacimiento()
            );
            alumnoData.cargarAlumno(alumno);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar alumno: " + e.getMessage());
        }
    }

    public void buscarAlumno(int idAlumno) {
        try {
            idAlumno = vistaMenu.getId();
            Alumno alumno = alumnoData.buscarAlumnoPorId(idAlumno);

            vistaMenu.setJtfApellido(alumno.getApellido());
            vistaMenu.setJtfDNI(alumno.getDni());
            vistaMenu.setJtfNombre(alumno.getNombre());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumno: " + e.getMessage());
        }
    }

}

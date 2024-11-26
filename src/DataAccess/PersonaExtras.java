/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import entidades.Persona;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NEISER
 */
public class PersonaExtras  extends Persona{
    
     public String getTextoLista() {
        return "ID: " + getIdPersona() + "\t | Nombre: " + getNombre()
                + "\t | Apellido: " +getApellido()+ "\t | DNI: " 
                + getDni()+ "\t |Edad : " + getEdad()+ "\t | Correo: " + getCorreo();
    }

    public PersonaExtras(ResultSet rs) {

        try {
            setIdPersona(rs.getInt(1));
            setNombre(rs.getString(2));
            setApellido(rs.getString(3));
            setDni(rs.getString(4));
            setEdad(rs.getInt(5));
            setCorreo(rs.getString(6));
        } catch (Exception s) {
            System.err.println(s.getMessage());
        }
    }

    public static List<Persona> fromResultSet(ResultSet rs) {
        List<Persona> personas = new ArrayList<>();
        try {
            while (rs.next()) {
                personas.add(new PersonaExtras(rs));
            }
        } catch (Exception s) {
             System.err.println(s.getMessage());
        }
        return personas;
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import entidades.Persona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author NEISER
 */
public class DAOPersonas {
    
    private Connection connection;
    private Statement statement;

    public DAOPersonas(Connection con) {
        try {
            connection = con;
            statement = con.createStatement();
        } catch (Exception s) {
            System.err.println(s.getMessage());
        }
    }

    public List<Persona> getPersonas() {
        try {
            String query = "Select * from persona";
            ResultSet resultSet = statement.executeQuery(query);
            return PersonaExtras.fromResultSet(resultSet);
        } catch (Exception s) {
            System.err.println(s.getMessage());
            return null;
        }
    }

    public boolean actualizarDatos(Persona per) {

        String queryUpd = ""
                + "update persona "
                + "set "
                + "nombre = '" + per.getNombre() + "' ,"
                + "apellido= '" + per.getApellido() + "', "
                + "dni = '" + per.getDni() + "', "
                + "edad = " + per.getEdad() + ", "
                + "correo = '" + per.getCorreo() + "' "
                + "where idpersona = " + per.getIdPersona();

        try {
            int executeUpdate = statement.executeUpdate(queryUpd);
            if (executeUpdate > 0) {
                System.out.println("SE ACTUALIZó el correo");
                return true;
            } else {
                System.err.println("No se pudo actualizar");
            }

        } catch (Exception s) {
            System.err.println(s.getMessage());
        }
        return false;
    }

    public boolean insertarPersona(Persona per) {

        String queryIns = ""
                + "INSERT INTO `lab`.`persona`\n"
                + "(`nombre`,\n"
                + "`apellido`,\n"
                + "`dni`,\n"
                + "`edad`,\n"
                + "`correo`)\n"
                + "VALUES\n"
                + "('" + per.getNombre() + "',\n"
                + "'" + per.getApellido() + "',\n"
                + "'" + per.getDni() + "',\n"
                + per.getEdad() + ",\n"
                + "'" + per.getCorreo() + "');";
        try {
            int executeIns = statement.executeUpdate(queryIns);
            if (executeIns > 0) {
                System.out.println("SE INSERTÓ EL NUEVO REGISTRO");
                return true;
            } else {
                System.err.println("No se pudo insertar");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public boolean eliminarPersona(Persona per) {

        String queryDel = ""
                + "DELETE FROM `lab`.`persona`\n"
                + "WHERE idpersona = " + per.getIdPersona();

        try {
            int executeDel = statement.executeUpdate(queryDel);
            if (executeDel > 0) {
                System.out.println("SE ELIMINÓ EL NUEVO REGISTRO");
                return true;
            } else {
                System.err.println("No se pudo eliminar");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

}

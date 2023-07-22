package org.red_social;

import org.red_social.Utilidades.EntradaSalida;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <h2>Conexion a Base de Datos</h2>
 * Clase que permite la conexion a BBDD siguien patrón de diseño singleton, es decir:
 * 1. Constructor privado
 * 2. Variable estatica para almacenar la única instancia
 * 3. Metodo getInstanciaConexion() encargado de crear la única instancia.
 * 4. Metodo hacerConexion() que estable conexión con base de datos es caso de que no exista o este cerrada.
 *
 * @author Ruth Lovece
 */
public class ConexionBD {

    // Variable estática para almacenar la única instancia de la clase
    private static ConexionBD instanciaConexion;

    //Estado de la conexion
    private static Connection estadoConexion;

    // Constructor privado para evitar la instanciación externa
    private ConexionBD() {
    }
/*
    ///Necesario en patrón singleton???
    ///Metodo para crear una instancia sólo en caso de que sea null
    public static ConexionBD getInstanciaConexion (){
        if(instanciaConexion == null){
            instanciaConexion = new ConexionBD ();
        }
        return instanciaConexion;
    }
*/
    /**
     * <h2>Hacer conexión</h2>
     * Método público para obtener la conexión a la base de datos
     *
     * @author Ruth Lovece
     */
    public static Connection hacerConexion() throws SQLException{
        if (estadoConexion == null || estadoConexion.isClosed()){
            estadoConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app",
                    "root", "");
        }
        return estadoConexion;
    }


    /**
     * <h2>Hacer conexión</h2>
     * Método público para cerrar la conexión a la base de datos
     *
     * @author Ruth Lovece
     */
    public Connection cerrarConexion (){

        try {
            if (estadoConexion != null && !estadoConexion.isClosed()) {
                estadoConexion.close();
                EntradaSalida.SalidaAdvertencia("\n\n Se ha desconectado de la Base de datos", "Advertencia");
            }
        } catch (SQLException e) {
            EntradaSalida.SalidaError("\n\n Error al cerrar la conexión: " + e.getMessage());
        }
        return estadoConexion;
    }
}

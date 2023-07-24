package org.red_social.dao;

import org.red_social.ConexionBD;
import org.red_social.Utilidades.EntradaSalida;
import org.red_social.model.Mensaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h2>Mensaje DAO</h2>
 * Clase que se conecta con la Base de datos
 * DAO - Data Access Object
 *
 * @author ruthLovece
 */
public class MensajeDAO {

    public static void crearMensajeBD (Mensaje mensaje) {

        PreparedStatement ps = null;

        try (Connection objetoConexion = ConexionBD.hacerConexion()) {
            String query = "INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (?,?)";
            ps = objetoConexion.prepareStatement(query);
            ps.setString(1, mensaje.getCuerpoMensaje());
            ps.setString(2,mensaje.getAutor());

            ps.executeUpdate();
            EntradaSalida.SalidaInformacion("\n Se guardo mensaje:\n " +
                    mensaje.getCuerpoMensaje() +
                    "\n Autor: " + mensaje.getAutor(), "Mensaje guardado");

        } catch (SQLException e1) {
            EntradaSalida.SalidaError("\n\n Conexión fallida a Base de datos");

        }
    }

    public static void leerMensajesBD() {
        PreparedStatement ps = null;

        ResultSet resultSet = null;

        try (Connection objetoConexion = ConexionBD.hacerConexion()) {
            String query = "SELECT * FROM `mensajes`";
            ps = objetoConexion.prepareStatement(query);
            resultSet = ps.executeQuery();
            StringBuilder salida = new StringBuilder();
            Mensaje mensaje = new Mensaje();

            while ( resultSet.next()){
               mensaje.setIdMensaje(resultSet.getInt("id_mensaje"));
               mensaje.setCuerpoMensaje(resultSet.getString("mensaje"));
               mensaje.setAutor(resultSet.getString("autor_mensaje"));
               mensaje.setFecha(resultSet.getString("fecha_mensaje"));
               salida.append(mensaje.toString());

            }
            EntradaSalida.SalidaInformacion(salida.toString(), "Lista de mensajes");


        } catch (SQLException e1) {
            EntradaSalida.SalidaError("\n\n Conexión fallida a Base de datos");

        }
    }

    public static void borrarMensajeBD (int idMensaje){
        PreparedStatement ps = null;

        try (Connection objetoConexion = ConexionBD.hacerConexion()) {
            String query = "DELETE FROM `mensajes` WHERE `mensajes`.`id_mensaje` = ?";
            ps = objetoConexion.prepareStatement(query);
            ps.setInt(1, idMensaje);
            ps.executeUpdate();
            EntradaSalida.SalidaInformacion("\n\nSe borro registro " + idMensaje, "Borrado exitos");
        } catch (SQLException e1) {
            EntradaSalida.SalidaError("\n\n Falló borrado de registro");
        }
    }

    public static void modificarMensajeBD (Mensaje mensaje){

    }

}

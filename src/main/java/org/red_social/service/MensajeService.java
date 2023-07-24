package org.red_social.service;


import org.red_social.ConexionBD;
import org.red_social.Utilidades.EntradaSalida;
import org.red_social.dao.MensajeDAO;
import org.red_social.model.Mensaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * <h2>Mensaje Service</h2>
 * Clase que contiene los métodos que va a recibe el menú y que se van a conectar con la capa DAO
 * para interactuar con la BBDD
 *
 * @author ruthLovece
 */
public class MensajeService {

    public static void crearMensaje (){
        Mensaje mensaje = new Mensaje();
        mensaje.setCuerpoMensaje(EntradaSalida.entradaString("\n Ingrese su mensaje"));
        mensaje.setAutor(EntradaSalida.entradaString("\n Ingrese su nombre"));

        MensajeDAO.crearMensajeBD(mensaje);
    }
    public static void listarMensajes (){
        MensajeDAO.leerMensajesBD();

    }
    public static void borrarMensaje (){
        int idMensaje = EntradaSalida.entradaInt("\n\n Ingrese Id del mensaje a borrar");
        MensajeDAO.borrarMensajeBD(idMensaje);
    }

    public static void editarMensaje(){

    }
}

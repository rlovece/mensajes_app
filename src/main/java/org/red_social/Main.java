package org.red_social;

import org.red_social.Utilidades.*;
import org.red_social.service.MensajeService;

public class Main {
    public static void main(String[] args) {

        int opcion = 0;
        do {
            opcion = EntradaSalida.entradaInt(
                    "\n\n       Bienvenido \n\n" +
                            "    Ingrese la opción deseada\n" +
                            "\n 1. Ingresar nuevo mensaje" +
                            "\n 2. Listar mensajes" +
                            "\n 3. Borrar mensaje" +
                            "\n 4. Modificar mensaje" +
                            "\n 0. Salir\n\n" );

            switch (opcion){

                case 1:
                    MensajeService.crearMensaje();
                    break;

                case 2:
                    MensajeService.listarMensajes();
                    break;

                case 3:
                    MensajeService.borrarMensaje();
                    break;

                case 4:
                    MensajeService.editarMensaje();
                    break;

                case 0:
                    EntradaSalida.SalidaInformacion("\n\n Gracias por visitar Red Social",
                            "Hasta pronto");
                    break;

                default:
                    EntradaSalida.SalidaError("\n\n Opción Incorrecta");

            }
        } while (opcion != 0);
    }
}
package org.red_social.exceptions;

/**
 * <h2> Excepción Password Inválida</h2>
 * Excepcion a lanzar cuando la contraseña que se desea generar no tenga el formato adecuado.
 *
 * esta excepcion será lanzada en el método {@link org.red_social.Utilidades.EntradaSalida#validarPassword(String)} cuando
 * String ingresado por parametro no contecta formato aceptable.
 *  *
 * @author Ruth Lovece
 *
 * */
public class PasswordInvalidaException extends Exception{

    public PasswordInvalidaException (String mensaje){
        super(mensaje);
    }
}

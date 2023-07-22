package org.red_social.exceptions;

/**
 * <h2> Excepción Usuario Inválido</h2>
 * Excepcion a lanzar cuando el username no tenga el formato adecuado.
 *
 * esta excepcion será lanzada en el método {@link org.red_social.Utilidades.EntradaSalida#validarUsername(String)} cuando
 * String ingresado por parametro no contecta formato aceptable.
 *  *
 * @author Ruth Lovece
 *
 * */
public class UsuarioInvalidoException extends Exception{

    public UsuarioInvalidoException (String mensaje){
        super(mensaje);
    }
}

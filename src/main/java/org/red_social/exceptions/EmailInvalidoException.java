package org.red_social.exceptions;

/**
 * <h2> Excepción Email Icorrecto</h2>
 * Excepcion a lanzar cuando el mail no tenga el formato adecuado.
 *
 * esta excepcion será lanzada en el método {@link org.red_social.Utilidades.EntradaSalida#validarEmail(String)} cuando
 * String ingresado por parametro no contecta formato aceptable.
 *  *
 * @author Ruth Lovece
 *
 * */
public class EmailInvalidoException extends Exception {
    public EmailInvalidoException (String mensaje) {
        super(mensaje);
    }

}

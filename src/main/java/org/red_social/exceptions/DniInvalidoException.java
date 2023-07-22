package org.red_social.exceptions;

/**
 * <h2> Excepción DNI Incorrecto</h2>
 * Excepcion a lanzar cuando el DNI no tenga el formato adecuado.
 *
 * esta excepcion será lanzada en el método {@link org.red_social.Utilidades.EntradaSalida#validarDNI(String)} cuando
 * String ingresado por parametro no contecta formato aceptable.
 *  *
 * @author Ruth Lovece
 *
 * */
public class DniInvalidoException extends Exception{
    public DniInvalidoException (String mensaje) {
        super(mensaje);
    }
}
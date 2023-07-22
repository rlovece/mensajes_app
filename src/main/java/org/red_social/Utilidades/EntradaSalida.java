package org.red_social.Utilidades;

import org.red_social.exceptions.*;

import javax.swing.*;
import java.util.UUID;

import static javax.swing.JOptionPane.*;

public class EntradaSalida {

    ///region Entradas
    /**
     * <h2> Entrada de un número entero</h2>
     * Metodo para ingresar un número entero por teclado.
     * La entrada se obtiene con JOptionPane como string y se parsea a Integer dentro de un try-catch que muestra error y retorna al bucle do
     * en caso de capturase la excepción, e ingresa nuevamente al bucle do.
     *
     * @see JOptionPane
     * @return numero entero ingresado
     * @author Ruth Lovece
     */
    public static int entradaInt (String msj){

        boolean continuar = false;
        int nro = 0;

        while (!continuar) {
            try {
                String entrada = showInputDialog(msj);
                nro = Integer.parseInt(entrada);
                continuar = true;
            } catch (NumberFormatException e) {
                String error = "Introduzca un nro entero";
                EntradaSalida.SalidaError(error);
            }
        }
        return  nro;
    }

    /**
     * <h2> Entrada de un número flotante</h2>
     * Metodo para ingresar un número flotante por teclado.
     * La entrada se obtiene con JOptionPane como string y se parsea a Float dentro de un try-catch que muestra error y retorna al bucle do
     * en caso de capturase la excepción, e ingresa nuevamente al bucle do.
     *
     * @see JOptionPane
     * @return numero entero ingresado
     * @author Ruth Lovece
     */
    public static float entradafloat (String mensaje){
        boolean continuar = false;
        float nro = 0;
        do {
            try {
                String entrada = showInputDialog(mensaje);
                nro= Float.parseFloat(entrada);
                continuar = true;
            }catch (NumberFormatException e){
                String error = "Introduzca un nro";
                EntradaSalida.SalidaError(error);
            }
        } while (continuar);
        return  nro;
    }

    /**
     * <h1> Entrada de un String</h1>
     * Metodo para ingresar  un String utilizando JOptionPane
     *
     * @see JOptionPane
     * @return String ingresado por teclado
     * @author Ruth Lovece
     */
    public static String entradaString (String msj){
        return showInputDialog(msj);
    }

    /**
     * <h1> Entrada de un email</h1>
     * Metodo para solicitar el ingreso de correo electronico por teclado. Se utiliza JOptionPane para la
     * solicitud.
     * <p>
     * Se invoca método {@link org.red_social.Utilidades.EntradaSalida#validarEmail(String)} dentro de un try-catch
     * para asegurase que el correo ingresado contenga @ y .com.
     * En caso de ingresar al catch, se muetra el error al usuario y se ingresa nuevamente al bucle do.
     *
     * @see JOptionPane
     * @return email ingresado por teclado
     * @author Ruth Lovece
     */
    public static String entradaMail (){
        boolean continuar = false;
        do {
            try {
                String entrada = showInputDialog("\n Ingrese correo electrónico \n\n");
                validarEmail(entrada);
                return entrada;
            } catch (EmailInvalidoException e){
                String error = "Correo inválido, debe contener @ y .com \n\n";
                EntradaSalida.SalidaError(error);
            }
        } while (!continuar);
        return  null;
    }

    /**
     * <h1> Entrada de un DNI</h1>
     * Metodo para solicitar el ingreso de DNI por teclado. Se utiliza JOptionPane para la
     * solicitud.
     * <p>
     * Se invoca mètodo {@link org.red_social.Utilidades.EntradaSalida#validarDNI(String)} dentro de un try-catch
     * para asegurase que el DNI contiene 8 dìgitos numericos
     * En caso de ingresar al catch, se muetra el error al usuario y se ingresa nuevamente al bucle do.
     *
     * @see JOptionPane
     * @return DNI ingresado por teclado
     * @author Ruth Lovece
     */
    public static String entradaDNI (){
        boolean continuar = false;
        do {
            try {
                String entrada = showInputDialog("\n Ingrese DNI \n\n");
                validarDNI(entrada);
                return entrada;
            } catch (DniInvalidoException e){
                String error = "El DNI debe contener 8 digitos numericos. \nSi Su DNI tiene 7 digitos, agregue 0 al comienzo. \n\n";
                EntradaSalida.SalidaError(error);
            }
        } while (!continuar);
        return  null;
    }


    /**
     * <h2> Entrada de generación password</h2>
     * Metodo para solicitar el ingreso y generación de password por teclado. Se utiliza JOptionPane para la
     * solicitud.
     * <p>
     * Se invoca mètodo {@link org.red_social.Utilidades.EntradaSalida#validarPassword(String)} dentro de un try-catch
     * para asegurase que el Password contiene al menos 6 dígitos alfanuméricos
     * En caso de ingresar al catch, se muetra el error al usuario y se ingresa nuevamente al bucle do.
     *
     * @see JOptionPane
     * @return password ingresada por teclado
     * @author Ruth Lovece
     */
    public static String entradaGeneracionPassword (){
        boolean continuar = false;
        do {
            try {
                String entrada = showInputDialog("\n Ingrese una contraseña \n" +
                        "Debe contener al menos 6 dígitos alfanuméricos \n\n");
                validarPassword(entrada);
                return entrada;
            } catch (PasswordInvalidaException e){
                String error = "La contraseña ingresada no cumple los requisitos\nDebe contener al menos 6 dígitos y una letra \n\n";
                EntradaSalida.SalidaError(error);
            }
        } while (!continuar);
        return  null;
    }

    /**
     * <h2> Entrada username nuevo</h2>
     * Metodo para solicitar el ingreso username por teclado. Se utiliza JOptionPane para la
     * solicitud.
     * <p>
     * Se invoca mètodo {@link org.red_social.Utilidades.EntradaSalida#validarUsuario(String)} dentro de un try-catch
     * para asegurase que el username contiene al menos 5 dígitos alfanuméricos
     * En caso de ingresar al catch, se muetra el error al usuario y se ingresa nuevamente al bucle do.
     *
     * @see JOptionPane
     * @return username ingresada por teclado
     * @author Ruth Lovece
     */
    public static String entradaUsuario (){
        boolean continuar = false;
        do {
            try {
                String entrada = showInputDialog("\n Ingrese nombre de usuario \n" +
                        "Debe contener al menos 5 dígitos alfanuméricos \n\n");
                validarUsuario(entrada);
                return entrada;
            } catch (UsuarioInvalidoException e){
                String error = "El usuario ingresado no cumple con los requisitos\nDebe contener al menos 5 dígitos y una letra \n\n";
                EntradaSalida.SalidaError(error);
            }
        } while (!continuar);
        return  null;
    }

    ///endRegion

    ///region Salidas
    /**
     * <h2> Mensaje con Error</h2>
     * Metodo mostrar errores al usuario utilizando JOptionPane. Se solititan como paràmetros el mensaje que
     * se quiere mostrar y el tìtulo de la ventana.
     *
     * @see JOptionPane
     * @param msj
     * @author Ruth Lovece
     */
    public static void SalidaError (String msj){
        JOptionPane.showMessageDialog(null, msj, " ❌ ERROR ❌", ERROR_MESSAGE);
    }

    /**
     * <h2> Mensaje con Información</h2>
     * Metodo para mostrar información al usuario utilizando JOptionPane. Se solititan como paràmetros el mensaje que
     * se quiere mostrar y el tìtulo de la ventana.
     *
     * @see JOptionPane
     * @param msj
     * @param titulo
     * @author Ruth Lovece
     */
    public static void SalidaInformacion (String msj, String titulo){
        JOptionPane.showMessageDialog(null, msj, titulo, INFORMATION_MESSAGE);
    }

    /**
     * <h2> Mensaje con Advertencia</h2>
     * Metodo para mostrar advertencias al usuario utilizando JOptionPane. Se solititan como paràmetros el mensaje que
     * se quiere mostrar y el tìtulo de la ventana.
     *
     * @see JOptionPane
     * @param msj
     * @param titulo
     * @author Ruth Lovece
     */
    public static void SalidaAdvertencia (String msj, String titulo) {
        JOptionPane.showMessageDialog(null, msj, titulo, WARNING_MESSAGE);
    }
    ///endregion

    ///region Entradas Aleatoria
    /**
     * <h2> Codigo aleatorio</h2>
     * Metodo para generar un código de 10 dìgitos alfanumèrico aleatorio.
     *
     * @see UUID
     * @return codigo alfanumérico de 10 dìgitos
     * @author Ruth Lovece
     */
    public static String CodigoPaquete (){
        String codigo = UUID.randomUUID().toString().substring(0,10).toUpperCase(); //genera un codigo random
        return codigo;
    }

    ///endregion

    ///region Validaciones

    /**
     * <h2> Validación ingreso Email</h2>
     * Método que valida que la dirección de correo electrónico ingresada contenga @ y .com
     * En caso de no contenear cualquiera estos se lanza un excepción.
     *
     * @param email
     * @exception EmailInvalidoException
     * @author Ruth Lovece
     *
     * */
    public static void validarEmail (String email) throws EmailInvalidoException {
        if (!email.contains("@") || !email.contains(".com")){
            throw new EmailInvalidoException("Formato de email incorrecto");
        }
    }

    /**
     * <h2> Validación ingreso DNI</h2>
     * Método que valida que el dni contenga 8 dígitos numéricos.
     * En caso contrario se lanzará la excepción
     *
     * @param dni
     * @exception DniInvalidoException
     * @author Ruth Lovece
     *
     * */
    public static void validarDNI (String dni) throws DniInvalidoException {
        try {
            Integer.parseInt(dni);
        } catch (NumberFormatException e) {
            throw new DniInvalidoException("DNI con digitos no numéricos");
        }
        if (dni.length()!=8) {
            throw new DniInvalidoException("DNI no contiene 8 digitos");
        }

    }

    /**
     * <h2> Validación ingreso para generar Password</h2>
     * Método que valida que la contraseña que se desea generar e ingresada por teclado contenga al menos 6 dígitos,
     * y al menos una letra.
     * En caso contrario se lanzará la excepción
     *
     * @param password
     * @exception PasswordInvalidaException
     * @author Ruth Lovece
     *
     * */
    public static void validarPassword (String password) throws PasswordInvalidaException {
        try {
            Integer.parseInt(password);
            throw new PasswordInvalidaException("Password sin letras");
        } catch (NumberFormatException e) {
            if (password.length()<6) {
                throw new PasswordInvalidaException("Password con menos de 6 caracteres");
            }
        }
    }

    /**
     * <h2> Validación ingreso usuario</h2>
     * Método que valida que el username contiene al menos 5 dígitos alfanumericos.
     * En caso contrario se lanzará la excepción
     *
     * @param usuario
     * @exception UsuarioInvalidoException
     * @author Ruth Lovece
     *
     * */
    public static void validarUsuario (String usuario) throws UsuarioInvalidoException {
        try {
            Integer.parseInt(usuario);
            throw new UsuarioInvalidoException("Username sin letras");
        } catch (NumberFormatException e) {
            if (usuario.length()<5) {
                throw new UsuarioInvalidoException("El usuario debe contener minimo 5 caracteres");
            }
        }

    }
    ///endregion

}
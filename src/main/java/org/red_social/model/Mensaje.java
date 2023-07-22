package org.red_social.model;

/**
 * <h2>Clase Mensaje</h2>
 *
 *
 * @author ruthLovece
 */
public class Mensaje {

    ///region Atribubtos
    private int idMensaje;

    private String cuerpoMensaje;

    private String autor;

    private String fecha;

    ///endregion

    ///region Contructores

    /**
     * <h2>Contructor Mensaje vacío</h2>
     *
     * Contructor para generar mensaje vacío y reservar espacio en la memoria.
     *
     * @author ruthLovece
     */
    public Mensaje (){}

    /**
     * <h2>Contructor Mensaje con atributos</h2>
     *
     * Contructor para generar mensaje con todos sus atributos completos y reservar espacio en la memoria.
     *
     * @param idMensaje
     * @param cuerpoMensaje
     * @param autor
     * @param fecha
     * @author ruthLovece
     */
    public Mensaje(int idMensaje, String cuerpoMensaje, String autor, String fecha) {
        this.idMensaje = idMensaje;
        this.cuerpoMensaje = cuerpoMensaje;
        this.autor = autor;
        this.fecha = fecha;
    }

    ///endregion

    //region Getters y Setters

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getCuerpoMensaje() {
        return cuerpoMensaje;
    }

    public void setCuerpoMensaje(String cuerpoMensaje) {
        this.cuerpoMensaje = cuerpoMensaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    ///endregion


}

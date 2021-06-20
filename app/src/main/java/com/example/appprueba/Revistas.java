package com.example.appprueba;

public class Revistas {
    private String isseu_id;
    private String volumen;
    private String numero;
    private String anio;
    private String fecha;
    private String titulo;
    private String doi;
    private String cover;

    public String getIsseu_id() {
        return isseu_id;
    }

    public void setIsseu_id(String isseu_id) {
        this.isseu_id = isseu_id;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Revistas(){

    }
    public Revistas(String isseu_id,String volumen,String numero,String anio,String fecha,String titulo,String doi,String cover ){
        this.isseu_id = isseu_id;
        this.volumen = volumen;
        this.numero = numero;
        this.anio = anio;
        this.fecha = fecha;
        this.titulo = titulo;
        this.doi = doi;
        this.cover = cover;
    }
}

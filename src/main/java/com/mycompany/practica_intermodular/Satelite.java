/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_intermodular;

/**
 *
 * @author Usuario
 */
public class Satelite {
    int id;
    String nombre;
    int id_planeta;
    double radio;
    double distancia_media_planeta;
    int periodo_orbital;
    int temperatura_media;
    String tipo_cuerpo;
    String fecha_creacion;

    public Satelite(int id, String nombre, int id_planeta, double radio, double distancia_media_planeta, int periodo_orbital, int temperatura_media, String tipo_cuerpo, String fecha_creacion) {
        this.id = id;
        this.nombre = nombre;
        this.id_planeta = id_planeta;
        this.radio = radio;
        this.distancia_media_planeta = distancia_media_planeta;
        this.periodo_orbital = periodo_orbital;
        this.temperatura_media = temperatura_media;
        this.tipo_cuerpo = tipo_cuerpo;
        this.fecha_creacion = fecha_creacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_planeta() {
        return id_planeta;
    }

    public void setId_planeta(int id_planeta) {
        this.id_planeta = id_planeta;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getDistancia_media_planeta() {
        return distancia_media_planeta;
    }

    public void setDistancia_media_planeta(double distancia_media_planeta) {
        this.distancia_media_planeta = distancia_media_planeta;
    }

    public int getPeriodo_orbital() {
        return periodo_orbital;
    }

    public void setPeriodo_orbital(int periodo_orbital) {
        this.periodo_orbital = periodo_orbital;
    }

    public int getTemperatura_media() {
        return temperatura_media;
    }

    public void setTemperatura_media(int temperatura_media) {
        this.temperatura_media = temperatura_media;
    }

    public String getTipo_cuerpo() {
        return tipo_cuerpo;
    }

    public void setTipo_cuerpo(String tipo_cuerpo) {
        this.tipo_cuerpo = tipo_cuerpo;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    @Override
    public String toString() {
        return "Satelite{" + "nombre=" + nombre + ", id_planeta=" + id_planeta + ", radio=" + radio + ", distancia_media_planeta=" + distancia_media_planeta + ", periodo_orbital=" + periodo_orbital + ", temperatura_media=" + temperatura_media + ", tipo_cuerpo=" + tipo_cuerpo + ", fecha_creacion=" + fecha_creacion + '}';
    }
    
    
}

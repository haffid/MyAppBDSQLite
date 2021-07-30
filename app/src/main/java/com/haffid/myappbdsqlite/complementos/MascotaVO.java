package com.haffid.myappbdsqlite.complementos;

public class MascotaVO {

    private int idMascota, edadMascota;
    private String nombreMascota, razaMascota, colorMascota;

    public MascotaVO() {
    }

    public MascotaVO(int idMascota, int edadMascota, String nombreMascota, String razaMascota, String colorMascota) {
        this.idMascota = idMascota;
        this.edadMascota = edadMascota;
        this.nombreMascota = nombreMascota;
        this.razaMascota = razaMascota;
        this.colorMascota = colorMascota;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getEdadMascota() {
        return edadMascota;
    }

    public void setEdadMascota(int edadMascota) {
        this.edadMascota = edadMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRazaMascota() {
        return razaMascota;
    }

    public void setRazaMascota(String razaMascota) {
        this.razaMascota = razaMascota;
    }

    public String getColorMascota() {
        return colorMascota;
    }

    public void setColorMascota(String colorMascota) {
        this.colorMascota = colorMascota;
    }
}

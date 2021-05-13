package org.byron.beans.Posicion;

public class Posicion {
    private int id;
    private String coor_x;
    private String coor_y;

    public Posicion(int id, String coor_x, String coor_y) {
        this.id = id;
        this.coor_x = coor_x;
        this.coor_y = coor_y;
    }

    public Posicion(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoor_x() {
        return coor_x;
    }

    public void setCoor_x(String coor_x) {
        this.coor_x = coor_x;
    }

    public String getCoor_y() {
        return coor_y;
    }

    public void setCoor_y(String coor_y) {
        this.coor_y = coor_y;
    }
}

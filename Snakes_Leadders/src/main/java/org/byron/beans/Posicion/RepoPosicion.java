package org.byron.beans.Posicion;

public interface RepoPosicion <T>{

    void guardar(T t);   // consulta guardo o actualizo una posicion

    void actualizarPos(T t);
}

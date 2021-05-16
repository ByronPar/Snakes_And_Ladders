package org.byron.beans.Posicion;

public interface RepoPosicion<T> {

    void guardar(T t, int id_tab);   // consulta guardo o actualizo una posicion

    void actualizarPos(T t);
}

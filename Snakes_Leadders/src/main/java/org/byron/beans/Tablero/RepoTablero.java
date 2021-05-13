package org.byron.beans.Tablero;

import java.util.List;

public interface RepoTablero<T> {
    T getTablero(int id); //consulta traigo el tablero

    void guardar(T t);

    void eliminar(int id);
}

package org.byron.beans.Tablero;

public interface RepoTablero<T> {
    void guardar(T t);

    T ultimo();
}

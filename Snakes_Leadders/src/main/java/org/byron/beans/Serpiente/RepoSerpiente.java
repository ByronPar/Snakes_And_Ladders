package org.byron.beans.Serpiente;

public interface RepoSerpiente<T> {
    void guardar(T t);

    void borrar(int id);
}

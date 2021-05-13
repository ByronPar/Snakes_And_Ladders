package org.byron.beans.Jugador;

import java.util.List;

public interface RepoJugador<T> {
    List<T> listar(); // listo todos los registros

    T porNombre(String nombre);//consulta , traigo el jugador por su nombre

    void guardar(T t);   // consulta guardo o actualizo un jugador

    void eliminar(int id); // consulta elimino un jugador
}

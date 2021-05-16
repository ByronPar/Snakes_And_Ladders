package org.byron.beans.Posicion;

import org.byron.beans.Jugador.Jugador;
import org.byron.conexion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PosicionImpl implements  RepoPosicion<Posicion>{

    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    @Override
    public void guardar(Posicion posicion,int id_tab) {
        String sql;
        if(posicion.getId()>0)  {
            sql = "UPDATE posicion SET coor_x=?, coor_y=? WHERE id=?";
        }else{
            sql = "INSERT INTO posicion(coor_x, coor_y, id_pos_tab. id_tipo) VALUES(?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, posicion.getCoor_x());
            stmt.setInt(2, posicion.getCoor_y());
            stmt.setInt(3, id_tab);
            stmt.setInt(4, posicion.getTipo().getId());
            if(posicion.getId()>0){
                stmt.setInt(3, posicion.getId());
            }
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void actualizarPos(Posicion posicion) {
        String sql = "UPDATE posicion SET coor_x=?, coor_y=? WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, posicion.getCoor_x());
            stmt.setInt(2, posicion.getCoor_y());

            if(posicion.getId()>0){
                stmt.setInt(3, posicion.getId());
            }
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

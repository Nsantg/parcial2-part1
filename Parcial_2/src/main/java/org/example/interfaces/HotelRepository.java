package org.example.interfaces;

import org.example.domain.Hotel;

import java.util.List;

public interface HotelRepository {
    void guardar(Hotel hotel);
    Hotel obtenerPorId(int id);
    List<Hotel> obtenerTodos();
    void actualizar(Hotel hotel);
    void eliminar(int id);
}

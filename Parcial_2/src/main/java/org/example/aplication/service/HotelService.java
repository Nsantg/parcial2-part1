package org.example.aplication.service;

import org.example.domain.Hotel;

import java.util.List;

public interface HotelService {
    void agregarHotel(Hotel hotel);
    Hotel obtenerHotel(int id);
    List<Hotel> listarHoteles();
    void actualizarHotel(Hotel hotel);
    void eliminarHotel(int id);
}

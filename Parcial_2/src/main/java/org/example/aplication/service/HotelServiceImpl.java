package org.example.aplication.service;

import org.example.interfaces.HotelRepository;
import org.example.domain.Hotel;

import java.util.List;

public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void agregarHotel(Hotel hotel) {
        hotelRepository.guardar(hotel);
    }

    @Override
    public Hotel obtenerHotel(int id) {
        return hotelRepository.obtenerPorId(id);
    }

    @Override
    public List<Hotel> listarHoteles() {
        return hotelRepository.obtenerTodos();
    }

    @Override
    public void actualizarHotel(Hotel hotel) {
        hotelRepository.actualizar(hotel);
    }

    @Override
    public void eliminarHotel(int id) {
        hotelRepository.eliminar(id);
    }
}

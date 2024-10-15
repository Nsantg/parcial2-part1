package org.example.ImplemetnacionRepository;

import org.example.domain.Hotel;
import org.example.interfaces.HotelRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HotelRepositoryImpl implements HotelRepository {
    private final String archivo = "hoteles.ser";

    @Override
    public void guardar(Hotel hotel) {
        List<Hotel> hoteles = obtenerTodos();
        hoteles.add(hotel);
        guardarLista(hoteles);
    }

    @Override
    public Hotel obtenerPorId(int id) {
        List<Hotel> hoteles = obtenerTodos();
        return hoteles.stream().filter(h -> h.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Hotel> obtenerTodos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Hotel>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void actualizar(Hotel hotel) {
        List<Hotel> hoteles = obtenerTodos();
        for (int i = 0; i < hoteles.size(); i++) {
            if (hoteles.get(i).getId() == hotel.getId()) {
                hoteles.set(i, hotel);
                break;
            }
        }
        guardarLista(hoteles);
    }

    @Override
    public void eliminar(int id) {
        List<Hotel> hoteles = obtenerTodos();
        hoteles.removeIf(h -> h.getId() == id);
        guardarLista(hoteles);
    }

    private void guardarLista(List<Hotel> hoteles) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(hoteles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

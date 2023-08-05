package com.programacion.demo.repository;

import java.util.List;

import com.programacion.demo.repository.modelo.Vehiculo;

public interface IVehiculoRepository {

	public List<Vehiculo> buscarTodos();

	public Vehiculo buscarPorPlaca(String placa);

}

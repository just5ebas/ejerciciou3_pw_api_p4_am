package com.programacion.demo.service;

import java.util.List;

import com.programacion.demo.service.to.VehiculoTO;

public interface IVehiculoService {

	public List<VehiculoTO> buscarTodos();

	public VehiculoTO buscarPorPlaca(String placa);

}

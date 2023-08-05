package com.programacion.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.demo.repository.IVehiculoRepository;
import com.programacion.demo.repository.modelo.Vehiculo;
import com.programacion.demo.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Override
	public List<VehiculoTO> buscarTodos() {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.buscarTodos().stream().map(v -> this.convertir(v)).collect(Collectors.toList());
	}

	@Override
	public VehiculoTO buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.convertir(this.vehiculoRepository.buscarPorPlaca(placa));
	}

	private VehiculoTO convertir(Vehiculo vehiculo) {
		VehiculoTO vTo = new VehiculoTO();
		vTo.setId(vehiculo.getId());
		vTo.setPlaca(vehiculo.getPlaca());
		vTo.setModelo(vehiculo.getModelo());
		vTo.setAnho(vehiculo.getAnho());
		vTo.setPaisOrigen(vehiculo.getPaisOrigen());
		return vTo;
	}

}

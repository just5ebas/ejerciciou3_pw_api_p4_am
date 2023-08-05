package com.programacion.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.demo.service.IVehiculoService;
import com.programacion.demo.service.to.VehiculoTO;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin
public class VehiculoControllerRestful {

	@Autowired
	private IVehiculoService vehiculoService;

	// GET
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoTO>> consultarTodos() {
		List<VehiculoTO> lista = this.vehiculoService.buscarTodos();

		for (VehiculoTO v : lista) {
			Link myLink = linkTo(methodOn(VehiculoControllerRestful.class).consultarPorPlaca(v.getPlaca()))
					.withSelfRel();
			v.add(myLink);
		}

		return new ResponseEntity<List<VehiculoTO>>(lista, null, HttpStatus.OK);
	}

	@GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehiculoTO> consultarPorPlaca(@PathVariable String placa) {
		return ResponseEntity.status(HttpStatus.OK).body(this.vehiculoService.buscarPorPlaca(placa));
	}

}

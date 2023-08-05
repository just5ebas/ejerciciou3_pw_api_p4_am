package com.programacion.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.programacion.demo.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class IVehiculoRepositoryImpl implements IVehiculoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Vehiculo> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);
		return myQuery.getResultList();
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = this.entityManager
				.createQuery("SELECT v FROM Vehiculo v WHERE v.placa = :datoPlaca", Vehiculo.class);
		myQuery.setParameter("datoPlaca", placa);
		return myQuery.getSingleResult();
	}

}

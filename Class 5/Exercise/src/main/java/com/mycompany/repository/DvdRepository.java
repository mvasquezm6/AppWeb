package com.mycompany.repository;

/**
 *
 * @author HAMP
 */

/*
Metodo Flush
Este método es un poco mas curioso y es el encargado de sincronizar el PersistenceContext 
contra la base de datos .Normalmente todo el mundo piensa que cuando nosotros invocamos el 
método persist() o remove() se ejecutan automaticamente las consultas contra la base de datos .
Esto no es así ya que el EntityManager irá almacenando las modificaciones que nosotros realizamos 
sobre las entidades .Para mas adelante persistirlas contra 
la base de datos todas de golpe ya sea invocando flush o realizando un commit a una transacción.
*/
import java.util.List;

import javax.persistence.EntityManager;

import com.mycompany.entities.DVD;


public class DvdRepository {
	private EntityManager entityManager;

	public DvdRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(DVD dvd) {
		this.entityManager.persist(dvd);
		this.entityManager.flush();
	}

	public void remove(DVD dvd) {
		this.entityManager.remove(dvd);
	}

	@SuppressWarnings("unchecked")
	public List<DVD> getDVDs() {
		return this.entityManager.createNamedQuery("DVD.findAll")
				.getResultList();
	}

	public Long getCountDVDs() {
		return (Long) this.entityManager.createNamedQuery("DVD.count")
				.getSingleResult();
	}

}

package com.mycompany.managedbeans;

/**
 *
 * @author HAMP
 */
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import com.mycompany.entities.Genero;
import com.mycompany.repository.GeneroRepository;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


@ManagedBean
public class GeneroBean {

	@ManagedProperty(value="#{entityManager}")
	private EntityManager entityManager;

	private List<Genero> generos = null;
	
	public List<Genero> getGeneros() {
		if(this.generos == null){
			GeneroRepository repository = new GeneroRepository(entityManager);
			this.generos = repository.getGeneros();
		}
		
		return this.generos;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
        
        @SuppressWarnings("unused")
	private EntityManager getManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return (EntityManager) request.getAttribute(" EntityManager ");
	}
}
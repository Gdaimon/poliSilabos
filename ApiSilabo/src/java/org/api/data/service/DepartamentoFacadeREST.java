package org.api.data.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.api.data.ParDepartamento;


/**
 *
 * @author DarkKlitos
 */
@Stateless
@Path("/departamento")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class DepartamentoFacadeREST extends AbstractFacade<ParDepartamento> {
    @PersistenceContext(unitName = "ApisilaboPU") 
    private EntityManager em;

    public DepartamentoFacadeREST() {
        super(ParDepartamento.class);
    }

    /**
     * Metodo que crea en la db un Departamento
     * @param entity 
     */
    @POST
    @Override
    public void create(ParDepartamento entity) {
        super.create(entity);
    }

    /**
     * Metodo que modifica un Departamento en la db
     * @param id
     * @param entity 
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") int id, ParDepartamento entity) {
        super.edit(entity);
    }

    /**
     * Metodo que elimina un Departamento de la db
     * @param id 
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        super.remove(super.find(id));
    }

    /**
     * Metodo que busca un Departamento por su id en la db
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    public ParDepartamento find(@PathParam("id") int id) {
        return super.find(id);
    }

    /**
     * Metodo que retorna todos los Departamentos de la db
     * @return 
     */
    @GET
    @Override
    public List<ParDepartamento> findAll() {
        return super.findAll();
    }

    /**
     * Metodo que realiza la busqueda de uno o varios Departamentos por sus atributos
     * @param parametro
     * @return 
     */
    @GET
    @Path("buscar/{parametro}")
    public List<ParDepartamento> search(@PathParam("parametro") String param
    ) {
        // Returns a list of deparamentos filterd by GET parameters.
        return em.createNamedQuery("ParDepartamento.findByParams")
                 .setParameter("parametro", "%"+ param + "%").getResultList();
    }

    /**
     * Metodo que realizar la busqueda de varios Departamentos indicandoles un limite superior e inferior
     * @param from
     * @param to
     * @return 
     */
    @GET
    @Path("{from}/{to}")
    public List<ParDepartamento> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /**
     * 
     * @return 
     */
    @GET
    @Path("count")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
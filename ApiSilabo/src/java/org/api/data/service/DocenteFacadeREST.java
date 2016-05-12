/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.api.data.service;
import org.api.data.Docente;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DarkKlitos
 */
@Stateless
@Path("/docente")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class DocenteFacadeREST extends AbstractFacade<Docente> {
    @PersistenceContext(unitName = "ApisilaboPU") 
    private EntityManager em;

    public DocenteFacadeREST() {
        super(Docente.class);
    }

    /**
     * Metodo que crea en la db un Docente
     * @param entity 
     */
    @POST
    @Override
    public void create(Docente entity) {
        super.create(entity);
    }

    /**
     * Metodo que modifica un Docente en la db
     * @param id
     * @param entity 
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") int id, Docente entity) {
        super.edit(entity);
    }

    /**
     * Metodo que elimina un Docente de la db
     * @param id 
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        super.remove(super.find(id));
    }

    /**
     * Metodo que busca un Docente por su id en la db
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    public Docente find(@PathParam("id") int id) {
        return super.find(id);
    }

    /**
     * Metodo que retorna todos los Docentes de la db
     * @return 
     */
    @GET
    @Override
    public List<Docente> findAll() {
        return super.findAll();
    }

    /**
     * Metodo que realiza la busqueda de uno o varios docentes por sus atributos
     * @param cedula
     * @param nombre
     * @param categoria
     * @return 
     */
    @GET
    @Path("buscar")
    public List<Docente> search(
        @DefaultValue("") @QueryParam("cedula") String cedula,
        @DefaultValue("") @QueryParam("nombre") String nombre,
        @DefaultValue("") @QueryParam("categoria") String categoria
//        @DefaultValue("") @QueryParam("id") int id
    ) {
        // Returns a list of teacher filterd by GET parameters.
        return em.createNamedQuery("Docente.findByParams")
            .setParameter("cedula", "%" + cedula + "%")
            .setParameter("nombre", "%" + nombre + "%")
            .setParameter("categoria", "%" + categoria + "%")
            // .setParameter("id", "%" + id + "%") 
            .getResultList();
    }

    /**
     * Metodo que realizar la busqueda de varios docentes indicandoles un limite superior e inferior
     * @param from
     * @param to
     * @return 
     */
    @GET
    @Path("{from}/{to}")
    public List<Docente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

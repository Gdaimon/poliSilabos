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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DocenteFacadeREST extends AbstractFacade<Docente> {
    @PersistenceContext(unitName = "ApiSilaboPU") 
    private EntityManager em;

    public DocenteFacadeREST() {
        super(Docente.class);
    }

    @POST
    @Override
    public void create(Docente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") int id, Docente entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    public Docente find(@PathParam("id") int id) {
        return super.find(id);
    }

    @GET
    @Override
    public List<Docente> findAll() {
        return super.findAll();
    }

    /**
     * Find a list of teachers given certain parameters.
     *
     * <code>
     *
     *      /profesor/buscar?first_name=John&last_name=Doe&document_number=576944&gender=masculino
     *
     * </code>
     *
     * @return Procesor list
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

    @GET
    @Path("{from}/{to}")
    public List<Docente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}

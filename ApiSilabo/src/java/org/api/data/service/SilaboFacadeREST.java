package org.api.data.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.api.data.ParSilabo;


/**
 *
 * @author DarkKlitos
 */
@Stateless
@Path("/silabo")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class SilaboFacadeREST extends AbstractFacade<ParSilabo> {
    @PersistenceContext(unitName = "ApisilaboPU") 
    private EntityManager em;

    public SilaboFacadeREST() {
        super(ParSilabo.class);
    }

    /**
     * Metodo que crea en la db un Silabo
     * @param entity 
     */
    @POST
    @Override
    public void create(ParSilabo entity) {
        super.create(entity);
    }

    /**
     * Metodo que modifica un Silabo en la db
     * @param id
     * @param entity 
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") int id, ParSilabo entity) {
        super.edit(entity);
    }

    /**
     * Metodo que elimina un Silabo de la db
     * @param id 
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        super.remove(super.find(id));
    }

    /**
     * Metodo que busca un Silabo por su id en la db
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    public ParSilabo find(@PathParam("id") int id) {
        return super.find(id);
    }

    /**
     * Metodo que retorna todos los Silabos de la db
     * @return 
     */
    @GET
    @Override
    public List<ParSilabo> findAll() {
        return super.findAll();
    }

    /**
     * Metodo que realiza la busqueda de uno o varios Silabos por sus atributos
     * @param parametro
     * @return 
     */
    @GET
    @Path("buscar/{parametro}")
    public List<ParSilabo> search(@PathParam("parametro") String param
    ) {
        // Returns a list of Silabos filterd by GET parameters.
        return em.createNamedQuery("ParSilabo.findByParams")
                 .setParameter("parametro", "%"+ param + "%").getResultList();
    }

    /**
     * Metodo que realizar la busqueda de varios Silabos indicandoles un limite superior e inferior
     * @param from
     * @param to
     * @return 
     */
    @GET
    @Path("{from}/{to}")
    public List<ParSilabo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
package org.api.data.service;

import java.util.List;
import javax.ejb.Stateless;
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
import org.api.data.ParMaterias;

/**
 *
 * @author DarkKlitos
 */
@Stateless
@Path("/materia")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class MateriaFacadeREST extends AbstractFacade<ParMaterias> {
    @PersistenceContext(unitName = "ApisilaboPU") 
    private EntityManager em;

    public MateriaFacadeREST() {
        super(ParMaterias.class);
    }

    /**
     * Metodo que crea en la db una Materia
     * @param entity 
     */
    @POST
    @Override
    public void create(ParMaterias entity) {
        super.create(entity);
    }

    /**
     * Metodo que modifica una Materia en la db
     * @param id
     * @param entity 
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") int id, ParMaterias entity) {
        super.edit(entity);
    }

    /**
     * Metodo que elimina una Materia de la db
     * @param id 
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        super.remove(super.find(id));
    }

    /**
     * Metodo que busca una Materia por su id en la db
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    public ParMaterias find(@PathParam("id") int id) {
        return super.find(id);
    }

    /**
     * Metodo que retorna todos las Materias de la db
     * @return 
     */
    @GET
    @Override
    public List<ParMaterias> findAll() {
        return super.findAll();
    }

    /**
     * Metodo que realiza la busqueda de uno o varias Materis por sus atributos
     * @param cedula
     * @param nombre
     * @param categoria
     * @return 
     */
    @GET
    @Path("buscar")
    public List<ParMaterias> search(
        @DefaultValue("") @QueryParam("cedula") String cedula,
        @DefaultValue("") @QueryParam("nombre") String nombre,
        @DefaultValue("") @QueryParam("categoria") String categoria
//        @DefaultValue("") @QueryParam("id") int id
    ) {
        // Returns a list of teacher filterd by GET parameters.
        return em.createNamedQuery("ParMaterias.findByParams")
            .setParameter("cedula", "%" + cedula + "%")
            .setParameter("nombre", "%" + nombre + "%")
            .setParameter("categoria", "%" + categoria + "%")
            // .setParameter("id", "%" + id + "%") 
            .getResultList();
    }

    /**
     * Metodo que realizar la busqueda de varias materias indicandoles un limite superior e inferior
     * @param from
     * @param to
     * @return 
     */
    @GET
    @Path("{from}/{to}")
    public List<ParMaterias> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
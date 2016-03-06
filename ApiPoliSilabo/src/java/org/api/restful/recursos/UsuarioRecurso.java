package org.api.restful.recursos;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.api.restful.modelo.Usuario;
import org.api.restful.servicio.UsuarioServicio;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRecurso {
    
    UsuarioServicio servicio = new UsuarioServicio();
  
     /**
     * Metodo que me muestra todos los Usuarios por medio de Rest en Json
     * puede realizar filtros sin enviar nada
     * @param user
     * @return 
     */
    @GET
    public List<Usuario> getArticulos(@QueryParam("user") String user){
        if (user != null &&  user.length()>0) {
            return  servicio.getUsuarioPorUsuario(user);
        }
        return servicio.getUsuarios();
    }
    
    /**
     * me muestra solamente un solo usuario por medio del id y 
     * como parametro en la url
     * @param id
     * @return 
     */
    @GET
    @Path("/{usuarioId}")
    public Usuario getArticulo(@PathParam("usuarioId") int id){
        return servicio.getUsuario(id);
    }
    
    /**
     * Metodo que crea un nuevo usuario en la lista de articulos
     * @param usuario
     * @return 
     */
    @POST
    public Usuario addUsuario(Usuario usuario){
        return servicio.addUsuario(usuario);
    }
    
    @DELETE
    @Path("/{usuarioId}")
    public void deleteUsuario(@PathParam("usuarioId") int id){
        servicio.deleteUsuario(id);
    }
    
    @PUT
    @Path("/{usuarioId}")
    public Usuario updateUsuario(@PathParam("usuarioId") int id, Usuario usuario){
      usuario.setId(id);
      return servicio.updateUsuario(usuario);
    }
}


package org.api.restful.dao;

import java.util.ArrayList;
import java.util.List;
import org.api.restful.modelo.Usuario;


public final class BaseDeDatos {
    private final static BaseDeDatos baseDeDatos = new BaseDeDatos();
    private final List<Usuario> listado = new ArrayList<>();
    
    /**
     * Constructor Simulador Base de Datos
     */
    private BaseDeDatos(){
      Usuario art1 = new Usuario(1, "cacharriss", "Carlos", "Charris", 4221000, "darkklitos@gmail.com", "4567");
      Usuario art2 = new Usuario(2, "mnishida", "Mauricio", "Nishida", 4321765, "mnishida@hotmail.com", "6789");
      Usuario art3 = new Usuario(3, "dmezapa", "Diego", "Meza", 4221023, "dmeza@gmail.com", "12345");
      listado.add(art1);
      listado.add(art2);
      listado.add(art3);
    }
    
    public static BaseDeDatos getInstacia(){
        return baseDeDatos;
    }
    
    /**
     * retorna la Lista de Articulos en la Base de Datos
     * @return 
     */
    public List<Usuario> getListado() {
    return listado;
        
    }
}

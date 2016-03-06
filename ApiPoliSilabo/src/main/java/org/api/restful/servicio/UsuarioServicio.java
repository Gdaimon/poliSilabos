package org.api.restful.servicio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.api.restful.dao.BaseDeDatos;
import org.api.restful.modelo.Usuario;

public class UsuarioServicio {

private final List<Usuario> listado = BaseDeDatos.getInstacia().getListado();

    /**
     * Metodo que me devuelve todos los Usuarios
     *
     * @return
     */
    public List<Usuario> getArticulos() {
        return listado;
    }

    /**
     * Metodo que me devuelve un solo usuario por medio del Id
     *
     * @param id
     * @return
     */
    public Usuario getArticulo(int id) {
        for (Usuario articulo : listado) {
            if (articulo.getId() == id) {
                return articulo;
            }
        }
        return null;
    }

    /**
     * Metodo que realiza busquedas en la lista por usuario
     *
     * @param usuario
     * @return
     */
    public List<Usuario> getArticuloPorAutor(String usuario) {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario articulo : listado) {
            if (articulo.getUsuario().equalsIgnoreCase(usuario)) {
                resultado.add(articulo);

            }

        }
        return resultado;
    }

    /**
     * Metodo que adiciona articulos a la Lista de usuario
     *
     * @param usuario
     * @return
     */
    public Usuario addArticulo(Usuario usuario) {
        usuario.setId(getMaximo());
        listado.add(usuario);
        return usuario;
    }

    /**
     * Metodo que actualiza un usuario
     *
     * @param usuario
     * @return
     */
    public Usuario updateArticulo(Usuario usuario) {
        int posicion = getPosicion(usuario.getId());

        try {
            listado.set(posicion, usuario);
        } catch (IndexOutOfBoundsException ioobe) {
            return null;
        }
        return usuario;
    }

    /**
     * Metodo que me retorna el Id maximo de la Lista de usuario
     *
     * @return
     */
    private int getMaximo() {
        int size = listado.size();
        if (size > 0) {
            return listado.get(size - 1).getId() + 1;

        } else {
            return 1;
        }
    }

    /**
     * Metodo que borra un usuario por medio del Id
     *
     * @param id
     */
    public void deleteArticulo(int id) {
        int posicion = getPosicion(id);
        listado.remove(posicion);
    }

    /**
     * Metodo que me confirma si el usuario esta en la Lista
     *
     * @param id
     * @return
     */
    private int getPosicion(int id) {
        for (int i = 0; i < listado.size(); i++) {
            if (listado.get(i).getId() == id) {
                return 1;
            }
        }
        return -1;
    }

    
}

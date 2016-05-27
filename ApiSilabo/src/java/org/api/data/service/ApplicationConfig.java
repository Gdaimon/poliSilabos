package org.api.data.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author DarkKlitos
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.api.data.service.CrossOriginResourceSharingFilter.class);
        resources.add(org.api.data.service.DepartamentoFacadeREST.class);
        resources.add(org.api.data.service.DocenteFacadeREST.class);
        resources.add(org.api.data.service.EjeFacadeREST.class);
        resources.add(org.api.data.service.FacultadFacadeREST.class);
        resources.add(org.api.data.service.MateriaFacadeREST.class);
        resources.add(org.api.data.service.SilaboFacadeREST.class);
        resources.add(org.api.data.service.UsuariosFacadeREST.class);
    }

}
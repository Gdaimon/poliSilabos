var Departamento = Backbone.Model.extend({
    initialize: function () {
        url: 'http://localhost:8080/ApiSilabo/api/departamento',
            console.info("Nuevo Departamento Creado");
    },
    defaults: {
        "id": "",
        //     "nombre_departamento": "",
        //     "nombreFacultad": "",
        //     "sedeFacultad": ""
    }
});
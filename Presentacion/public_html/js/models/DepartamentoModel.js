var Departamento = Backbone.Model.extend({
    initialize: function (i) {
        url: 'http://localhost:8080/ApiSilabo/api/departamento' + '/' + i,
            console.info("Nuevo Departamento Creado");
    },
    defaults: {
        "codigoDepartamento": "",
        "nombreDepartamento": "",
        "nombreFacultad": "",
        "sedeFacultad": ""
    }
});
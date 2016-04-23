var Materia = Backbone.Model.extend({
    initialize: function (i) {
        url: 'http://localhost:8080/ApiSilabo/api/materia' + '/' + i,
            console.info("Nueva Materia Creada");
    },
    defaults: {
        "nombreMateria": ""
    }
});
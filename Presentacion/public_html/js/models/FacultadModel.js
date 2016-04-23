var Facultad = Backbone.Model.extend({
    initialize: function (i) {
        url: 'http://localhost:8080/ApiSilabo/api/facultad',
            console.info("Nueva Facultad Creada");
    },
    defaults: {
        "nombreFacultad": "",
        "sedeFacultad": ""
    }
});
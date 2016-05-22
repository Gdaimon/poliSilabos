var Facultad = Backbone.Model.extend({
  urlRoot: 'http://localhost:8080/ApiSilabo/api/facultad',
  idAttribute: "id",
  initialize: function () {
    console.info("Nueva Facultad Creada");
  },
  defaults: {
    "id": '',
    "ciudadFacultad": '',
    "nombreFacultad": ''
  }
});
var facultad = new Facultad();

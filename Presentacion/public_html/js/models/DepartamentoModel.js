var Departamento = Backbone.Model.extend({
  urlRoot: 'http://localhost:8080/ApiSilabo/api/departamento',
  initialize: function () {
    console.info("Nuevo Departamento Creado");
  },
  defaults: {
//    "id": '',
    "idFacultad": '',
    "nombreDepartamento": "",
    "ciudadDepartamento": "" //,
//    "estadoDepartamento": '',
//    "fechaCreacion": ""
  }
});
var departamento = new Departamento();

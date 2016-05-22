var Departamento = Backbone.Model.extend({
  initialize: function () {
    url: 'http://localhost:8080/ApiSilabo/api/departamento',
    console.info("Nuevo Departamento Creado");
  },
  defaults: {
    "id": '',
    "idFacultad": '',
    "nombreDepartamento": "",
    "ciudadDepartamento": "",
    "estadoDepartamento": '',
    "fechaCreacion": ""
  }
});
var departamento = new Departamento();

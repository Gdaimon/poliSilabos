var Competencia = Backbone.Model.extend({
  urlRoot: 'http://localhost:8080/ApiSilabo/api/competencia',
  initialize: function () {
    console.info("Nueva Competencia Creada");
  },
  defaults: {
    "codCompetencia": '',
    "descripcion": ""
  }
});
var competencia = new Competencia();

var CompetenciaId = Backbone.Model.extend({
  idAttribute: "id",
    urlRoot: 'http://localhost:8080/ApiSilabo/api/competencia',
  initialize: function () {
    console.info("Nueva Competencia Creado");
  },
  defaults: {
    "id": '',
    "codCompetencia": '',
    "descripcion": ""
  }
});
var competenciaId = new CompetenciaId();

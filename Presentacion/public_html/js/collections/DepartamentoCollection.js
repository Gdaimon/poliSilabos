var DepartamentoCollection = Backbone.Collection.extend({
    url: 'http://localhost:8080/ApiSilabo/api/departamento',
    model: Departamento
});

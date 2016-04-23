var MateriaCollection = Backbone.Collection.extend({
    url: 'http://localhost:8080/ApiSilabo/api/materia',
    model: Materia
});

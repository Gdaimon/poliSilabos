var FacultadCollection = Backbone.Collection.extend({
    url: 'http://localhost:8080/ApiSilabo/api/facultad',
    model: Facultad
});

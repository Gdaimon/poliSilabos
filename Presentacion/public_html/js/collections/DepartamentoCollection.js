var DepartamentoCollection = Backbone.Collection.extend({
    // url: 'http://localhost:8080/ApiSilabo/api/departamento',
    url: 'http://localhost:8080/ApiSilabo/api/departamento',
    traerPagina: function (pagina, count, funcion) {
        this.url += '/' + pagina + '/' + count;
        Backbone.sync("read", this.model, {
            success: function (obj) {
                console.log('Cargo Ok ');
                funcion(obj);
            }, error: function () {
                console.log('Problemas no cargo');
            }
        })
    },
    model: Departamento
});
var departamentos = new DepartamentoCollection();
var DepartamentoListView = Backbone.View.extend({
        el: '#user-list',
        events: {'click .buscar': 'filtroNombre'},
        render: function () {
            var that = this;
            // var departamentos = new DepartamentoCollection();
facultades.fetch();
            departamentos.fetch({
                success: function (departamentos) {
                    var template = _.template($('#user-list-template').html(), {
                        facultades: facultades.models,
                        departamentos: departamentos.models
                    });
                    that.$el.html(template);
                    $('#listar-docente-table').DataTable();

                }
            });
        }
        ,
        filtroNombre: function () {
            $('#listar-docente-table').html('');
            var depto = $('.depto').val();
            if (depto != null) {

                filter = departamentos.filter(function (model) {
                    return model.get('nombreDepartamento').toUpperCase().indexOf(depto.toUpperCase()) != -1;
                });
                this.mostrarNombre(filter);
            }
        },
        mostrarNombre: function (filter) {
            filter.forEach(function (modelo, index, collection) {
                var deptos = new mostrarDepartamento({collection: collection});
                $('#listar-docente-table').append(deptos.render().$el);
            });
        }
    })
    ;

var departamentoListView = new DepartamentoListView();
departamentoListView.render();
var mostrarDepartamento = Backbone.View.extend({
    template: _.template($('#user-list-template').html()),
    render: function (dep) {
        var template = _.template($('#user-list-template').html(), {departamentos: dep.models});
        that.$el.html(template);
        $('#listar-docente-table').DataTable();
    }
})

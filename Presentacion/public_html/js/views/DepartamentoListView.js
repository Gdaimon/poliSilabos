var DepartamentoListView = Backbone.View.extend({
    el: '#user-list',
    render: function () {
        var that = this;
        var departamentos = new DepartamentoCollection();
        departamentos.fetch({
            success: function (departamentos) {
                var template = _.template($('#user-list-template').html(), {departamentos: departamentos.models});
                that.$el.html(template);
                $('#listar-docente-table').DataTable();

            }
        })
    }
});
var departamentoListView = new DepartamentoListView();
departamentoListView.render();
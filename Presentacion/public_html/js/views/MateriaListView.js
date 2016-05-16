    var MateriaListView = Backbone.View.extend({
      el: '#user-list',
      render: function () {
        var that = this;
        var materias = new MateriaCollection();
        materias.fetch({
          success: function (materias) {
            var template = _.template($('#user-list-template').html(), {materias: materias.models});
            that.$el.html(template);
             $('#listar-docente-table').DataTable();
          }
        })
      }
    });
    var materiaListView = new MateriaListView();
    materiaListView.render();
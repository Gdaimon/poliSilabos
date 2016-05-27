var CompetenciaListView = Backbone.View.extend({
  el: '#user-list',
  events: {
    'click .buscar': 'filtroNombre',
    //'change #list-fac': 'cambiarFactultad',
    'click #btn-guardar': 'guardar'
  },
  render: function () {
    var that = this;
    // var competencias = new CompetenciaCollection();
    competencias.fetch({
      success: function (competencias) {
        var template = _.template($('#user-list-template').html(), {
          competencias: competencias.models
        });
        that.$el.html(template);
        $('#listar-docente-table').DataTable();

      }
    });
  },
  filtroDescripcion: function () {
    $('#listar-docente-table').html('');
    var compe = $('.compe').val();
    if (compe != null) {

      filter = competencias.filter(function (model) {
        return model.get('descripcion').toUpperCase().indexOf(compe.toUpperCase()) != -1;
      });
      this.mostrarNombre(filter);
    }
  },

  guardar: function () {
    if (($("#inp-codCompe").val() === '')) {
      swal({
        title: "Registro Incompleto",
        text: "Por favor ingrese el código de la competencia",
        type: "warning",
        confirmButtonClass: "btn-warning",
        confirmButtonText: "Ok",
        closeOnConfirm: false
      });
    } else if (($("#inp-descripcion").val() === '')) {
      swal({
        title: "Registro Incompleto",
        text: "Por favor ingrese la Descripcion",
        type: "warning",
        confirmButtonClass: "btn-warning",
        confirmButtonText: "Ok",
        closeOnConfirm: false
      });
    } else {
      competencia.set({
        "codCompetencia": $("#inp-codCompe").val(),
        "descripcion": $("#inp-descipcion").val() {
          "id": parseInt($("#list-fac option:selected").val())
        }
      });
      console.log(competencia.toJSON());
      competencia.save();
    }

  },
  mostrarNombre: function (filter) {
    filter.forEach(function (modelo, index, collection) {
      var compcias = new mostrarCompetencia({
        collection: collection
      });
      $('#listar-docente-table').append(compcias.render().$el);
    });
  }
});

var competenciaListView = new CompetenciaListView();
competenciaoListView.render();
var mostrarCompetencia = Backbone.View.extend({
  template: _.template($('#user-list-template').html()),
  render: function (compe) {
    var template = _.template($('#user-list-template').html(), {
      competencias: compe.models
    });
    that.$el.html(template);
    $('#listar-docente-table').DataTable();
  }
});


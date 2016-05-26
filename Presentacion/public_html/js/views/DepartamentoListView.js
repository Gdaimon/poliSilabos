var DepartamentoListView = Backbone.View.extend({
  el: '#user-list',
  events: {
    'click .buscar': 'filtroNombre',
    'change #list-fac': 'cambiarFactultad',
    'click #btn-guardar': 'guardar'
  },
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
  },
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
  cambiarFactultad: function () {
    var indice = parseInt($("#list-fac option:selected").val());
    facultad.set({
      'id': indice
    });
    facultad.fetch();
    console.log(facultad.get('ciudadFacultad'));
    departamento.set({
      "idFacultad": {
        "id": indice
      }
    });
    console.log(departamento.toJSON());
    //    return this.facult;
  },
  guardar: function () {
    if (($("#inp-depto").val() === '')) {
      swal({
        title: "Registro Incompleto",
        text: "Por favor ingrese el Departamento",
        type: "warning",
        confirmButtonClass: "btn-warning",
        confirmButtonText: "Ok",
        closeOnConfirm: false
      });
    } else if (($("#inp-ciudad").val() === '')) {
      swal({
        title: "Registro Incompleto",
        text: "Por favor ingrese la Ciudad",
        type: "warning",
        confirmButtonClass: "btn-warning",
        confirmButtonText: "Ok",
        closeOnConfirm: false
      });
    } else {
      departamento.set({
        "nombreDepartamento": $("#inp-depto").val(),
        "ciudadDepartamento": $("#inp-ciudad").val(),
        "idFacultad": {
          "id": parseInt($("#list-fac option:selected").val())
        }
      });
      console.log(departamento.toJSON());
      departamento.save();
    }

  },
  mostrarNombre: function (filter) {
    filter.forEach(function (modelo, index, collection) {
      var deptos = new mostrarDepartamento({
        collection: collection
      });
      $('#listar-docente-table').append(deptos.render().$el);
    });
  }
});

var departamentoListView = new DepartamentoListView();
departamentoListView.render();
var mostrarDepartamento = Backbone.View.extend({
  template: _.template($('#user-list-template').html()),
  render: function (dep) {
    var template = _.template($('#user-list-template').html(), {
      departamentos: dep.models
    });
    that.$el.html(template);
    $('#listar-docente-table').DataTable();
  }
});


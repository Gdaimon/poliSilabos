var Usuario = Backbone.Model.extend({
initialize: function(i){
	url: 'http://localhost:8080/ApiSilabo/api/docente'+'/'+i,
         console.info("Nuevo Usuario Creado");
      },
      defaults:{
         nombre: "",
         cedula: 0,
         categoria:""
      }
});
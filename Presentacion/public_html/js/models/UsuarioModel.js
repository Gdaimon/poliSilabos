var Usuario = Backbone.Model.extend({
initialize: function(i){
	url: 'http://localhost:8080/ApiSilabo/api/usuario'+'/'+i,
         console.info("Nuevo Usuario Creado");
      },
      defaults:{
         nombre: "",
         apellido:"",
         email:""
      }
});
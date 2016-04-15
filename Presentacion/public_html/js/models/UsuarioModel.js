var Usuario = Backbone.Model.extend({
initialize: function(){
         console.info("Nuevo Usuario Creado");
      },
      defaults:{
         nombre: "",
         cedula: 0,
         categoria:""
      }
});
var Usuario = Backbone.Model.extend({
initialize: function(){
         console.info("Nuevo modelo de: DesarrolladorModel");
      },
      defaults:{
         nombre: "",
         cedula: 0,
         categoria:""
      }
});
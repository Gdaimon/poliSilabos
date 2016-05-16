// Filename: app.js
define([
    'jquery',
    'underscore',
    'backbone',
    'bootstrap',
    'modules/materia/router' // Request router.js
], function ($, _, Backbone, bootstrap, Router) {
    var initialize = function () {
        // Pass in our Router module and call it's initialize function
        Router.initialize();
    };

    return {
        initialize: initialize
    };
});

// Author: Thomas Davis <thomasalwyndavis@gmail.com>
// Filename: main.js

// Require.js allows us to configure shortcut alias
// Their usage will become more apparent futher along in the tutorial.
require.config({
    baseUrl: "js",
    shim: {
        'bootstrap': {'deps': ['jquery']}
    },
    paths: {
        bootstrap: '../../libs/bootstrap/bootstrap.min',
        jquery: '../../libs/jquery/jquery-min',
        underscore: '../../libs/underscore/underscore-min',
        backbone: '../../libs/backbone/backbone-min'
        // templates: '../templates'
    }

});

require([
    // Load our app module and pass it to our definition function
    // 'modules/docente/app'
    'modules/departamento/app'

], function (App) {
    // The "app" dependency is passed in as "App"
    // Again, the other dependencies passed in are not "AMD" therefore don't pass a parameter to this function
    App.initialize();
});

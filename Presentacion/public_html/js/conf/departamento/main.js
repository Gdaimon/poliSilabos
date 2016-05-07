require.config({
    baseUrl: 'js',
    paths: {
        jquery: '../../libs/jquery/jquery-2.1.3.min',
        underscore: '../../libs/underscore/underscore-min',
        backbone: '../../libs/backbone/backbone-min'
    },
    shim: {
        underscore: {
            exports: '_'
        },
        backbone: {
            deps: ['jquery', 'underscore'],
            exports: 'Backbone'
        },
        jquery: {
            exports: '$'
        }
    }
});

require(['app'], function (App) {
    App.initialize();
});
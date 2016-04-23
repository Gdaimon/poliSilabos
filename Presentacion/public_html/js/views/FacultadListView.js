var FacultadListView = Backbone.View.extend({
    el: '#user-list',
    render: function () {
        var that = this;
        var facultades = new FacultadCollection();
        facultades.fetch({
            success: function (facultades) {
                var template = _.template($('#user-list-template').html(), {facultades: facultades.models});
                that.$el.html(template);
            }
        })
    }
});
var facultadListView = new FacultadListView();
facultadListView.render();
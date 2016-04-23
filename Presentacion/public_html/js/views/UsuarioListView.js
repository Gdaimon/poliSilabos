var UserListView = Backbone.View.extend({
    el: '#user-list',
    render: function () {
        var that = this;
        var users = new UsuariosCollection();
        users.fetch({
            success: function (users) {
                var template = _.template($('#user-list-template').html(), {users: users.models});
                that.$el.html(template);
            }
        })
    }
});
var userListView = new UserListView();
userListView.render();
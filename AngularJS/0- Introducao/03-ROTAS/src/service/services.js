angular.module('services', ['ngResource'])
.factory('FuncioarioService', function ($resource) {

    return $resource('/funcionarios/:id');

});
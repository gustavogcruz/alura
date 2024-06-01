angular.module('services', ['ngResource'])
    .factory('FuncionarioService', function($resource) {
        return $resource('/funcionarios/:id');
    }
);
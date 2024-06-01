var app = angular.module('Funcionarios',['ngRoute', 'ngResource']);

app.config(function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl: 'partials/bem-vindo.tpl.html'
	});

	$routeProvider.when('/funcionarios', {
		templateUrl: 'partials/funcionarios.tpl.html', 
		controller: 'FuncionariosController'
	});

	$routeProvider.otherwise({redirectTo: '/'});
	
});
app.controller('FuncionariosController', function($scope, $resource) {

	$scope.funcionarios = [];

	var resource = $resource('/funcionarios/:id');

	function listaFuncionarios() {
		resource.query(function(retorno) {
			$scope.funcionarios = retorno;
			$scope.mostra = true;
		});
	}

	listaFuncionarios();

	$scope.remove = function(funcionario) {
		resource.delete({id: funcionario.id}, function(status) {
			listaFuncionarios();
		});
	};
});
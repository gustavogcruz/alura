app.controller('FuncionariosController', function($scope, FuncionarioService) {

	$scope.funcionarios = [];

	function listaFuncionarios() {
		FuncionarioService.query(function(retorno) {
			$scope.funcionarios = retorno;
			$scope.mostra = true;
		});
	}

	listaFuncionarios();

	$scope.remove = function(funcionario) {
		FuncionarioService.delete({id: funcionario.id}, function(status) {
			listaFuncionarios();
		});
	};
});
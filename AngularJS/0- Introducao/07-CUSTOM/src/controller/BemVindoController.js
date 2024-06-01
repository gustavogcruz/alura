app.controller('BemVindoController', function($scope, FuncionarioService) {
    $scope.funcionarios = [];
    
    FuncionarioService.query(function(retorno) {
       $scope.funcionarios = retorno;
       $scope.mostra = true;
    });
});
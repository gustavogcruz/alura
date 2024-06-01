app.controller('BemVindoController', function ($scope, FuncioarioService) {

    $scope.funcionarios = [];

    function listaFuncionarios() {
        FuncioarioService.query(function (retorno) {
            $scope.funcionarios = retorno;
        });
    }

    listaFuncionarios();

});
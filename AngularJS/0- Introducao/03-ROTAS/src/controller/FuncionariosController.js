app.controller('FuncionariosController', function ($scope, $http, FuncioarioService) {

    $scope.funcionarios = [];

    function listaFuncionarios() {
        FuncioarioService.query(function (retorno) {
            $scope.funcionarios = retorno;
            $scope.mostra = true;
        });
    }

    listaFuncionarios();

    $scope.remove = function (funcionario) {
        FuncioarioService.delete({ id: funcionario.id }, function (status) {
            listaFuncionarios();
        });
    }

    // $scope.funcionarios = [];
    // $scope.mostra = true;

    // $http.get('/funcionarios').success(function(retorno) {

    //     $scope.funcionarios = retorno

    // }).error(function(msg){

    //     $scope.mensagem = "Houve um problerma ao acessar o serviço. Tente novamente mais tarde!"
    //     console.log(msg);
    // });

    // $http.delete('/funcionarios/1').success(function(retorno) {
    //    console.log(retorno)
    // });

});
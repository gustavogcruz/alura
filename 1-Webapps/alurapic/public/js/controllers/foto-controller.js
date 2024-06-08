angular.module('alurapic').controller('FotoController', function ($scope, $http, $routeParams, recursoFoto, cadastroFoto) {

    $scope.foto = {};
    $scope.mensagem = '';

    if ($routeParams.fotoId) {

        recursoFoto.get({fotoId : $routeParams.fotoId}, function(foto) {
            $scope.foto = foto;
        }, function (erro) {
            console.log(erro);
            $scope.mensagem = 'Não foi possível obter a foto';
        });
            // .success(function (foto) {
            //     $scope.foto = foto;
            // })
            // .error(function (erro) {

            // });
    }

    $scope.submeter = function () {
        if ($scope.formulario.$valid) {

            cadastroFoto.cadastrar($scope.foto)
            .then(function(dados){
                $scope.mensagem = dados.mensagem;
                if(dados.inclusao) $scope.foto = {};
                //$scope.focado = true;
            })
            .catch(function(dados) {
                $scope.mensagem = dados.mensagem;                
            })    
        }
    };
});
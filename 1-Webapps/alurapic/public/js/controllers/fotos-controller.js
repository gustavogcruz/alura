angular.module('alurapic').controller('FotosController', function ($scope, recursoFoto) {

    $scope.fotos = [];
    $scope.filtro = '';
    $scope.mensagem = '';

    recursoFoto.query(function (fotos) {
        $scope.fotos = fotos;
    }, function (erro) {
        console.log(erro);
    });

    // $http.get('v1/fotos')
    //     .success(function (fotos) {
    //         $scope.fotos = fotos;
    //     })
    //     .error(function (erro) {
    //         console.log(erro);
    //     });

    $scope.remover = function (foto) {

        recursoFoto.delete({ fotoId: foto._id }, function () {
            var indiceFoto = $scope.fotos.indexOf(foto);
            $scope.fotos.splice(indiceFoto, 1);
            $scope.mensagem = 'Foto ' + foto.titulo + ' foi removida com sucesso';

        }, function (erro) {
            console.log(erro);
            $scope.mensagem = 'Não foi possível remover a foto ' + foto.titulo;
        });

        // $http.delete('v1/fotos/' + foto._id)
        //     .success(function () {
        //     })
        //     .error(function (erro) {
        //     });
    };
});

//     [
//     {
//         titulo: 'Aleatório 1',
//         url: 'https://source.unsplash.com/random/200x200'
//     },

//     {
//         titulo: 'Aleatório 2',
//         url: 'https://source.unsplash.com/random/200x200'
//     }
//     ]

// var promise = $http.get('v1/fotos');
// promise.then(function (retorno) {
//     $scope.fotos = retorno.data;
// }).catch(function (error) {
//     console.log(error);
// });
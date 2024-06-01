angular.module('minhasDiretivas', ['meusServicos'])
    .directive('meuPainel', function () {

        var ddo = {};
        //direct definition object
        ddo.restrict = "AE";
        ddo.scope = {
            titulo: '@'
        };
        ddo.transclude=true;
        ddo.templateUrl='js/directives/meu-painel.html';

        return ddo;
    })
    .directive('minhaFoto', function() {

        var ddo = {};

        ddo.restrict = "AE";

        ddo.scope = {
            titulo: '@',
            url: '@'
        };

        ddo.template = '<img class="img-responsive center-block" ng-src="{{url}}" alt="{{titulo}}">';           

        return ddo;
    })
    .directive('meuBotaoPerigo', function() {

        var ddo = {}
        ddo.restrict = 'E';

        ddo.scope = {

            nome: '@', //cópia valor sempre string
            acao: '&' //expressão avalida no contexto do controller

        };

        ddo.template = ' <button ng-click="acao(foto)" class="btn btn-danger btn-block">{{nome}}</button>';

        return ddo;
    })
    .directive('meuFocus', function(){

        var ddo = {};
        ddo.restrict = "A";
        // ddo.scope = {
        //     focado : '=' //qualquer alteração é bidirecionada a controller / diretiva e vice-versa
        // };

        ddo.link = function(scope, element) {
                scope.$on('fotoCadastrada', function() {
                 element[0].focus();
                })

            // scope.$watch('focado',function(){
            //     if(scope.focado) {
            //         element[0].focus(); 
            //         scope.focado = false;
            //     }                  
            // });
        }

        return ddo;
    })    .directive('meusTitulos', function() {
        var ddo = {};
        ddo.restrict = 'E';
        ddo.template = '<ul><li ng-repeat="titulo in titulos">{{titulo}}</li></ul>';
        ddo.controller = function($scope, recursoFoto) {
            recursoFoto.query(function(fotos) {
                $scope.titulos = fotos.map(function(foto) {
                    return foto.titulo;
                });    
            });
        };
        return ddo;
    });




//js/HelloController.js

function HelloController($scope) {
    $scope.total = 0;
    $scope.incrementar = function() {
        $scope.total++; 
      };
}
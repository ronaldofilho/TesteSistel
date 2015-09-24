var module = angular.module('sistel');

//TODO remover esta factory pra outro arquivo
module.factory('Estados', function($resource){
    return $resource('/sistel/estados/:id', {id:'@id'}, {
        'update': {method:'PUT'},
        'search': {method:'PUT'}
    });

})
.controller('EstadosController', function($scope, Estados, $routeParams, $location) {
    $scope.estados = Estados.query();

    $scope.estado = new Estados();

    var idToEdit = $routeParams.id;

    function init(){
        if(idToEdit)
            $scope.edit(idToEdit);
    }

    $scope.save = function() {
    	Estados.save($scope.estado, function (estadosResult) {
            $scope.estados.push(estadosResult);
            $scope.goToListEstados();
        }, function(result){
            console.log(result);
            alert(result.data.message);
        });
    };

    $scope.delete = function(estado) {
    	Estados.delete(estado, function (result) {
            if(result.$resolved)
                $scope.estados.splice($scope.estados.indexOf(estado), 1);
        });
    };

    $scope.edit = function(idToEdit) {
        if(!isInt(idToEdit)){
            alert(idToEdit + ' is not a valid int!'); //centralizar as validacoes
            $scope.goToListEstados();
        }else if($location.path()=='/sistel/estados'){
            $scope.safeApply($location.path('/sistel/estados/edit='+idToEdit));
        }else{
        	Estados.get({id:idToEdit}).$promise.then(function(result){
                if(result.id){
                    $scope.estado = result;
                }else{
                    alert('Estado with id ' + idToEdit + ' not found!');
                    $scope.goToListEstados();
                }
            });
        };
    };

    //criar arquivo utils.js
    function isInt(value) {
        var x;
        return isNaN(value) ? !1 : (x = parseFloat(value), (0 | x) === x);
    }

    $scope.update = function() {
    	Estados.update($scope.estado, function (estadosResult) {
            $scope.goToListEstados();
        }, function(result){
            console.log(result);
            alert(result.data.message);
        }
    )};

    $scope.goToListEstados = function() {
        $scope.safeApply($location.path('/estados'));
    };

    $scope.safeApply = function(fn) {
      var phase = this.$root.$$phase;
      if(phase == '$apply' || phase == '$digest') {
        if(fn && (typeof(fn) === 'function')) {
          fn();
        }
      } else {
        this.$apply(fn);
      }
    };

    init();
});

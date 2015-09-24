var module = angular.module('sistel');

//TODO remover esta factory pra outro arquivo
module.factory('CadClientes', function($resource){
    return $resource('/sistel/clientes/:id', {id:'@id'}, {
        'update': {method:'PUT'},
        'search': {method:'PUT'}
    });

})
.controller('CadClientesController', function($scope, CadClientes, $routeParams, $location) {
    $scope.cadClientes = CadClientes.query();

    $scope.cadCliente = new CadClientes();

    var idToEdit = $routeParams.id;

    function init(){
        if(idToEdit)
            $scope.edit(idToEdit);
    }

    $scope.save = function() {
        PhoneCall.save($scope.cadCliente, function (cadClienteResult) {
            $scope.cadClientes.push(cadClienteResult);
            $scope.goToListPhoneCalls();
        }, function(result){
            console.log(result);
            alert(result.data.message);
        });
    };

    $scope.delete = function(cadCliente) {
    	CadClientes.delete(cadCliente, function (result) {
            if(result.$resolved)
                $scope.cadClientes.splice($scope.cadClientes.indexOf(cadCliente), 1);
        });
    };

    $scope.edit = function(idToEdit) {
        if(!isInt(idToEdit)){
            alert(idToEdit + ' is not a valid int!'); //centralizar as validacoes
            $scope.goToListPhoneCalls();
        }else if($location.path()=='/sistel/clientes'){
            $scope.safeApply($location.path('/sistel/clientes/edit='+idToEdit));
        }else{
        	CadClientes.get({id:idToEdit}).$promise.then(function(result){
                if(result.id){
                    $scope.cadCliente = result;
                }else{
                    alert('PhoneCall with id ' + idToEdit + ' not found!');
                    $scope.goToListPhoneCalls();
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
    	CadClientes.update($scope.cadCliente, function (cadClienteResult) {
            $scope.goToListPhoneCalls();
        }, function(result){
            console.log(result);
            alert(result.data.message);
        }
    )};

    $scope.goToListPhoneCalls = function() {
        $scope.safeApply($location.path('/sistel/clientes'));
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

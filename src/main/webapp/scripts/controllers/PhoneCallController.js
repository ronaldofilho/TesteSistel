var module = angular.module('sistel');

//TODO remover esta factory pra outro arquivo
module.factory('PhoneCall', function($resource){
    return $resource('/sistel/phoneCall/:id', {id:'@id'}, {
        'update': {method:'PUT'},
        'search': {method:'PUT'}
    });

})
.controller('PhoneCallController', function($scope, PhoneCall, $routeParams, $location) {
    $scope.phoneCalls = PhoneCall.query();

    $scope.phoneCall = new PhoneCall();

    var idToEdit = $routeParams.id;

    function init(){
        if(idToEdit)
            $scope.edit(idToEdit);
    }

    $scope.save = function() {
        PhoneCall.save($scope.phoneCall, function (phoneCallResult) {
            $scope.phoneCalls.push(phoneCallResult);
            $scope.goToListPhoneCalls();
        }, function(result){
            console.log(result);
            alert(result.data.message);
        });
    };

    $scope.delete = function(phoneCall) {
        PhoneCall.delete(phoneCall, function (result) {
            if(result.$resolved)
                $scope.phoneCalls.splice($scope.phoneCalls.indexOf(phoneCall), 1);
        });
    };

    $scope.edit = function(idToEdit) {
        if(!isInt(idToEdit)){
            alert(idToEdit + ' is not a valid int!'); //centralizar as validacoes
            $scope.goToListPhoneCalls();
        }else if($location.path()=='/sistel/phoneCall'){
            $scope.safeApply($location.path('/sistel/phoneCall/edit='+idToEdit));
        }else{
            PhoneCall.get({id:idToEdit}).$promise.then(function(result){
                if(result.id){
                    $scope.phoneCall = result;
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
        PhoneCall.update($scope.phoneCall, function (phoneCallResult) {
            $scope.goToListPhoneCalls();
        }, function(result){
            console.log(result);
            alert(result.data.message);
        }
    )};

    $scope.goToListPhoneCalls = function() {
        $scope.safeApply($location.path('/phoneCall'));
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

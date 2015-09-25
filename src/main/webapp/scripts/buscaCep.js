var consu = angular.module('sistel');

consu.factory('consuCep',function($resource){
	return $resource('http://cep.republicavirtual.com.br/web_cep.php?formato=xml&cep=:cep',{cep:'@cep'},{
	'buscar':{method:'GET'}
	});
})
.controller('buscaCep',function($scope, consuCep, $routeParams, $location){
	$scope.buscarCep = function(cepConsutado){
		if (cepConsutado){
			consuCep.buscar(cepConsutado, function(cepResult){
				$scope.endeCon = cepResult;
				$scope.console.log(cepResult);
			});
		}
			
	}
});



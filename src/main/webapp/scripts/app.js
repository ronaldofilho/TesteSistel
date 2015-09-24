'use strict';

/**
 * @ngdoc overview
 * @name webappApp
 * @description
 * # webappApp
 *
 * Main module of the application.
 */
angular
  .module('sistel', [    
    'ngResource',
    'ngRoute',
    'ngTouch',
  ])
  .config(function ($routeProvider) {    
    $routeProvider
      .when('/', {
        templateUrl: 'ui/dashboard.html',
         //controller: 'DashboardControllersistel.js'
      })
      
      .when('/phoneCall', {
        templateUrl: 'ui/phoneCall/phoneCall.html',
        controller: 'PhoneCallController'
      })
      
      .when('/phoneCall/edit=:id', {
        templateUrl: 'ui/phoneCall/editPhoneCall.html',
        controller: 'PhoneCallController'
      })
      
      .when('/phoneCall/insert', {
        templateUrl: 'ui/phoneCall/insertPhoneCall.html',
        controller: 'PhoneCallController'
      })
      
      //rotas cliente
      .when('/clientes', {
          templateUrl: 'ui/cadastros/clientes/cliente.html',
          controller: 'CadClientesController'
	  })
	  
	  .when('/clientes/edit=:id', {
	      templateUrl: 'ui/cadastros/clientes/editCliente.html',
	      controller: 'CadClientesController'
	  })
	  
	  .when('/clientes/insert', {
	      templateUrl: 'ui/cadastros/clientes/insertCliente.html',
	      controller: 'CadClientesController'
	  })
	  
	  //rotas estado
      .when('/estados', {
          templateUrl: 'ui/cadastros/estados/estado.html',
          controller: 'EstadosController'
	  })
	  
	  .when('/estados/edit=:id', {
	      templateUrl: 'ui/cadastros/estados/editEstado.html',
	      controller: 'EstadosController'
	  })
	  
	  .when('/estados/insert', {
	      templateUrl: 'ui/cadastros/estados/insertEstado.html',
	      controller: 'EstadosController'
	  })
	  
      .otherwise({
        redirectTo: '/'
      });
  });

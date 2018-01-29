//Modulo Principal
var appAgenda = angular.module("appAgenda", ['ngRoute', '720kb.datepicker']);

//Controllers

appAgenda.config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
       
      $routeProvider.
        when('/home', {
          templateUrl: 'pages/home.html',
          controller: 'agendaMedicaCrtl'
        }).
        when('/medicos', {
          templateUrl: 'pages/medicos.html',
          controller: 'appAgendaMedicos'
        }).
        when('/consultas', {
            templateUrl: 'pages/consultas.html',
            controller: 'appAgendaConsultas'
        }).
        when('/consultorios', {
            templateUrl: 'pages/consultorios.html',
            controller: 'appAgendaConsultorios'
        }).
        otherwise({redirectTo:'pages/home.html'});
      
		$locationProvider.hashPrefix('!');
		$locationProvider.html5Mode(true);
	}
]);



//controller ver consultas
appAgenda.controller("appAgendaConsultar", function($scope,$http){
	$scope.listaConsultas = function(){
		$scope.app = "Lista de Consultas"
		$scope.medicos =[];
		$http(
				{
					method:"GET",
					url:"http://localhost:8080/medicos"
				}).then(function successCallBack(response){
					$scope.medicos = response.data;
					console.log(response.data);
					console.log(response.status);
				}, function errorCallBack(response){
					console.log(response.data);
					console.log(response.status);
		});
	};
});
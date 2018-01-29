//controller tela consultorios
appAgenda.controller("appAgendaConsultorios", function($scope, $http){
			
	//Exibe pagina de cadastro de consultorios
			$scope.app = "Cadastro de Consultorio"
			$scope.consultorio = {};
		
			$scope.cadastrarConsultorio = function(consultorio){
			$scope.consultorios = [];
			$scope.consultorios.push(angular.copy(consultorio));
			$scope.consultorio = consultorio;
			$http(
					{
						method:"POST",
						url:'http://localhost:8080/consultorios',
						data:$scope.consultorio
					}).then(function successCallBack(response){
						$scope.aux = "do consultorio foi realizado com sucesso.";
						$scope.consultorio = response.data;
						console.log(response.data);
						console.log(response.status);
						$scope.msg ="O cadastro " + $scope.aux;
						window.alert($scope.msg);
						$scope.consultorio= {};
					}, function errorCallBack(response){
						delete $scope.consultorio;
						console.log(response.data);
						console.log(response.status);
					});
			};
	
});

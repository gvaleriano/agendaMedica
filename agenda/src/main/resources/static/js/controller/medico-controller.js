//controller cadastro de medicos
appAgenda.controller("appAgendaMedicos", function($scope, $http){
	
	//Exibir pagina de cadastro de medicos
		$scope.app = "Cadastro de Medicos"
		$scope.cadastrarMedico = function(medico){
			$scope.medico = {};
			$scope.medicos = [];
			$scope.medicos.push(angular.copy(medico));
			$scope.medico = medico;
			$http(
					{
						method:'POST',
						url:'http://localhost:8080/medicos',
						data:$scope.medico
					}).then(function successCallBack(response){
						$scope.aux = "do medico foi realizado com sucesso.";
						$scope.medicos = response.data;
						console.log(response.data);
						console.log(response.status);
						$scope.msg ="O cadastro " + $scope.aux;
						window.alert($scope.msg);
						$scope.medico = {};
					}, function errorCallBack(response){
						delete $scope.medico;
						console.log(response.data);
						console.log(response.status);
					});
			};
	});
	
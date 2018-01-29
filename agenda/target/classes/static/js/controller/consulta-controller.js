//controller cadastro de consultas
appAgenda.controller("appAgendaConsultas", function($rootScope, $scope,$http){
	
	//Exibir pagina de cadastro de consultas
		$scope.app = "Cadastro de Consultas"
		$scope.consulta = {};
		$scope.consultorios = [];
		$scope.exibeHorarios = false;
		$scope.init = function(){
			$http(
					{
						method:"GET",
						url:"http://localhost:8080/consultorios"
					}).then(function successCallBack(response){
						$scope.consultorios = response.data;
						console.log(response.data);
					}, function errorCallBack(response){
						console.log(response.data);
						console.log(response.status);
					});
		};
		
		// Função para escolha do medico
		$scope.select = function(medico,el,old){
			$scope.aux = medico.id;
			var display = document.getElementById(el).style.display;
			
			$http(
					{
						method:"GET",
						url:"http://localhost:8080/medicos/"+$scope.aux+"_select"
					}).then(function successCallBack(response){
						$scope.medicos = response.data;
						if(display == "none"){
				            document.getElementById(el).style.display = 'block';
				            document.getElementById(old).style.display = 'none';
						}
					}, function errorCallBack(response){
						console.log(response.data);
						console.log(response.status);
					});
		};
		
		//fim função
		
		//função para cadastro de consultas
		$scope.cadastrarConsultas = function(consulta,id,el){
			$scope.aux = document.getElementById(id).value;
			$scope.consultas = [];
			$scope.consultas.push(angular.copy(consulta));
			$scope.consulta = consulta;
			$scope.consulta.idMed = $scope.aux;
			$http(
					{
						method:"POST",
						url:'http://localhost:8080/consultas',
						data:$scope.consulta
					}).then(function successCallBack(response){
						$scope.aux = "da consulta foi realizada com sucesso.";
						$scope.consulta = response.data;
						console.log(response.data);
						console.log(response.status);
						$scope.msg ="O cadastro " + $scope.aux;
						window.alert($scope.msg);
						$scope.consulta ={};
						document.getElementById(el).style.display = 'none';
					}, function errorCallBack(response){
						delete $scope.consulta;
						console.log(response.data);
						console.log(response.status);
					});
			};
		//fim função
			
			//Função de listagem de medicos disponiveis
			$scope.listaMedicos = function(el,param, old){
				$scope.init();
				$scope.param = param;
				var display = document.getElementById(el).style.display;
				if(display == "none"){
		            document.getElementById(el).style.display = 'block';
		            document.getElementById(old).style.display = 'none';
				}
					$http(
							{
								method:"GET",
								url:"http://localhost:8080/medicos/"+$scope.param
							}).then(function successCallBack(response){
								$scope.medicos = response.data;
								console.log(response.data);
								console.log(response.status);
								console.log($scope.consulta.especConsulta);
								console.log($scope.consulta);
							}, function errorCallBack(response){
								console.log(response.data);
								console.log(response.status);
							});
			};
			//fim função
			
			//função para habilitar horarios
			$scope.change = function(el,hr){
				if(document.getElementById(el).value !=""){
					document.getElementById(hr).disabled = false;
					
				}
			};
});

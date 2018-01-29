//controller tela inicial
appAgenda.controller("agendaMedicaCrtl", function($scope, $http){
	
	//Function para exibir tela inicial
	$scope.telaInicial = function(){
		$scope.app = "Agenda Medica";
		$scope.listaConsultas = false;
	}
	// Chamada tela inicial
	$scope.telaInicial();
	
	$scope.exibeConsulta = function(event){
		
		//TODO a um bug onde o exibir todas as consultas nao funciona apos usar o filtro
		
		//resetar radios caso possa filtrar pelas duas opções mudar para check
		var ele = document.getElementsByName("selectFilter");
		   for(var i=0;i<ele.length;i++)
		      ele[i].checked = false;
		
		//resetar dados de filtro
		document.getElementById('btnFiltro').disabled = true;
		document.getElementById('filterData').disabled = true;
		document.getElementById('filterData').value = "";
		document.getElementById('filterMedico').disabled = true;
		document.getElementById('filterMedico').value = "";
		
		$scope.consultas = [];
		if(event.target.checked){
			$http(
					{
						method:"GET",
						url:"http://localhost:8080/consultas/"+"_all"
					}).then(function successCallBack(response){
						$scope.consulta = response.data;
						$scope.consultas.push(angular.copy($scope.consulta));
						console.log(response.data);
						console.log(response.status);
					}, function errorCallBack(response){
						console.log(response.data);
						console.log(response.status);
			});	
			
		}else{
			$scope.listaConsultas = false;
		}
	};
	
	//função de filtros
	$scope.filterBy= function(el,param,id){
		if(document.getElementById(el).checked && id=='filterData'){
			document.getElementById(id).disabled = false;
			document.getElementById('btnFiltro').disabled = false;
			document.getElementById('filterMedico').disabled = true;
			document.getElementById('filterMedico').value = "";
		}
		
		if(document.getElementById(el).checked && id=='filterMedico'){
			document.getElementById(id).disabled = false;
			document.getElementById('btnFiltro').disabled = false;
			document.getElementById('filterData').disabled = true;
			document.getElementById('filterData').value = "";
			
		}
	};
	
	$scope.exibeFiltrado= function(consulta){
		$scope.consultas = [];
		$scope.consulta = {};
		if(document.getElementById('date').checked){
			var data="";
			$scope.param = consulta.paramData;
			data = $scope.param.replace("/","-");
			data = data.replace("/","-");
			$scope.param = "_date"+ data;
		}else if(document.getElementById('medico').checked){
			$scope.param = consulta.paramMed;
			$scope.param = "_medico" + $scope.param;
		}else{
			$scope.param = "_all";
		}
		
			$http(
					{
						method:"GET",
						url:"http://localhost:8080/consultas/"+$scope.param
					}).then(function successCallBack(response){
						$scope.consulta = response.data;
						$scope.consultas.push(angular.copy($scope.consulta));
						console.log(response.data);
						console.log(response.status);
					}, function errorCallBack(response){
						console.log(response.data);
						console.log(response.status);
					});
	};
});

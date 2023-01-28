angular.module("myApp", [])
.service("elencoCitta", function(){
	this.elenco = [
		{nome: "Napoli", regione: "Campania"},
		{nome: "Roma", regione: "Lazio"}];
	this.aggiungi = function(citta){
		this.elenco.push(citta);
	};
})
.controller("principleController",
	function($scope){
		$scope.exercise = [{nome: "Esercizio delle forms"}, {nome: "Esercizio della calcolatrice"}, {nome: "Esercizio service e factory"}, {nome: "HTTPGET"}];
		$scope.caricaPage = function(esercizio) {
			if(esercizio != undefined && esercizio.includes("0")){
				return "forms.html";
			}else if(esercizio != undefined && esercizio.includes("1")){
				return "calc.html";
			}else if(esercizio != undefined && esercizio.includes("2")){
				return "servFact.html";
			}else if(esercizio != undefined && esercizio.includes("3")){
				return "httpGet.html";
			}
		};

	})
.controller("greetingsController",
	function($scope){
		$scope.nameAndSurname = function(name, surname){
			$scope.name = name;
			$scope.surname = surname;
			$scope.greet = $scope.getGreet();
			if($scope.name !== undefined && $scope.surname !== undefined){
				if($scope.name !== null && $scope.surname !== ""){
					if($scope.name !== "" && $scope.surname !== null){
						return $scope.greet +
						$scope.name +" "+
						$scope.surname+"!"
					};
				};
			}
		};

		$scope.getGreet = function(){
			var today = new Date();
			return today.getHours() >= 0 && today.getHours() <= 11 ? " Buon giorno " :
			today.getHours() >= 12 && today.getHours() <= 18 ? " Buon pomeriggio " :
			today.getHours() >= 19 && today.getHours() <= 21 ? " Buona sera " : " Buona notte "

		};

		$scope.caricaDoc = function(eta) {
			return eta == undefined || eta == null || eta == "" ? "null" : eta >= 18 ? "major.html" : "minor.html"
		};

		$scope.getFormatt = function(eta){
			if(eta !== null || eta !== undefined || eta !== ""){
				if(eta >= 18){
					return "verde";
				}else{
					return "rosso";
				}
			}
		};
	})
.controller("timeController",
	function($scope, $interval) {

		$scope.getTime = function(){
			var today = new Date();
			return today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();

		};
		$interval(function () {
			$scope.getTime();
		}, 1000);


	})
.controller("calculatorController",
	function ($scope, $interval) {
		$scope.getSomma = function(num1, num2, evento) {
			console.log("Posizione " + evento.clientX + "," + evento.clientY);
			$scope.result = num1 + num2;
			return $scope.result;

		};

		$scope.getSub = function(num1, num2) {
			$scope.result = num1 - num2;
			return $scope.result;
		};

		$scope.getDiv = function(num1, num2) {
			$scope.result = num1 / num2;
			return $scope.result;
		};

		$scope.getMol = function(num1, num2){
			$scope.result = num1*num2;
			return $scope.result;
		};

		$scope.getDisabled = function(num1, num2){
			return num1 == undefined && num2 == undefined || num1 == undefined || num2 == undefined ? true : false;
		}

	})
.controller("elencoController",
	function($scope, elencoCitta){
		$scope.elencoCitta = elencoCitta.elenco;

	})
.controller("cittaController",
	function($scope, elencoCitta){
		$scope.aggiungiCitta = function() {
			elencoCitta.aggiungi({nome: $scope.nome, regione:$scope.regione});
		};

		$scope.checkUndefinedCity = function(nome, regione){
			if(nome == undefined || regione == undefined || 
				nome == undefined && regione == undefined ||
				nome == "" || regione == "" ||
				nome == "" && regione == ""){
				return true;
		}else{
			return false;
		}
	};

	$scope.checkAlreadyExsist = function(nome) {
		for(let i = 0; i<elencoCitta.elenco.length; i++){
			if(nome != undefined && elencoCitta.elenco[i].nome.includes(nome)){
				return true;
			}else{
				return false;
			}
		}

	};

})
.controller("elencoNoteController", function($scope, $http){
	$http.get("/webNotes/notes", {
		headers: {"Authorization":"Bearer Ahiaeffajw245252=="}
	})
	.success(function(data){
		alert("Andato tutto bene");
		$scope.getSuccess = function(){
		return data;
		}
	})
	.error(function(){
		alert("Errore");
	});
});


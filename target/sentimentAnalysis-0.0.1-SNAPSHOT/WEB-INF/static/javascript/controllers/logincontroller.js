sentimentAnalysisModule.controller('loginController',['$scope','$http','$location',function($scope,$http,$location){
	
$scope.loginEvent = function(){
	

	alert("login function called");
	$http.post("http://localhost:8080/sentimentAnalysis/loginservice",$scope.logindetails)
    .then(function(response) {
      $scope.dashboardData = response.data;
      $location.path('/dashboardhome');
      alert("login service called");
    });

};
	
}]);


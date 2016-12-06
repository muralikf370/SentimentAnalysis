sentimentAnalysisModule.controller('loginController',['$scope','$http','$location',function($scope,$http,$location){
	
$scope.loginEvent = function(){
	

	$http.post("http://localhost:8080/sentimentAnalysis/loginservice",$scope.logindetails)
    .then(function(response) {
      $scope.dashboardData = response.data;
      if(response.data){
    	  if(response.data.errorcode){
    		  if(response.data.errorcode == "01"){
    			  $location.path('/dashboardhome');
    		  }else{
    			  
    		  }
    	  }else{
    		  alert("Registraton success");  
    		  $location.path('/loginpage');
    	      
    	  }
      }
     
    });

};
	
}]);


sentimentAnalysisModule.controller('homepageController',['$scope','$http','$location',function($scope,$http,$location){
	
	
		
	}]);


sentimentAnalysisModule.controller('homepagecontrollermain',['$scope','$http','$location',function($scope,$http,$location){
	
	$scope.loginpage = function(){
		$location.path('/loginpage');
	};
	
	$scope.signuppage =function(){
		$location.path('/signup');
	}
	}]);


sentimentAnalysisModule.controller('dashboardcontrollerhome',['$scope','$http','$location',function($scope,$http,$location){
	
	
	}]);

sentimentAnalysisModule.controller('saveuserController',['$scope','$http','$location',function($scope,$http,$location){
	
	$scope.saveUser = function(){
		

		alert("here"+$scope.loginform);
		$http.post("http://localhost:8080/sentimentAnalysis/saveuser",$scope.logindetails)
	    .then(function(response) {
	      $scope.dashboardData = response.data;
	      if(response.data){
	    	  if(response.data.errorcode){
	    		  
	    	  }else{
	    		  $location.path('/dashboardhome');
	    	      alert("login service called");  
	    	  }
	      }
	     
	    });
	
	};
	
	}]);

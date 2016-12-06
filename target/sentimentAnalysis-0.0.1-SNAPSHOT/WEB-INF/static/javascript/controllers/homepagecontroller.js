sentimentAnalysisModule.controller('homepageController',['$scope','$http','$location',function($scope,$http,$location){
	
	$scope.login = function(){};
		
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



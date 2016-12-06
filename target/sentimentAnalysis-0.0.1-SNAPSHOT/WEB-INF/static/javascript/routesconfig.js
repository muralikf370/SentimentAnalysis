sentimentAnalysisModule.config(function($routeProvider) {
	$routeProvider
		.when('/loginpage', {
			templateUrl: 'static/html/login.html',
			controller: 'loginController'
		}).when('/homepage', {
			templateUrl: 'static/html/homepage.html',
			controller: 'homepageController'
		}).when('/fileuploadpage', {
			templateUrl: 'static/html/fileupload.html'
				
		}).when('/dashboardhome', {
			templateUrl: 'static/html/dashboardhomepage.html',
			controller:'dashboardcontrollerhome'
				
		}).when('/signup', {
			templateUrl: 'static/html/signup.html',
			controller:'homepagecontrollermain'
				
		}).when('/', {
			templateUrl: 'static/html/homepage.html',
			controller: 'homepagecontrollermain'
			
		});
	
	
});



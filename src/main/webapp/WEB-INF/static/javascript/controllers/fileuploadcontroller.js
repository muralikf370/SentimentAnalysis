sentimentAnalysisModule.controller('fupController', ['$scope', 'fileUpload', function($scope, fileUpload){
    $scope.uploadFile = function(){
        var file = $scope.myFile;
        
        console.log('file is ' );
        console.dir(file);
        
        var uploadUrl = "http://localhost:8080/sentimentAnalysis/uploadFile";
        fileUpload.uploadFileToUrl(file, uploadUrl);
     };
  }]);
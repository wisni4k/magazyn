angular.module('admin', []).controller('home',

function($scope, $http) {
	//sprawdzenie uprawnien i przekierowanie w zaleznosci od uprawnien
	var computeDefaultTemplate = function(user) {
		$scope.template = user && user.roles && user.roles.indexOf("ROLE_WRITER")>0 ? "write.html" : "read.html";		
	}

	//pobranie danych z resta
	$http.get('user').success(function(data) {
		if (data.name) {
			$scope.authenticated = true;
			$scope.user = data;
			computeDefaultTemplate(data);		
		} else {
			$scope.authenticated = false;
		}
		$scope.error = null
	}).error(function(response) {
		if (response.status === 0) {
			$scope.error = 'No connection. Verify application is running.';
		} else if (response.status == 401) {
			$scope.error = 'Unauthorized.';
		} else if (response.status == 403) {
			$scope.error = 'Forbidden.';
		} else {
			$scope.error = 'Unknown.';			
		}
		$scope.authenticated = false;
	});

	$scope.update = function() {
		$http.post('/resource/', {content: $scope.greeting.content}).success(function(data) {
			$scope.greeting = data;
		})
	}

	$scope.home = function() {
		computeDefaultTemplate($scope.user);
	}
	
	$scope.changes = function() {
		$scope.template = "changes.html";
		$http.get('/resource/changes').success(function(data) {
			$scope.data = data;
		})
	}
	
});

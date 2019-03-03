function Events($scope, $http){
	$http.get('http://localhost:9999/EventTracker/events.json').
		success(function(data){
			$scope.events = data;
			//$scope.tests = [{"name":"Java User Group"},{"name":"Angular User Group"}];	
		});
}
/**
 * Here a simple JavaScript file, with a function Events, and this is now Angular syntax
 * $scope, $http.
 * $http to go out and do anything that works with your server, so doing a GET, doing a POST, you use this variable,
 * http://localhost:8080/EventTracker/events. is harcoded here but you coud/should do otherwise 
 * A period on the end, and don't forget that period on the end, it's easy to skip that.
 * We're taking these two variables, we're going to go do a http. get to this URL 
 * ,if successful and you'll have another one for error handling down here,
 * if successful is going to take and call this function, this callback here 
 * and bind the data that gets returned into this variable,
 * so in this scope we're going to create a .events that's bound to this data here.
 * So that's it for the JavaScript call on this side,
 * now we just have to create page that will use this. i.e the eventReports.jsp file
 * 
 * 
 */
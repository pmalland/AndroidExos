<!doctype html>
<!-- html ng-app is the first sign that say that we are writing  an angular app -->
<html ng-app>
	<head>
		<title>Hello Events Angular</title>
		<!-- Here we're pulling the Angular source file directly from there site of angular
		Remember we had to dowload it and put it in our files for JQuery. -->
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
		<!-- The second script pull in our events we just created -->
		<script src="events.js"></script>
	</head>

<body>
	<!-- in ng-controller="Events", "Events" is tied to the Events function in events.js
	events.length is the length of the JSON array
	Here we bind our JSON response to an Angular frontend   -->
	<div ng-controller="Events">
		I have {{events.length}} events!		
		<ul class="events-container">
		<!-- bind this to the repeat -->
			<li ng-repeat="event in events">
				Repeat
				{{event.name}}
			</li>
		</ul>
	</div>
</body>
</html>
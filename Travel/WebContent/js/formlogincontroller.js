	var app = angular.module("app", []);
	app.controller("controller", function($scope)
	{
		$scope.user = 
		{
			email:"",
			password:"",
			valid: function()
			{
				return this.password !="" && this.email!="";						
			}
		};
	});

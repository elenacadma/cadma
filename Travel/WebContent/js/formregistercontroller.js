	var app = angular.module("app", []);
	app.controller("controller", function($scope)
	{
		$scope.user = 
		{
			nickname:"",	
			email:"",
			password:"",
			password2:"",
			valid: function()
			{
				return this.password == this.password2 && this.nickname!="" && this.email!="";						
			}
		};
	});

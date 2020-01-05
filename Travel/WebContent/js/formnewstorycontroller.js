	var app = angular.module("app", []);
	app.controller("controller", function($scope)
	{
		$scope.story = 
		{
			//prenderà gli attributi dalla form... automaticamente	
				
			valid: function()
			{
				return this.title!="" && this.content!="" && this.cost>0 && this.sincedate!="" && this.todate!="" && this.place!="" && this.image!="";
			}
		};
	});

"use strict";

(function () {

    angular.module('app')
        .controller("foodController",
        ["foodRepository", FoodCtrl]);

    function FoodCtrl(foodRepository ) {
        var vm = this;

        vm.controllerName = "foodController";

        foodRepository.getFoods().then(function (results) {
             vm.foods = results;
         }, function (error) {
             vm.error = true;
             vm.errorMessage = error;
         });
    }
}());
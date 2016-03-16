"use strict";

(function () {

    angular.module('app')
        .controller("foodFormController",
        ["$log", "foodRepository", "$state", FoodFormCtrl]);

    function FoodFormCtrl($log, foodRepository, $state) {
        var vm = this;
        
        vm.hasValidationError = false;

        vm.food = {};

        vm.saveFood = function (foodForm) {
            vm.hasValidationError = false;
            vm.hasSubmitError = false;

            var waitingDialog = BootstrapDialog.show({
                message: 'Please wait - Creating Food'
            });

            foodRepository.saveFood(vm.food).then(function (food) {
                waitingDialog.close();
                BootstrapDialog.show({
                    message: 'Food Saved successfully',
                    buttons: [{
                        id: 'button-close',
                        label: 'Close',
                        action: function (dialogWindow) {
                            dialogWindow.close();
                            $state.go("home.food");
                        }
                    }]
                });
            }, function (error) {
                waitingDialog.close();
            });

        };

        vm.cancel = function (foodForm) {
            $state.go("home.food");
        }
    }
}());
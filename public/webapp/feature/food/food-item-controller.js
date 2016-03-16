"use strict";

(function () {
    angular.module('app')
        .controller("foodItemController",
        ["$state", "foodRepository", FoodItemCtrl]);

    function FoodItemCtrl($state, foodRepository) {
        var vm = this;

        vm.controllerName = "foodItemController";

        vm.delete = function (food) {
            var waitingDialog;
            BootstrapDialog.confirm({
                message: 'Are you sure that you want to delete this food?',
                type: BootstrapDialog.TYPE_WARNING,
                btnOKLabel: 'Delete!',
                btnOKClass: 'btn-warning',
                callback: function (confirmed) {
                    if (confirmed) {
                        waitingDialog = BootstrapDialog.show({
                            message: 'Please wait - Deleting food'
                        });
                        foodRepository.deleteFood(food).then(function () {
                            waitingDialog.close();
                        }, function (error) {

                        });
                    }
                }
            })
        };
    }

}());
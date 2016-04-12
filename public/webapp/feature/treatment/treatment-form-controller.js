"use strict";

(function () {

    angular.module('app')
        .controller("treatmentFormController",
        ["$log", "treatmentRepository", "$state", TreatmentFormCtrl]);

    function TreatmentFormCtrl($log, treatmentRepository, $state) {
        var vm = this;
        
        vm.hasValidationError = false;

        vm.treatment = {};

        vm.saveTreatment = function (treatmentForm) {
            vm.hasValidationError = false;
            vm.hasSubmitError = false;

            var waitingDialog = BootstrapDialog.show({
                message: 'Please wait - Creating Treatment'
            });

            treatmentRepository.saveTreatment(vm.treatment).then(function (treatment) {
                waitingDialog.close();
                BootstrapDialog.show({
                    message: 'Treatment Saved successfully',
                    buttons: [{
                        id: 'button-close',
                        label: 'Close',
                        action: function (dialogWindow) {
                            dialogWindow.close();
                            $state.go("home.treatment");
                        }
                    }]
                });
            }, function (error) {
                waitingDialog.close();
            });

        };

        vm.cancel = function (treatmentForm) {
            $state.go("home.treatment");
        }
    }
}());
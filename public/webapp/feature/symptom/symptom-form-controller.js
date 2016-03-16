"use strict";

(function () {

    angular.module('app')
        .controller("symptomFormController",
        ["$log", "symptomRepository", "$state", SymptomFormCtrl]);

    function SymptomFormCtrl($log, symptomRepository, $state) {
        var vm = this;
        
        vm.hasValidationError = false;

        vm.symptom = {};

        vm.saveSymptom = function (symptomForm) {
            vm.hasValidationError = false;
            vm.hasSubmitError = false;

            var waitingDialog = BootstrapDialog.show({
                message: 'Please wait - Creating Symptom'
            });

            symptomRepository.saveSymptom(vm.symptom).then(function (symptom) {
                waitingDialog.close();
                BootstrapDialog.show({
                    message: 'Symptom Saved successfully',
                    buttons: [{
                        id: 'button-close',
                        label: 'Close',
                        action: function (dialogWindow) {
                            dialogWindow.close();
                            $state.go("home.symptom");
                        }
                    }]
                });
            }, function (error) {
                waitingDialog.close();
            });

        };

        vm.cancel = function (symptomForm) {
            $state.go("home.symptom");
        }
    }
}());
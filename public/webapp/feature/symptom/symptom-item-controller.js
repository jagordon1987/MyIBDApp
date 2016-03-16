"use strict";

(function () {
    angular.module('app')
        .controller("symptomItemController",
        ["$state", "symptomRepository", SymptomItemCtrl]);

    function SymptomItemCtrl($state, symptomRepository) {
        var vm = this;

        vm.controllerName = "symptomItemController";

        vm.delete = function (symptom) {
            var waitingDialog;
            BootstrapDialog.confirm({
                message: 'Are you sure that you want to delete this symptom?',
                type: BootstrapDialog.TYPE_WARNING,
                btnOKLabel: 'Delete!',
                btnOKClass: 'btn-warning',
                callback: function (confirmed) {
                    if (confirmed) {
                        waitingDialog = BootstrapDialog.show({
                            message: 'Please wait - Deleting symptom'
                        });
                        symptomRepository.deleteSymptom(symptom).then(function () {
                            waitingDialog.close();
                        }, function (error) {

                        });
                    }
                }
            })
        };
    }

}());
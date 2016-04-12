"use strict";

(function () {
    angular.module('app')
        .controller("treatmentItemController",
        ["$state", "treatmentRepository", TreatmentItemCtrl]);

    function TreatmentItemCtrl($state, treatmentRepository) {
        var vm = this;

        vm.controllerName = "treatmentItemController";

        vm.delete = function (treatment) {
            var waitingDialog;
            BootstrapDialog.confirm({
                message: 'Are you sure that you want to delete this treatment?',
                type: BootstrapDialog.TYPE_WARNING,
                btnOKLabel: 'Delete!',
                btnOKClass: 'btn-warning',
                callback: function (confirmed) {
                    if (confirmed) {
                        waitingDialog = BootstrapDialog.show({
                            message: 'Please wait - Deleting treatment'
                        });
                        treatmentRepository.deleteTreatment(treatment).then(function () {
                            waitingDialog.close();
                        }, function (error) {

                        });
                    }
                }
            })
        };
    }

}());
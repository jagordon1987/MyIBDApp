"use strict";

(function () {

    angular.module('app')
        .controller("treatmentController",
        ["treatmentRepository", TreatmentCtrl]);

    function TreatmentCtrl(treatmentRepository ) {
        var vm = this;

        vm.controllerName = "treatmentController";

        treatmentRepository.getTreatments().then(function (results) {
             vm.treatments = results;
         }, function (error) {
             vm.error = true;
             vm.errorMessage = error;
         });
    }
}());
"use strict";

(function () {

    angular.module('app')
        .controller("symptomController",
        ["symptomRepository", SymptomCtrl]);

    function SymptomCtrl(symptomRepository ) {
        var vm = this;

        vm.controllerName = "symptomController";

        symptomRepository.getSymptoms().then(function (results) {
             vm.symptoms = results;
         }, function (error) {
             vm.error = true;
             vm.errorMessage = error;
         });
    }
}());
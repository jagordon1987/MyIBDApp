"use strict";

(function () {
    angular.module("app")
        .controller("homeController",
        ["$state", '$window', HomeCtrl]);

    function HomeCtrl($state, $window) {
        var vm = this;
        
        vm.isAtDashboard = function () {
            return $state.is("home.dashboard");
        };

        vm.isAtFood = function () {
            return $state.includes("home.food");
        };

        vm.isAtTreatment = function () {
            return $state.includes("home.treatment");
        };

        vm.isAtSymptom = function () {
            return $state.includes("home.symptom");
        };

        vm.isAtInformation = function () {
            return $state.includes("home.information");
        };

        vm.isAtAssistance = function () {
            return $state.includes("home.assistance");
        };

        vm.navigateToDashboard = function () {
            $state.go("home.dashboard");
        };

        vm.navigateToAddFood = function () {
            $state.go("home.addfood");
        };

        vm.navigateToFood = function () {
            $state.go("home.food");
        };

        vm.navigateToAddSymptom = function () {
            $state.go("home.addsymptom");
        };

        vm.navigateToSymptom = function () {
            $state.go("home.symptom");
        };

        vm.navigateToAddTreatment = function () {
            $state.go("home.addtreatment");
        };

        vm.navigateToTreatment = function () {
            $state.go("home.treatment");
        };

        vm.navigateToInformation = function () {
            $state.go("home.information");
        };

        vm.navigateToAssistance = function () {
            $state.go("home.assistance");
        };

        vm.logout = function () {
            delete $window.sessionStorage.token;
            $state.go("login");
        };
    }
}());
"use strict";

(function () {

    angular.module("app")
        .controller("loginController",
        ["$state",  LoginCtrl]);

    function LoginCtrl($state) {
        var vm = this;

        vm.hasValidationError = false;
        vm.hasAuthenticationError = false;


        vm.login = function () {
            vm.hasValidationError = false;
            vm.hasAuthenticationError = false;
            vm.credentials = {username: vm.username, password: vm.password};
            $state.go("home.dashboard");
        };
    }
}());

"use strict";

(function () {
    /**
     * Global controller at index page
     */
    angular
        .module('app')
        .controller("appController",
        [AppCtrl]);


    function AppCtrl() {
        var vm = this;
    }

}());
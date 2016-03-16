"use strict";
(function () {

    var app = angular.module("app", ["ui.router"]).run(
        function ($window, $rootScope, $log, $location) {
            $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
                if(fromState.url.indexOf("/") > -1)
                {
                    if(fromState.url !== $location.url())
                    {
                        event.preventDefault();
                    }
                }
            });
        });

}());

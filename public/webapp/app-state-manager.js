"use strict";

(function () {

    angular.module('app').config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("login");

        $stateProvider.state("login", {
            url: "/login",
            views: {
                "content": {
                    templateUrl: "feature/login/login-index.html"
                }
            }
        })
    });
}());


(function () {

    angular.module('app').config(function ($stateProvider) {
        $stateProvider.state("home", {
            abstract: true,
            views: {
                "content": {
                    templateUrl: "feature/home/home-index.html"
                }
            }

        }).state("home.dashboard", {
            url: "/dashboard",
            views: {
                "home-content": {
                    templateUrl: "feature/dashboard/dashboard-index.html"
                }
            }
        }).state("home.food", {
            url: "/food",
            views: {
                "home-content": {
                    templateUrl: "feature/food/food-index.html"
                }
            }
        }).state("home.addfood", {
            url: "/food/add",
            views: {
                "home-content": {
                    templateUrl: "feature/food/food-form.html"
                }
            }
        }).state("home.treatment", {
            url: "/treatment",
            views: {
                "home-content": {
                    templateUrl: "feature/treatment/treatment-index.html"
                }
            }
        }).state("home.addtreatment", {
            url: "/treatment/add",
            views: {
                "home-content": {
                    templateUrl: "feature/treatment/treatment-form.html"
                }
            }
        }).state("home.symptom", {
            url: "/symptom",
            views: {
                "home-content": {
                    templateUrl: "feature/symptom/symptom-index.html"
                }
            }
        }).state("home.addsymptom", {
            url: "/symptom/add",
            views: {
                "home-content": {
                    templateUrl: "feature/symptom/symptom-form.html"
                }
            }
        }).state("home.information", {
            url: "/information",
            views: {
                "home-content": {
                    templateUrl: "feature/information/information-index.html"
                }
            }
        }).state("home.assistance", {
            url: "/assistance",
            views: {
                "home-content": {
                    templateUrl: "feature/assistance/assistance-index.html"
                }
            }
        })
    });
}());

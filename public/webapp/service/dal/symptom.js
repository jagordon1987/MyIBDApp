"use strict";

(function () {

    angular.module("app").service("symptomDal", ["dal", SymptomDal]);

    function SymptomDal (dal) {

        this.getSymptoms = function () {
            return dal.http.GET("symptom");
        };

        this.getSymptom = function (id) {
            return dal.http.GET("symptom/" + id);
        };

        this.saveSymptom = function (saveSymptom) {
            return dal.http.POST("symptom", saveSymptom);
        };

        this.updateSymptom = function (updateSymptom) {
            return dal.http.PUT("symptom/", updateSymptom);
        };

        this.deleteSymptom = function (deleteSymptom) {
            return dal.http.DELETE("symptom/", deleteSymptom);
        };

    }
}());

"use strict";

(function () {

    angular.module("app").service("treatmentDal", ["dal", TreatmentDal]);

    function TreatmentDal (dal) {

        this.getTreatments = function () {
            return dal.http.GET("treatment");
        };

        this.getTreatment = function (id) {
            return dal.http.GET("treatment/" + id);
        };

        this.saveTreatment = function (saveTreatment) {
            return dal.http.POST("treatment", saveTreatment);
        };

        this.updateTreatment = function (updateTreatment) {
            return dal.http.PUT("treatment/", updateTreatment);
        };

        this.deleteTreatment = function (deleteTreatment) {
            return dal.http.DELETE("treatment/", deleteTreatment);
        };

    }
}());

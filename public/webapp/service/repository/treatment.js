"use strict";

(function () {


    angular.module("app").service("treatmentRepository", ["$q", "treatmentDal", TreatmentRepo]);

    function TreatmentRepo($q, treatmentDal) {

        var treatmentCache = [];

        this.getTreatments = function (searchCriteria) {

            var deferred = $q.defer();
            treatmentDal.getTreatments(searchCriteria).then(function (results) {
                treatmentCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });
            return deferred.promise;
        };

        this.saveTreatment = function (saveTreatment) {

            var deferred = $q.defer();
            var isTreatmentUpdate = saveTreatment.hasOwnProperty("id");

            treatmentDal.saveTreatment(saveTreatment).then(function (result) {
                if (!isTreatmentUpdate) {
                    treatmentCache.push(result);
                }
                deferred.resolve(result);
            }, function (error) {
                deferred.reject(error);
            });
            return deferred.promise;
        };

        this.deleteTreatment = function (deleteTreatment) {

            var deferred = $q.defer();
            treatmentDal.deleteTreatment(deleteTreatment).then(function (result) {
                _.remove(treatmentCache, {
                    id: deleteTreatment.id
                });
                deferred.resolve(treatmentCache);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };
    }
}());
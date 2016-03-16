"use strict";

(function () {


    angular.module("app").service("symptomRepository", ["$q", "symptomDal", SymptomRepo]);

    function SymptomRepo($q, symptomDal) {

        var symptomCache = [];

        this.getSymptoms = function (searchCriteria) {

            var deferred = $q.defer();
            symptomDal.getSymptoms(searchCriteria).then(function (results) {
                symptomCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });
            return deferred.promise;
        };

        this.saveSymptom = function (saveSymptom) {

            var deferred = $q.defer();
            var isSymptomUpdate = saveSymptom.hasOwnProperty("id");

            symptomDal.saveSymptom(saveSymptom).then(function (result) {
                if (!isSymptomUpdate) {
                    symptomCache.push(result);
                }
                deferred.resolve(result);
            }, function (error) {
                deferred.reject(error);
            });
            return deferred.promise;
        };

        this.deleteSymptom = function (deleteSymptom) {

            var deferred = $q.defer();
            symptomDal.deleteSymptom(deleteSymptom).then(function (result) {
                _.remove(symptomCache, {
                    id: deleteSymptom.id
                });
                deferred.resolve(symptomCache);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };
    }
}());
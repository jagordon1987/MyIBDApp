"use strict";

(function () {


    angular.module("app").service("foodRepository", ["$q", "foodDal", FoodRepo]);

    function FoodRepo($q, foodDal) {

        var foodCache = [];

        this.getFoods = function (searchCriteria) {

            var deferred = $q.defer();
            foodDal.getFoods(searchCriteria).then(function (results) {
                foodCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });
            return deferred.promise;
        };

        this.saveFood = function (saveFood) {

            var deferred = $q.defer();
            var isFoodUpdate = saveFood.hasOwnProperty("id");

            foodDal.saveFood(saveFood).then(function (result) {
                if (!isFoodUpdate) {
                    foodCache.push(result);
                }
                deferred.resolve(result);
            }, function (error) {
                deferred.reject(error);
            });
            return deferred.promise;
        };

        this.deleteFood = function (deleteFood) {

            var deferred = $q.defer();
            foodDal.deleteFood(deleteFood).then(function (result) {
                _.remove(foodCache, {
                    id: deleteFood.id
                });
                deferred.resolve(foodCache);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };
    }
}());
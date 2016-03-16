"use strict";

(function () {

    angular.module("app").service("foodDal", ["dal", FoodDal]);

    function FoodDal (dal) {

        this.getFoods = function () {
            return dal.http.GET("food");
        };

        this.getFood = function (id) {
            return dal.http.GET("food/" + id);
        };

        this.saveFood = function (saveFood) {
            return dal.http.POST("food", saveFood);
        };

        this.updateFood = function (updateFood) {
            return dal.http.PUT("food/", updateFood);
        };

        this.deleteFood = function (deleteFood) {
            console.log("This is the value of delete food");
            console.log(deleteFood);

            return dal.http.DELETE("food/", deleteFood);
        };

    }
}());

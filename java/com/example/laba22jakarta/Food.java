package com.example.laba22jakarta;

import lombok.Getter;

public class Food {
    @Getter private String firstMeal;
    @Getter private String secondMeal;
    @Getter private String thirdMeal;
    @Getter private String fourthMeal;
    @Getter private int weight;

    public Food(String firstMeal, String secondMeal, String thirdMeal, String fourthMeal, int weight) {
        this.firstMeal = firstMeal;
        this.secondMeal = secondMeal;
        this.thirdMeal = thirdMeal;
        this.fourthMeal = fourthMeal;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        Food food = (Food) obj;
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!firstMeal.equals(food.firstMeal)) return false;
        if (!secondMeal.equals(food.secondMeal)) return false;
        if (!thirdMeal.equals(food.thirdMeal)) return false;
        if (!fourthMeal.equals(food.fourthMeal)) return false;
        return weight == food.weight;
    }

    @Override
    public int hashCode() {
        int result = (int) ((int) weight ^ ((int) weight >>> 32));
        result = 31 * result + firstMeal.hashCode();
        result = 31 * result + secondMeal.hashCode();
        result = 31 * result + thirdMeal.hashCode();
        result = 31 * result + fourthMeal.hashCode();
        return result;
    }
}
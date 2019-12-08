package com.example.myrecipes.data;


import android.media.Image;

import com.orm.SugarRecord;

public class RecipeItem extends SugarRecord{
    String name;
    String description;
    String ingredients;
    String time;
    //Image image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public RecipeItem(){

    }

    public RecipeItem(String name, String description, String ingredients, String time) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.time = time;
    }
}


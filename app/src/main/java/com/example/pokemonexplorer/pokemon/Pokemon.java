package com.example.pokemonexplorer.pokemon;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private Integer imageResourseId;
    private String name, description, height, category, weight, ability;

    public Pokemon(Integer imageResourseId, String name, String description, String height,
                   String category, String weight, String ability){
        this.imageResourseId = imageResourseId;
        this.name = name;
        this.description = description;
        this.height = height;
        this.category = category;
        this.weight = weight;
        this.ability = ability;


    }

    public Integer getImageResourseId() {
        return imageResourseId;
    }

    public void setImageResourseId(Integer imageResourseId) {
        this.imageResourseId = imageResourseId;
    }

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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
}

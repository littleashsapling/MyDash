package com.example.mydash;

import java.util.Date;

public class Mood {
    public String mood;
    public String notes;
    public Date date;

    public Mood(String mood, String notes, Date date){
        this.mood = mood;
        this.notes = notes;
        this.date = date;
    }

    public int getIcon(){
        switch(this.mood){
            case "Happy": return R.drawable.ic_happy;
            case "Content": return R.drawable.ic_content;
            case "Sad": return R.drawable.ic_sadface;
            default: return R.drawable.ic_content;
        }
    }

    public int getColor(){
        switch ((this.mood)){
            case "Happy": return R.color.colorHappy;
            case "Content": return R.color.colorContent;
            case "Sad": return R.color.colorSad;
            default: return R.color.colorContent;
        }
    }
}
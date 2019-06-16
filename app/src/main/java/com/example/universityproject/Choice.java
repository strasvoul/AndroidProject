package com.example.universityproject;

public enum Choice {
    ROCK("Rock", R.drawable.rock),
    PAPER("Paper", R.drawable.paper),
    SCISSOR("Scissor", R.drawable.scissors);

    private final String name;
    private final int imageId;
    Choice(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }
    public String getName() {
        return name;
    }

    public int getImage() {
        return imageId;
    }
}
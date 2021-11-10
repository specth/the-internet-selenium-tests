package de.thorsten.extensions;

public class Helper {

    // Helper
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
package com.github.tulesaza.guessnumberhigherorlower;

import java.util.Random;

public abstract class GuessGame {


    private int pickedNumber;

    protected GuessGame() {

    }

    int startGame(int n) {
        Random random = new Random();
        pickedNumber = random.nextInt(n - 1) + 1;
        return pickedNumber;
    }


    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is higher than the picked number
     * 1 if num is lower than the picked number
     * otherwise return 0
     */

    int guess(int num) {
        int result = 0;
        if (num != pickedNumber) {
            result = num > pickedNumber ? -1 : 1;
        }
        System.out.printf("Guess %d, result %d\n", num, result);
        return result;
    }

}

package com.github.tulesaza.guessnumberhigherorlower;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void guessNumberRange100() {
        Solution game = new Solution();
        int picked = game.startGame(100);
        System.out.printf("Picked %d from range 1 to 100\n",picked);
        int guessed = game.guessNumber(100);
        assertEquals(picked, guessed);
    }
}
package ui;

import racingcar.RacingGame;
import util.RandomUtil;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
    private GameInput gameInput;
    private GameOutput gameOutput;

    public Program() {
        this.gameOutput = new GameOutput();
        this.gameInput = new GameInput(gameOutput, new Scanner(System.in));
    }

    public void run() {
        RacingGame racingGame = gameInput.input();
        play(racingGame);
        gameOutput.println(Arrays.toString(racingGame.getWinner()) + "가 최종 우승했습니다.");
    }

    private void play(RacingGame racingGame) {
        gameOutput.println("\n실행결과");
        for (int i = 0; i < racingGame.getRound(); i++) {
            String progress = racingGame.next(this::getVariable);
            gameOutput.println(progress);
        }
    }

    private int getVariable() {
        return RandomUtil.getTenLessThanNaturalNumbersAndZero();
    }
}
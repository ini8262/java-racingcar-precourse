package ui;

import racingcar.RacingGame;

import java.util.Scanner;

public class GameInput {

    private GameOutput output;
    private Scanner sc;

    public GameInput(GameOutput output, Scanner sc) {
        this.output = output;
        this.sc = sc;
    }

    public RacingGame input() {
        try {
            String names = getNames();
            return new RacingGame(getRound(), names.split("[\\s]?,[\\s]?"));
        } catch (Exception e) {
            output.println(String.format("[부적합한 입력값] %s\n", e.getMessage()));
            return input();
        }
    }

    private String getNames() {
        String names = (String) response("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        if (names.isEmpty()) {
            throw new RuntimeException("공백은 불가능합니다.");
        }
        return names;
    }

    private Integer getRound() {
        try {
            return Integer.parseInt((String) response("시도할 회수는 몇회인가요?"));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다.");
        }
    }

    private Object response(String messaage) {
        output.println(messaage);

        return sc.nextLine();
    }

}

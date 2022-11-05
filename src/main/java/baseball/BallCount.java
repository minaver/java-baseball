package baseball;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallCount {
    private int ballCount;
    private int strikeCount;

    public BallCount() {}

    // 볼 카운트 계산 method
    public void ruleBallCount(List<Integer> targetNumber, int guessNumber) {
        int ballCount = 0;
        List<Integer> guessDigitList = numberDigitToList(guessNumber);

        for (int i = 0; i < targetNumber.size(); i++) {
            ballCount += compareDigitList(targetNumber.get(i),guessDigitList,i);
        }

        this.ballCount = ballCount;
    }

    // 스트라이크 카운트 계산 method
    public void ruleStrikeCount(List<Integer> targetNumber, int guessNumber) {
        int strikeCount = 0;
        List<Integer> guessDigitList = numberDigitToList(guessNumber);

        for (int i = 0; i < targetNumber.size(); i++) {
            if (targetNumber.get(i) == guessDigitList.get(i)) {
                strikeCount++;
            }
        }

        this.strikeCount = strikeCount;
    }

    private List<Integer> numberDigitToList(int number) {
        return Arrays.stream(Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .toArray())
                .boxed().collect(Collectors.toList());
    }

    private int compareDigitList(int compareNumber, List<Integer> compareList, int exceptIndex) {
        if(compareList.contains(compareNumber) && compareList.get(exceptIndex) != compareNumber) {
            return 1;
        }
        return 0;
    }

    public void printBallCount() {
        if(strikeCount == Constant.MAX_STRIKE_COUNT){
            System.out.println(Constant.THREE_STRIKE);
        } else if((ballCount == 0) && (strikeCount == 0)) {
            System.out.println(Constant.NO_BALL_NO_STRIKE);
        } else if((ballCount != 0) && (strikeCount == 0)) {
            System.out.println(ballCount + Constant.BALL);
        } else if((ballCount == 0) && (strikeCount != 0)) {
            System.out.println(strikeCount + Constant.STRIKE);
        } else if((ballCount != 0) && (strikeCount != 0)) {
            System.out.println(ballCount + Constant.BALL + " " + strikeCount + Constant.STRIKE);
        }
    }

    public GuessResult getGuessResult() {
        if(strikeCount == Constant.MAX_STRIKE_COUNT) {
            return GuessResult.END;
        } else if((ballCount == 0) && (strikeCount == 0)) {
            return GuessResult.NOT_SWING;
        }

        return GuessResult.BALL_STRIKE;
    }

}

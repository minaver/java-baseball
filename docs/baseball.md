# 미션 - 숫자 야구

## 🚨 개발 고려 사항
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다.
## 🚀 기능 요구 사항
- 판정 기준 
  - 같은 수가 같은 자리 : 스트라이크
  - 다른 자리 : 볼
  - 같은 수가 전혀 없음 : 낫싱
- 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택
  - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료(1:새로 시작 / 2:종료)
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료

## 객체 리스트
    Baseball : 야구 게임 계산
        - Integer targetNumber : 정답 숫자
        - Integer guessNumber : 추정 숫자
    
    BallCount : 볼 / 스트라이크 카운트
        - Integer ballCount : 볼 카운트
        - Integer strikeCount : 스트라이크 카운트

## 기능 리스트
1. 게임 시작 기능
   - Baseball.start()
   1. resetTargetNumber() 호출
   2. 게임 시작 문구 출력
2. 1에서 9까지 서로 다른 임의의 수 3개를 선택 기능
   - Baseball.resetTarget()
   1. targetNumber 최신화
   2. `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`사용
3. 숫자 입력 받기 기능
   - Baseball.setGuessNumber()
   1. parameter로 받은 수가 1~9로 이루어진 세자리 정수인지 Validation
   2. guessNumber 최신화
4. 볼/스트라이크 계산 기능 
   - 볼 카운트 계산 : Baseball.ruleBallCount()
   1. 3자리수 loop 돌면서 다른 자리 수와 같은 수가 있으면 count up 
   - 스트라이크 카운트 계산 :Baseball.ruleStrikeCount()    
   1. 3자리수 loop 돌면서 다른 자리 수와 같은 수가 있으면 count up
   - 볼 / 스트라이크 계산 결과 저장 
   -> BallCount.setBallCount()
   -> BallCount.setStrikeCount()
5. 계산 결과 출력 기능
   - 볼/스트라이크 수 : Baseball.getBallCount()
   - 3스트라이크 -> 게임 종료(7)
6. 게임 재시작 기능
   - Baseball.restart()
7. 게임 종료 기능
   - Baseball.end()
   


   

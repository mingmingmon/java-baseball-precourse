package model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.object.Result;
import model.object.TestComputerNumber;

public class JudgeTest {

	private final Judge judge = new Judge();

	@Test
	@DisplayName("스트라이크와 볼을 종합하여 Result를 생성한다")
	void judgeReturnsCorrectResult() {
		ComputerNumber computer = TestComputerNumber.of(1, 2, 3);
		PlayerNumber player = new PlayerNumber("132");

		Result result = judge.judge(computer, player);
		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isEqualTo(2);
		assertThat(result.toString()).isEqualTo("1스트라이크 2볼");
	}

	@Test
	@DisplayName("스트라이크와 볼이 모두 0이면 낫싱이다")
	void judgeReturnsNothing() {
		ComputerNumber computer = TestComputerNumber.of(1, 2, 3);
		PlayerNumber player = new PlayerNumber("456");

		Result result = judge.judge(computer, player);
		assertThat(result.getStrike()).isZero();
		assertThat(result.getBall()).isZero();
		assertThat(result.toString()).isEqualTo("낫싱");
	}

	@Test
	@DisplayName("플레이어 숫자가 중복되어도 규칙에 맞게 판정한다")
	void judgeHandlesDuplicatePlayerNumber() {
		ComputerNumber computer = TestComputerNumber.of(4, 2, 7);
		PlayerNumber player = new PlayerNumber("223");

		Result result = judge.judge(computer, player);
		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isZero();
		assertThat(result.toString()).isEqualTo("1스트라이크");
	}
}

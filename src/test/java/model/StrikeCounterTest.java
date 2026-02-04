package model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.object.TestComputerNumber;

public class StrikeCounterTest {

	private final StrikeCounter strikeCounter = new StrikeCounter();

	@Test
	@DisplayName("같은 숫자가 같은 위치에 있으면 스트라이크로 계산한다")
	void countStrikeWhenNumberAndPositionMatch() {
		ComputerNumber computer = TestComputerNumber.of(1, 2, 3);
		PlayerNumber player = new PlayerNumber("123");

		int strike = strikeCounter.count(computer, player);
		assertThat(strike).isEqualTo(3);
	}

	@Test
	@DisplayName("숫자가 같아도 위치가 다르면 스트라이크가 아니다")
	void doNotCountStrikeWhenPositionIsDifferent() {
		ComputerNumber computer = TestComputerNumber.of(1, 2, 3);
		PlayerNumber player = new PlayerNumber("231");

		int strike = strikeCounter.count(computer, player);
		assertThat(strike).isEqualTo(0);
	}

	@Test
	@DisplayName("일부 숫자만 같은 위치에 있으면 해당 개수만 스트라이크다")
	void countPartialStrike() {
		ComputerNumber computer = TestComputerNumber.of(1, 2, 3);
		PlayerNumber player = new PlayerNumber("129");

		int strike = strikeCounter.count(computer, player);
		assertThat(strike).isEqualTo(2);
	}
}

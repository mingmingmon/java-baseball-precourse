package model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.object.TestComputerNumber;

public class BallCounterTest {

	private final BallCounter ballCounter = new BallCounter();

	@Test
	@DisplayName("같은 숫자가 다른 위치에 있으면 볼로 계산한다")
	void countBallWhenNumberMatchesButPositionDiffers() {
		ComputerNumber computer = TestComputerNumber.of(1, 2, 3);
		PlayerNumber player = new PlayerNumber("312");

		int ball = ballCounter.count(computer, player);
		assertThat(ball).isEqualTo(3);
	}

	@Test
	@DisplayName("같은 위치의 숫자는 볼로 계산하지 않는다")
	void doNotCountBallWhenPositionMatches() {
		ComputerNumber computer = TestComputerNumber.of(1, 2, 3);
		PlayerNumber player = new PlayerNumber("129");

		int ball = ballCounter.count(computer, player);
		assertThat(ball).isEqualTo(0);
	}

	@Test
	@DisplayName("플레이어의 숫자에서 중복된 수가 있는 경우 스트라이크를 볼보다 우선시 한다")
	void countBallOnceEvenIfPlayerHasDuplicates() {
		ComputerNumber computer = TestComputerNumber.of(1, 2, 3);
		PlayerNumber player = new PlayerNumber("124");

		int ball = ballCounter.count(computer, player);
		assertThat(ball).isEqualTo(0);
	}

	@Test
	@DisplayName("스트라이크로 사용된 숫자는 볼로 계산되지 않는다")
	void doNotCountBallForStrikeNumbers() {
		ComputerNumber computer = TestComputerNumber.of(4, 2, 7);
		PlayerNumber player = new PlayerNumber("223");

		int ball = ballCounter.count(computer, player);
		assertThat(ball).isEqualTo(0);
	}
}

package model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerNumberTest {

	@Test
	@DisplayName("플레이어는 1~9 사이의 숫자 3자리를 입력할 수 있다")
	void createPlayerNumberWithValidInput() {
		PlayerNumber playerNumber = new PlayerNumber("123");
		assertThat(playerNumber.getNumbers())
			.containsExactly(1, 2, 3);
	}

	@Test
	@DisplayName("플레이어가 입력한 숫자가 3자리가 아니면 예외가 발생한다")
	void throwExceptionWhenLengthIsNot3() {
		assertThatThrownBy(() -> new PlayerNumber("12"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("플레이어가 입력한 값에 숫자가 아닌 문자가 포함되면 예외가 발생한다.")
	void throwExceptionWhenContainsNonDigit() {
		assertThatThrownBy(() -> new PlayerNumber("12a"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("플레이어가 입력한 값에 0이 포함되면 예외가 발생한다.")
	void throwExceptionWhenContainsZero() {
		assertThatThrownBy(() -> new PlayerNumber("120"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}

package model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerNumberTest {

	@Test
	@DisplayName("봇(컴퓨터)는 항상 3자리인 숫자를 생성한다")
	void generateThreeDigitNumber() {
		ComputerNumber computerNumber = new ComputerNumber();
		List<Integer> numbers = computerNumber.getNumbers();
		assertThat(numbers).hasSize(3);
	}

	@Test
	@DisplayName("봇(컴퓨터)이 생성한 숫자는 1에서 9 사이의 값이다")
	void generateNumberWithinRange() {
		ComputerNumber computerNumber = new ComputerNumber();
		assertThat(computerNumber.getNumbers())
			.allSatisfy(number ->
				assertThat(number).isBetween(1, 9));
	}

	@Test
	@DisplayName("봇(컴퓨터)이 생성한 숫자는 서로 중복되지 않는다")
	void generateDistinctDigits() {
		ComputerNumber computerNumber = new ComputerNumber();
		Set<Integer> numbers = new HashSet<>(computerNumber.getNumbers());
		assertThat(numbers).hasSize(3);
	}

}

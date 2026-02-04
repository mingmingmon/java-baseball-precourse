package model;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {

	private static final int NUMBER_COUNT = 3;
	private static final int MIN = 1;
	private static final int MAX = 9;

	private final List<Integer> numbers;

	public PlayerNumber(String input) {
		validate(input);
		this.numbers = parse(input);
	}

	private void validate(String input) {
		validateLength(input);
		validateAllDigits(input);
		validateRange(input);
	}

	private void validateLength(String input) {
		if (input.length() != NUMBER_COUNT) {
			throw new IllegalArgumentException("입력은 3자리 숫자여야 합니다.");
		}
	}

	private void validateAllDigits(String input) {
		for (char c : input.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException("숫자 이외의 입력은 불가능합니다.");
			}
		}
	}

	private void validateRange(String input) {
		for (char c : input.toCharArray()) {
			int number = c - '0';
			if (number < MIN || number > MAX) {
				throw new IllegalArgumentException("1 ~ 9까지의 숫자만 입력 가능합니다.");
			}
		}
	}

	private List<Integer> parse(String input) {
		List<Integer> result = new ArrayList<>();
		for (char c : input.toCharArray()) {
			result.add(c - '0');
		}
		return result;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

}

package model.object;

import java.util.List;

import model.ComputerNumber;

public class TestComputerNumber extends ComputerNumber {

	private TestComputerNumber(List<Integer> numbers) {
		super(numbers);
	}

	public static ComputerNumber of(int a, int b, int c) {
		return new TestComputerNumber(List.of(a, b, c));
	}
}

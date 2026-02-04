package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerNumber {

	private static final int SIZE = 3;
	private static final int MIN = 1;
	private static final int MAX = 9;

	private final List<Integer> numbers;

	public ComputerNumber(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public ComputerNumber() {
		this.numbers = generate();
	}

	private List<Integer> generate() {
		List<Integer> pool = new ArrayList<>();
		for (int i = MIN; i <= MAX; i++) {
			pool.add(i);
		}

		Collections.shuffle(pool);
		return pool.subList(0, SIZE);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

}

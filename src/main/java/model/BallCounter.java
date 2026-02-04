package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallCounter {

	private final StrikeCounter strikeCounter = new StrikeCounter();

	public List<Integer> extractCommonNumber(List<Integer> a, List<Integer> b) {
		Set<Integer> common = new HashSet<>(a);
		common.retainAll(b);
		return new ArrayList<>(common);
	}

	public int count(ComputerNumber computer, PlayerNumber player) {
		List<Integer> commonNumbers = extractCommonNumber(computer.getNumbers(), player.getNumbers());
		return commonNumbers.size() - strikeCounter.count(computer, player);
	}

}

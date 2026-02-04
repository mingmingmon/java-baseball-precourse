package model;

import java.util.List;

public class StrikeCounter {

	public int count(ComputerNumber computerNumber, PlayerNumber playerNumber) {
		List<Integer> computer = computerNumber.getNumbers();
		List<Integer> player = playerNumber.getNumbers();

		int strike = 0;
		for (int i = 0; i < computer.size(); i++) {
			if (computer.get(i).equals(player.get(i))) {
				strike++;
			}
		}
		return strike;
	}
}

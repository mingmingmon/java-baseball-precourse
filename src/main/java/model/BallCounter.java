package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallCounter {

	public int count(ComputerNumber computerNumber, PlayerNumber playerNumber) {
		List<Integer> computer = computerNumber.getNumbers();
		List<Integer> player = playerNumber.getNumbers();
		Set<Integer> playerSet = new HashSet<>(player);

		int ball = 0;
		for (int i = 0; i < playerSet.size(); i++) {
			int playerNumberAt = player.get(i);

			if (computer.contains(playerNumberAt)
				&& !computer.get(i).equals(playerNumberAt)) {
				ball++;
			}
		}
		return ball;
	}
}

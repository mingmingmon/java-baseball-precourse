package model;

import java.util.List;

public class BallCounter {

	public int count(ComputerNumber computerNumber, PlayerNumber playerNumber) {
		List<Integer> computer = computerNumber.getNumbers();
		List<Integer> player = playerNumber.getNumbers();

		int ball = 0;
		for (int i = 0; i < player.size(); i++) {
			int playerNumberAt = player.get(i);

			if (computer.contains(playerNumberAt)
				&& !computer.get(i).equals(playerNumberAt)) {
				ball++;
			}
		}
		return ball;
	}
}

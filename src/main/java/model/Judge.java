package model;

import model.object.Result;

public class Judge {

	private final StrikeCounter strikeCounter;
	private final BallCounter ballCounter;

	public Judge() {
		this.strikeCounter = new StrikeCounter();
		this.ballCounter = new BallCounter();
	}

	public Result judge(ComputerNumber computerNumber, PlayerNumber playerNumber) {
		int strike = strikeCounter.count(computerNumber, playerNumber);
		int ball = ballCounter.count(computerNumber, playerNumber);

		return new Result(strike, ball);
	}
}

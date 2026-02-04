package model.object;

public class Result {

	private final int strike;
	private final int ball;

	public Result(int strike, int ball) {
		validate(strike, ball);
		this.strike = strike;
		this.ball = ball;
	}

	private void validate(int strike, int ball) {
		if (strike < 0 || ball < 0) {
			throw new IllegalArgumentException("스트라이크와 볼은 음수가 될 수 없습니다.");
		}
		if (strike + ball > 3) {
			throw new IllegalArgumentException("스트라이크와 볼의 합은 3을 넘을 수 없습니다.");
		}
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	@Override
	public String toString() {
		if (strike == 0 && ball == 0) {
			return "낫싱";
		}

		StringBuilder result = new StringBuilder();

		if (strike > 0) {
			result.append(strike).append("스트라이크");
		}

		if (strike > 0 && ball > 0) {
			result.append(" ");
		}

		if (ball > 0) {
			result.append(ball).append("볼");
		}

		return result.toString();
	}
}

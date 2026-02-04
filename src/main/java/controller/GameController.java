package controller;

import model.ComputerNumber;
import model.Judge;
import model.PlayerNumber;
import model.object.Result;
import view.GameView;

public class GameController {

	private final GameView view = new GameView();
	private final Judge judge = new Judge();

	private Result round(ComputerNumber computer) {
		try {
			PlayerNumber player = new PlayerNumber(view.readPlayerNumber());
			return judge.judge(computer, player);
		} catch (IllegalArgumentException e) {
			view.printErrorMessage(e.getMessage());
			return round(computer);
		}
	}

	private boolean isRestart() {
		return view.readRestartCommand() == 1;
	}

	public void run() {
		do {
			playGame();
		} while (isRestart());
	}

	private void playGame() {
		ComputerNumber computer = new ComputerNumber();

		while (true) {
			Result result = round(computer);
			view.printResult(result);

			if (result.isThreeStrike()) {
				view.printGamClear();
				return;
			}
		}
	}

}

package view;

import java.util.Scanner;

import model.object.Result;

public class GameView {

	private final Scanner scanner = new Scanner(System.in);

	public String readPlayerNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		return scanner.nextLine();
	}

	public void printResult(Result result) {
		System.out.println(result.toString());
	}

	public void printGamClear() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다!");
	}

	public int readRestartCommand() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public void printErrorMessage(String message) {
		System.out.println("[ERROR] " + message);
	}
}

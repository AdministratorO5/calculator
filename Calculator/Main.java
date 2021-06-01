package Calculator;

import java.util.Scanner;

public class Main {
    private static final char exitCharacter = '!';
    public static void main(String[] args) {
        DataReader reader = new DataReader(exitCharacter);
        while (true) {
            try {
                reader.read();
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                continue;
            }
            if (reader.isExitFlag()) {
                System.out.println("В выражении пристутствует знак выхода: " + exitCharacter);
                System.out.println("Завершение программы.");
                break;
            }
            double result = Calculator.calculate(reader.getVar1(), reader.getVar2(), reader.getOper());
            System.out.println(result);
        }
    }
}


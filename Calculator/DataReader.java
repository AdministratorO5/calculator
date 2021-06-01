package Calculator;

import java.util.Scanner;

public class DataReader {
     private int number1;
     private int number2;
     private char operation;
     private boolean exitFlag;
     private char exitCharacter;
     private char resultChar;

     public DataReader(char exitCharacter) {
         this.exitCharacter = exitCharacter;
         this.resultChar = '=';
     }


     public void read() {

         Integer[] arabic = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
         String[] roman = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

         System.out.println("Введите выражение, состоящее из двух целых чисел от 0 до 10, знака операции и знака равно (напр. 2+2=): ");
         Scanner scanner = new Scanner(System.in);
         StringBuilder builder = new StringBuilder();
         String text = scanner.nextLine();
         if (text.indexOf(exitCharacter) != -1) {
             exitFlag = true;
             return;
         }

         try {
             if ((text.charAt(text.length() - 1) != resultChar)) {
                 throw new RuntimeException();
             }

             text = text.substring(0, text.length() - 1);
             String[] blocks = text.split("[+-/*]");

             // проверка

             boolean flag = false;
             for (int i = 0; i < roman.length; i++){
                 if (roman[i].equals(blocks[0]) || roman[i].equals(blocks[1])){
                     flag = true;
                 }
                 //flag = true  римские обозначения
                 if(flag){
                     number1 = romanToNumber(blocks[0]);
                     number2 = romanToNumber(blocks[1]);
                 } else {
                     number1 = Integer.parseInt(blocks[0]);
                     operation = text.charAt(blocks[0].length());
                     number2 = Integer.parseInt(blocks[1]);

                    }
                }
             if ((number1 > 10 || number1 < 0) || (number2 > 10 || number2 < 0)) {
                 throw new IllegalArgumentException();
                }
            } catch (RuntimeException e) {
             throw new IllegalArgumentException("Неверный формат данных");
         }
        }
        private static int romanToNumber(String roman) {
         if (roman.equals("I")) {
             return 1;
         } else if (roman.equals("II")) {
             return 2;
         } else if (roman.equals("III")) {
             return 3;
         } else if (roman.equals("IV")) {
             return 4;
         } else if (roman.equals("V")) {
             return 5;
         } else if (roman.equals("VI")) {
             return 6;
         } else if (roman.equals("VII")) {
             return 7;
         } else if (roman.equals("VIII")) {
             return 8;
         } else if (roman.equals("IX")) {
             return 9;
         } else if (roman.equals("X")) {
             return 10;
         } else {
             return -1;
         }
     }

     public int getVar1() {
            return number1;
        }
        public int getVar2() {
            return number2;
        }
        public char getOper() {
            return operation;
        }
        public boolean isExitFlag() {
            return exitFlag;
        }
}



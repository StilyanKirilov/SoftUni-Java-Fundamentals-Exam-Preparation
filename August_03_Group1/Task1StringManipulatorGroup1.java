package Final_Exam_Prep.August_03_Group1;

import java.util.Scanner;

public class Task1StringManipulatorGroup1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String input;

        while (!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Translate":
                    if (text.contains(tokens[1])) {
                        text = text.replace((tokens[1]), tokens[2]);
                        System.out.println(text);
                    }
                    break;
                case "Includes":
                    if (text.contains(tokens[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    if (text.startsWith(tokens[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    if (text.contains(tokens[1])) {
                        int findIndex = text.lastIndexOf(tokens[1]);
                        System.out.println(findIndex);

                    }
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(tokens[1]);

                    int endIndex = Integer.parseInt(tokens[2]);

                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < text.length(); i++) {
                        sb.append(text.charAt(i));
                    }
                    sb.replace(startIndex, startIndex + endIndex, "");
                    text = sb.toString();

                    System.out.println(text);
                    break;
            }
            /* //Thi5 I5 MY 5trING!//
Translate 5 s
Includes string
Start //This
Lowercase
FindIndex q
Remove 0 10
End */
        }
    }
}

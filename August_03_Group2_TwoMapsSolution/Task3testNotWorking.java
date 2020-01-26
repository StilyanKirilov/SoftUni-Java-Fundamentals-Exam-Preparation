package Final_Exam_Prep.August_03_Group2_TwoMapsSolution;

import java.util.*;

public class Task3testNotWorking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> people = new TreeMap<>();

        String input = scanner.nextLine();

        while (!"Results".equals(input)) {
            List<Integer> newList = new ArrayList<>();
            String[] tokens = input.split(":");
            switch (tokens[0]) {
                case "Add":
                    String name = tokens[1];
                    int health = Integer.parseInt(tokens[2]);
                    int energy = Integer.parseInt(tokens[3]);

                    if (!people.containsKey(name)) {
                        newList.add(health);
                        newList.add(energy);
                        people.put(name, newList);
                    } else {
                        newList = people.get(name);
                        int newHealth = newList.get(0) + health;
                        newList.set(0, newHealth);
                        people.replace(name, newList);
                    }
                    break;
                case "Attack":
                    String attacker = tokens[1];
                    String defender = tokens[2];

                    if (people.containsKey(attacker) && people.containsKey(defender)) {
                        int damage = Integer.parseInt(tokens[3]);
                        newList = people.get(defender);
                        int newHealth = newList.get(0) - damage;
                        newList.set(0, newHealth);
                        people.replace(defender, newList);
                        if (newHealth <= 0) {
                            people.remove(defender);
                            System.out.println(defender + " was disqualified!");
                        }
                        newList = people.get(attacker);
                        int newEnergy = newList.get(1) - 1;
                        newList.set(1, newEnergy);
                        people.replace(attacker, newList);
                        if (newEnergy <= 0) {
                            people.remove(attacker);
                            System.out.println(attacker + " was disqualified!");
                        }
                    }
                    break;
                case "Delete":
                    String deleteName = tokens[1];
                    if (!"All".equals(deleteName)) {
                        people.remove(deleteName);
                    }else {
                        people.clear();
                    }

                    break;
            }


            input = scanner.nextLine();
        }

        System.out.println("People count: " + people.size());
        people
                .entrySet()
                .stream()
                //.sorted((a,b) -> b.getValue().get(0) - a.getValue().get(1))
                .forEach(entry -> {
                    entry
                            .getValue()
                            .stream()
                            .sorted((a,b) -> b);
                    System.out.printf("%s - %d - %d\n",entry.getKey(),entry.getValue().get(0),entry.getValue().get(1));
                } );
        // register
        //                .entrySet()
        //                .stream()
        //                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
        //                .forEach(entry -> {
        //                    System.out.printf("%s: %d\n", entry.getKey(), entry.getValue().size());
        //                    entry
        //                            .getValue()
        //                            .stream()
        //                            .sorted((a, b) -> a.compareTo(b))
        //                            .forEach(s -> System.out.println("-- " + s));
        //                });

    }
}

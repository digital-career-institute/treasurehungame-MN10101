package treasure_hunt_game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Location {
    String name, description;
    Location(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
class Treasure {
    String name, description;
    int value;
    Treasure(String name, String description, int value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }
}
public class TreasureHuntGame {
    public static void main(String[] args) {
        Map<String, Location> locations = Map.of(
                "Beach", new Location("Beach", "A beautiful day on the beach with warm sand."),
                "Forest", new Location("Forest", "A green forest with fresh air.")
        );
        List<Treasure> treasures = new ArrayList<>(List.of(
                new Treasure("Gold Coin", "A big golden coins", 55),
                new Treasure("Silver Sword", "A sharp sword", 2)
        ));
        HashSet<Treasure> inventory = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String currentLocation = "Beach";
        while (true) {
            System.out.println(locations.get(currentLocation).description);
            System.out.println("Choose: (1) Pick up a treasure, (2) Move to the next location, or (3) Quit? ");
            switch (scanner.nextInt()) {
                case 1 -> {
                    for (int i = 0; i < treasures.size(); i++) {
                        System.out.println((i + 1) + ". " + treasures.get(i).name + " - " + treasures.get(i).description);
                    }
                    int choice = scanner.nextInt();
                    if (choice >= 1 && choice <= treasures.size()) {
                        inventory.add(treasures.remove(choice - 1));
                        System.out.println("You picked up a treasure!");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                }
                case 2 -> {
                    System.out.println("Enter the name of the location you want to move to: ");
                    String newLocation = scanner.next();
                    currentLocation = locations.containsKey(newLocation) ? newLocation : currentLocation;
                    System.out.println("You moved to " + currentLocation);
                }
                case 3 -> {
                    inventory.forEach(item -> System.out.println(item.name + " - " + item.description));
                    System.out.println("Total value of treasures: " + inventory.stream().mapToInt(item -> item.value).sum());
                    System.out.println("Thanks for playing! Goodbye.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}








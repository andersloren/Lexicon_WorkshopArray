package se.lexicon;

import java.util.Objects;
import java.util.Scanner;

public class WorkshopArray {
    // This is the array, 10 rows x 3 columns
    public static String[][] names = new String[10][3];
    public static int currentIndex = 0; // Counter to prompt message if too many names are added

    // hardcoded values for the araray
    public static void main(String[] args) {
        names[0][0] = "Erik";
        names[0][1] = " ";
        names[0][2] = "Svensson";

        // The method returns the name provided as an argument if it's in the array, otherwise it returns null
        System.out.println("Method: find");
        System.out.println(find("Erik Svensson"));

        // The user will have to enter a name to add
        System.out.println("Method: 'add'");
        add(add());

        // There's no need for a parameter for findByFirstName since it will return an array of all the firstnames with no regard to the argument
        System.out.println("Method 2: findByFirstName");
        for (String name : findByFirstName("argument")) {
            System.out.println(name);
        }

        // There's no need for a parameter for findByLastName since it will return an array of all the lastnames with no regard to the argument
        System.out.println("findByLastName");
        for (String name : findByLastName("argument")) {
            System.out.println(name);
        }

        // The names are hardcoded, Anders Loren will swap place with Erik Svensson
        if (update("Erik Svensson", "Anders Loren")) {
            printArray();
        }

        // ["Erik", " ", "Svensson"] will get replaced with [null, null, null]
        printArray();
        System.out.println("--------------");
        if (remove("Erik Svensson")) {
            printArray();
        }
    }
    public static boolean remove(final String fullName) {
        if (!Objects.equals(find(fullName), fullName)) {
            return false;
        } else {
            String[] nameSplit = split(fullName);
            for (String[] name : names) {
                if (name[0].equalsIgnoreCase(nameSplit[0]) && name[2].equalsIgnoreCase(nameSplit[2])) {
                    name[0] = "";
                    name[1] = "";
                    name[2] = "";
                    break;
                }
            }
            return true;
        }
    }
    private static boolean update(final String original, final String updatedName) {
        if (find(updatedName) != null) {
            return false;
        }
        if (find(original) != null) {
            String[] splitOriginal = split(original);
            for (String[] name : names) {
                if (name[0].equalsIgnoreCase(splitOriginal[0]) && name[2].equalsIgnoreCase(splitOriginal[2])) {
                    String[] splitUpdate = split(updatedName);
                    name[0] = splitUpdate[0];
                    name[2] = splitUpdate[2];
                    break;
                }
            }
        }
        return true;
    }
    public static String[] findByLastName(final String lastName) {
        String[] lastnames = new String[10];
        for (int i = 0; i < names.length; i++) {
            if (names[i][2] != null) {
                lastnames[i] = names[i][2];
            }
        }
        return lastnames;
    }
    public static String[] findByFirstName(final String firstName) {
        String[] forenames = new String[10];
        for (int i = 0; i < names.length; i++) {
            if (names[i][0] != null) {
                forenames[i] = names[i][0];
            }
        }
        return forenames;
    }
    public static String find(final String fullName) {
        String[] namesSplit = split(fullName);
        for (String[] name : names) {
            if (name[0] == null) {
                break;
            } else if (name[0].equalsIgnoreCase(namesSplit[0]) && name[2].equalsIgnoreCase(namesSplit[2])) {
                return fullName;
            }
        }
        return null;
    }
    public static String add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv in ett namn (Förnamn Efternamn): ");
        return scanner.nextLine();
    }
    public static boolean add(final String fullName) {
        if (find(fullName) != null) {
            return false;
        } else {
            if (currentIndex < names.length) {
                currentIndex++;
                String[] namesSplit = split(fullName);
                names[currentIndex][0] = namesSplit[0];
                names[currentIndex][1] = namesSplit[1];
                names[currentIndex][2] = namesSplit[2];
            } else {
                System.out.println("Array is full!");
            }
        }
        printArray();
        return true;
    }
    public static String[] split(String fullName) {
        String firstName = fullName.substring(0, fullName.indexOf(" "));
        String blank = " ";
        String lastName = fullName.substring(fullName.indexOf(" ") + 1);
        String[] nameSplit = new String[3];
        nameSplit[0] = firstName;
        nameSplit[1] = blank;
        nameSplit[2] = lastName;
        return nameSplit;
    }
    public static void printArray() {
        for (int i = 0; i < names.length; i++) {
            System.out.print("Rad " + (i + 1) + ": ");
            for (String column : names[i]) {
                System.out.print(column);
            }
            System.out.println();
        }
    }
}

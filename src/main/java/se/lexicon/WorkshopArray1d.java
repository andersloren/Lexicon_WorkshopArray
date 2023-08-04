package se.lexicon;

import java.util.Arrays;

public class WorkshopArray1d {

    public static String[] names = new String[1];

    public static void main(String[] args) {
        names[0] = "Erik Svensson";

        // find
/*        String fullName = "Erik Svensson";
        System.out.println(find(fullName));*/
        // add
/*       add("Anders Loren");
        add("Markus Johansson");
        add("Stefan Olsson");
        add("Erik Johansson");
        add("Mats Olsson");
        add("Peter Loren");
        add("Erik Loren");*/
        // findByFirstName
/*        String firstName = "Erik";
        findByFirstName(firstName);*/
        // findByLastName
/*        String lastName = "Loren";
        printArray(findByLastName(lastName));*/
        // updateName
/*        String original = "Erik Svensson";
        String updatedName = "Nytt Namn";
        System.out.println(update(original, updatedName));*/
        // remove
/*        String removeName = "Erik Svensson";
        System.out.println(remove(removeName));*/
    }

    public static boolean remove(final String fullName) {
        if (find(fullName) == null) {
            return false;
        }

        String[] fullNames = new String[0];
        for (int i = 0; i < names.length; i++) {
            String[] fullNameArray = names[i].split(" ");
            String[] originalArray = fullName.split(" ");

            if (Arrays.equals(fullNameArray, originalArray)) {
                names[i] = null;
            }
        }
        return true;
    }
    public static boolean update(final String original, final String updateName) {
        if (find(original) == null || find(updateName) != null) {
            return false;
        }

        String[] fullNames = new String[0];
        for (int i = 0; i < names.length; i++) {
            String[] fullNameArray = names[i].split(" ");
            String[] originalArray = original.split(" ");

            if (Arrays.equals(fullNameArray, originalArray)) {
                names[i] = updateName;
            }
        }
        return true;
    }

    public static String[] findByFirstName(final String firstName) {
        String[] firstNames = new String[0];
        for (String name : names) {
            String[] fullNameArray = name.split(" ");
            String firstName_fullName = fullNameArray[0];

            if (firstName_fullName.equalsIgnoreCase(firstName)) {
                firstNames = addToArray(firstNames, firstName_fullName);
            }
        }
        return firstNames;
    }

    public static String[] findByLastName(final String lastName) {
        String[] lastNames = new String[0];
        for (String name : names) {
            String[] fullNameArray = name.split(" ");
            String lastName_fullName = fullNameArray[1];

            if (lastName_fullName.equalsIgnoreCase(lastName)) {
                lastNames = addToArray(lastNames, lastName_fullName);

            }
        }
        return lastNames;
    }

    public static String[] addToArray(final String[] firstNames, final String name) {
        String[] newFirstNames = Arrays.copyOf(firstNames, firstNames.length + 1);
        newFirstNames[newFirstNames.length - 1] = name;
        return newFirstNames;
    }
    public static String find(final String fullName) {
        for (String name : names) {
            if (name.equalsIgnoreCase(fullName)) {
                return fullName;
            }
        }
        return null;
    }

    public static boolean add(final String fullName) {
        if (find(fullName) != null) {
            return false;
        }
        String[] newNames = Arrays.copyOf(names, names.length + 1);
        newNames[newNames.length - 1] = fullName;
        names = newNames;

        return true;
    }

    public static void printArray(final String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("| " + array[i] + " ");
        }
    }
}

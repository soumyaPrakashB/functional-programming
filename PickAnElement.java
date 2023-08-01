/*
 * Requirement: Given a list find the first item that starts with the given letter.
 *              Print it if exist, else print not found
 */

import java.util.*;

public class PickAnElement {
    public static void main(String[] args) {
        List<String> friends = List.of("Abc", "Acd", "Bbbc", "Bcd", "Scd", "Sdd");

        String startingLetter = "S";

        Optional<String> foundName = friends.stream().filter(name -> name.startsWith(startingLetter)).findFirst();

        System.out.println(
                String.format("A name starting with letter %s: %s", startingLetter, foundName.orElse("No name found")));

        // Optional variable can also process a lambda expression if only the value is
        // present
        foundName.ifPresent(name -> System.out.println("Hello " + name));

        /*
         * Optional: It was introduced in version 1.8 to act as state-appointed null
         * deodorizer (Bravo, Venkat Subramanian)
         * Methods Present:
         * 1. isPresnt -> returns true if value is present else false
         * 2. get -> return the value else throw NoSuchElementException
         * 3. orElse(Object other) -> returns the value if present, or else return the
         * default value
         * 4. ifPresent(Consumer) -> consume the value if present otherwise do nothing
         * 5. orElseGet(Supplier) -> returns the value if present else invoke the
         * supplier and return the result
         * 6. orElseThrow() -> Return the contained value, if present, otherwise throw
         * an exception to be created by the provided supplier.
         */
    }
}

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;

public class Lambda {

    public static Predicate<String> startsWith(String ch) {
        return name -> name.startsWith(ch);
    }

    public static void main(String[] args) {
        List<String> friends = List.of("Abc", "Acd", "Bbbc", "Bcd", "Scd", "Sdd");

        // filtering names with starting letter A using enhanced for loop
        /*
         * List<String> filteredList = new ArrayList<String>();
         * 
         * for (String name : friends) {
         * if (name.startsWith("A")) {
         * filteredList.add(name);
         * }
         * }
         * 
         * System.out.println(filteredList);
         */

        // using Lambda expressions
        /*
         * List<String> filteredListStartWithA = friends.stream().filter(name ->
         * name.startsWith("A")).toList();
         * 
         * List<String> filteredListStartWithB = friends.stream().filter(name ->
         * name.startsWith("B")).toList();
         * 
         * System.out.println(filteredListStartWithA);
         * System.out.println(filteredListStartWithB);
         */

        // The above code leads to code duplication. We can create a higher-order
        // function which will return a Predicate, and will take the starting letter as
        // a parameter
        /*
         * List<String> startWithA = friends.stream().filter(startsWith("A")).toList();
         * List<String> startWithB = friends.stream().filter(startsWith("B")).toList();
         * 
         * System.out.println(startWithA);
         * System.out.println(startWithB);
         */

        // We can do better to limit the scope and eliminate the static method with the
        // help of a Function<> functional interface
        /*
         * final Function<String, Predicate<String>> checkIfStartsWith =
         * (String letter) -> {
         * Predicate<String> testStartLetter = (String name) -> name.startsWith(letter);
         * 
         * return testStartLetter;
         * };
         */

        // The above piece of code can be refactored to the below
        /*
         * final Function<String, Predicate<String>> checkIfStartsWith = (String letter)
         * -> {
         * return (String name) -> name.startsWith(letter);
         * };
         */
        // Could be further refactored to below
        final Function<String, Predicate<String>> checkIfStartsWith = letter -> name -> name.startsWith(letter);

        List<String> startsWithA = friends.stream().filter(checkIfStartsWith.apply("A")).toList();
        List<String> startsWithB = friends.stream().filter(checkIfStartsWith.apply("B")).toList();
        System.out.println(startsWithA);
        System.out.println(startsWithB);

    }
}

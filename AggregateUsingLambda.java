import java.util.*;

/*
Aggregation using lambda expressions: The below example covers when we need to do some operations which requires
reducing the collection to one single value or comparing one value against another in the collection (sum/min/max/avg)
 */
public class AggregateUsingLambda {

    public static void main(String[] args) {
        List<String> friends = List.of("Abcd", "Acd", "Bbc", "Bcd", "Scdef", "Sdd");

        //find the total number of characters in the friends list
        int totalNoOfCharacters = friends.stream().mapToInt(name -> name.length()).sum();

        System.out.printf("Total number of characters: %s%n", totalNoOfCharacters);

        //mapToInt will return an IntStream (int specialized stream), then the sum method will reduce it to a total sum
        //similarly, we can use max, min, average, sorted, etc. to reduce the IntStream
        //-----------

        //Let's find the longest name in the list, if there are multiple we will return the first one in the list
        //We can achieve it using the reduce() method in the stream
        //The reduce method takes a BinaryOperator functional interface as an argument.
        //BinaryOperator is a special case of BiFunction where both the input arguments and the output argument is of the same type

        Optional<String> longestName = friends.stream().reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);

        longestName.ifPresent(name -> System.out.println(String.format("Longest name in the list: %s", name)));

    }
}

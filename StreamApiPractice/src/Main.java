import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //írjuk ki az összes elemet
        integers.stream()
                .forEach(item -> System.out.println(item));

        //írjuk ki a páros elemeket
        integers.stream()
                .filter(item -> item % 2 == 0)
                .forEach(item -> System.out.println(item));

        //készítsünk egy listát csak a páros elemekkel
        List<Integer> evenNumbers = integers.stream()
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList());

        //készítsünk egy listát a számok négyzetével
        List<Integer> squaredNumbers = integers.stream()
                .map(item -> item * item)
                .collect(Collectors.toList());


        List<String> names = List.of(
                "Rincewind",
                "Esmerelda Weatherwax",
                "Susan Sto Helit",
                "Magrat Garlick",
                "Luggage",
                "Gaspode",
                "Agnes Nitt",
                "Eskarina Smith",
                "Death",
                "Grim Squeaker",
                "Tiffany Aching");

        //készítsünk egy listát a magánhagzóval kezdődő keresztnevekből, ABC sorrendbe téve őket

        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'Y'};

        Arrays.asList(vowels).forEach(item -> System.out.println(item));
        Arrays.asList(vowels).forEach(item -> System.out.println(item.toString()));
        System.out.println("\n");


        List<String> vowelFirstLetter = names.stream()
                .filter(item -> Arrays.binarySearch(vowels, item.charAt(0)) >= 0)
                .sorted()
                .collect(Collectors.toList());

        names.stream()
        .filter(item -> Arrays.asList(vowels).contains(item.charAt(0)));
        //.forEach(item -> System.out.println(item));
        //.collect(Collectors.toList());

        //írjuk ki, hány karakternek van vezetékneve
        System.out.println(
                names.stream()
                        .filter(item -> item.contains(" "))
                        .count());
    }
}

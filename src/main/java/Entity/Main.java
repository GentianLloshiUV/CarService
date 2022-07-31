package Entity;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarServiceImpl();
        carService.addToManufacturer();

        carService.allModelList().forEach(model -> System.out.println(model));
        System.out.println("------------------------");
        carService.allCarList().forEach(car -> System.out.println(car));
        System.out.println("------------------------");
        carService.allManufacturerNames().forEach(s -> System.out.println(s));
        System.out.println("------------------------");
//       carService.manufacturerNamesAndYears().forEach((s, integer) -> System.out.println(s + " : " + integer));
        //printim i rradhitur asc order
        carService.manufacturerNamesAndYears().entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry));
        System.out.println("------------------------");
        //printim ne reverse order
        carService.manufacturerNamesAndYears().entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry));
        System.out.println("------------------------");
        //printim pa dublicate
        carService.allModelNames().stream().distinct().collect(Collectors.toList()).forEach(s -> System.out.println(s));
        System.out.println("------------------------");
        carService.modelNamesAndYearOfStartingProduction().forEach((s, integer) -> System.out.println(s + " : " + integer));

        System.out.println("------------------------");
        carService.allCarNames().forEach(s -> System.out.println(s));

        System.out.println("------------------------");
        System.out.println("------------------------");
        carService.modelsWithEvenYearOfProductionStart().forEach((s, integer) -> System.out.println(s + " : " + integer));


    }
}

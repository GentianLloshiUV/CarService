package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CarService {
    List<Manufacturer> allManufacturerList = new ArrayList<>();
    void addToManufacturer();

    List<Model> allModelList();
    List<Car> allCarList();

    List<String>allManufacturerNames();
    Map<String, Integer> manufacturerNamesAndYears();

    List<String>allModelNames();

    Map<String, Integer> modelNamesAndYearOfStartingProduction();
    List<String>allCarNames();

}

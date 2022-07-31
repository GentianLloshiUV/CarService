package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService{
    @Override
    public void addToManufacturer() {
        Car car1 = new Car("Car name1", "Car description1", CarType.CABRIO);
        Car car2 = new Car("Car name2", "Car description2", CarType.COUPE);
        Car car3 = new Car("Car name3", "Car description3", CarType.SEDAN);
        Car car4 = new Car("Car name4", "Car description4", CarType.SEDAN);
        Car car5 = new Car("Car name5", "Car description5", CarType.HATCHBACK);
        Car car6 = new Car("Car name6", "Car description6", CarType.COUPE);

        Model model1 = new Model("Model name1", 1995, List.of(car1,car2));
        Model model2 = new Model("Model name2", 1985, List.of(car1,car2,car3));
        Model model3 = new Model("Model name3", 1976, List.of(car4,car6));
        Model model4 = new Model("Model name4", 2005, List.of(car6,car5));
        Model model5 = new Model("Model name5", 2014, List.of(car1,car5));

        allManufacturerList.add(new Manufacturer("Manufacturer name1", 1994, List.of(model1, model2)));
        allManufacturerList.add(new Manufacturer("Manufacturer name2", 2004, List.of(model3, model4)));
        allManufacturerList.add(new Manufacturer("Manufacturer name3", 1944, List.of(model1, model5)));
        allManufacturerList.add(new Manufacturer("Manufacturer name4", 2014, List.of(model3, model5, model2)));
    }

    @Override
    public List<Model> allModelList() {
        List<Model> output = new ArrayList<>();
        allManufacturerList.stream().forEach(manufacturer -> manufacturer.getModels().forEach(model -> output.add(model)));

        List<Model> prove = allManufacturerList.stream().map(Manufacturer::getModels)
                .flatMap(models -> models.stream())
                .collect(Collectors.toList());

        return prove;
    }

    @Override
    public List<Car> allCarList() {


        return allModelList().stream().map(Model::getCars)
                .flatMap(cars -> cars.stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> allManufacturerNames() {
        return allManufacturerList.stream().map(Manufacturer::getName).
                collect(Collectors.toList());
    }

    @Override
    public Map<String, Integer> manufacturerNamesAndYears() {
        return allManufacturerList.stream().distinct().collect(Collectors.toMap(manufacturer -> manufacturer.getName(),manufacturer -> manufacturer.getYearOfCreation()));
    }

    @Override
    public List<String> allModelNames() {

        return allModelList().stream().map(Model::getName).collect(Collectors.toList());

    }

    @Override
    public Map<String, Integer> modelNamesAndYearOfStartingProduction() {
        return allModelList().stream().distinct().collect(Collectors.toMap(model -> model.getName(),model -> model.getProductionStartYear()));
    }

    @Override
    public List<String> allCarNames() {
        return allCarList().stream().map(Car::getName).collect(Collectors.toList());
    }

    @Override
    public Map<String, Integer> modelsWithEvenYearOfProductionStart() {
        return allModelList().stream().filter(model -> model.getProductionStartYear() %2 == 0).distinct()
                .collect(Collectors.toMap(model -> model.getName(),model -> model.getProductionStartYear()));
    }
}

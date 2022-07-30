package Entity;

import lombok.*;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Model {
    private String name;
    private Integer productionStartYear;
    private List<Car> cars;
}

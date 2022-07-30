package Entity;

import lombok.*;
import lombok.extern.log4j.Log4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Car {
    private String name;
    private String description;
    private CarType carType;

}


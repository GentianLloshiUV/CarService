package Entity;

import lombok.*;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Manufacturer {
    private String name;
    private Integer yearOfCreation;
    private List<Model> models;
}

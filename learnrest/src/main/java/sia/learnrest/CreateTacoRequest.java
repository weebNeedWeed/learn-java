package sia.learnrest;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateTacoRequest {
    private String tacoName;
}

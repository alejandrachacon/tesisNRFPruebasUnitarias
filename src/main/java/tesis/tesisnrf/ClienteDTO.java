package tesis.tesisnrf;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ClienteDTO {
    String name;
    String email;
}

package tesis.tesisnrf;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DataService {

    String typeOfMatter;

    public Object retrieveClient() {
        return null;
    }

    public void setTypeOfMatter(String typeOfMatter) {
        this.typeOfMatter = typeOfMatter;
    }

    public Object getLocation() {

        return null;
    }

    public Object getMatterField() {
        return null;
    }
}

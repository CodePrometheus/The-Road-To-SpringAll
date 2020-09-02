package converter;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private String name;
    private Date bir;

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package mac01.democucthue.model;

import java.io.Serializable;

/**
 * Created by mac01 on 6/26/17.
 */

public class ModelDemoRest implements Serializable{
    private Integer id;
    private String name;
    private String city;


    public ModelDemoRest(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

package model;

import java.util.List;

public class Sandwich {
    private int id;
    private List<String> condiment;

    public Sandwich() {
    }

    public Sandwich(int id, List<String> condiment) {
        this.id = id;
        this.condiment = condiment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getCondiment() {
        return condiment;
    }

    public void setCondiment(List<String> condiment) {
        this.condiment = condiment;
    }
}

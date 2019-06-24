package model;

import java.io.Serializable;

public class Bet implements Serializable {

    private int value;
    private double risk;

    public Bet(int value, double risk) {
        this.value = value;
        this.risk = risk;
    }

    @Override
    public String toString() {
        return "model.Bet{" +
                "value=" + value +
                ", risk=" + risk +
                '}';
    }
}

package ec.edu.espe.managmentsystem.model;

import org.json.JSONObject;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */

public class Debt {

    private double value;
    private double paid;
    private double difference;

    public Debt(double value, double paid) {
        this.value = value;
        this.paid = paid;
        this.difference = value - paid;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
        updateDifference();
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
        updateDifference();
    }

    public double getDifference() {
        return difference;
    }

    private void updateDifference() {
        this.difference = value - paid;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("value", value);
        json.put("paid", paid);
        json.put("difference", difference);
        return json;
    }

    public static Debt fromJson(JSONObject json) {
        double value = json.optDouble("value", 0.0);
        double paid = json.optDouble("paid", 0.0);
        return new Debt(value, paid);
    }
}

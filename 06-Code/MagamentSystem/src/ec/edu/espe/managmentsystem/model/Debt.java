package ec.edu.espe.managmentsystem.model;



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

    
    
}

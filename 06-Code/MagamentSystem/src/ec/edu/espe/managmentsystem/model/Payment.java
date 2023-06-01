package ec.edu.espe.managmentsystem.model;

/**
 *
 * @author Michael Simbana, POO-ERATION-GOSLING, DCCO-ESPE
 */
public class Payment {
    private String wayToPay;
    private int totalValuePerMonth;
    
    public Payment(String wayToPay, int totalValuesPerMonth){
        this.wayToPay = wayToPay;
        this.totalValuePerMonth = totalValuesPerMonth;
  
    }
    
    /**
     * @return the wayToPay
     */
    public String getWayToPay() {
        return wayToPay;
    }

    /**
     * @param wayToPay the wayToPay to set
     */
    public void setWayToPay(String wayToPay) {
        this.wayToPay = wayToPay;
    }

    /**
     * @return the totalValuePerMonth
     */
    public int getTotalValuePerMonth() {
        return totalValuePerMonth;
    }

    /**
     * @param totalValuePerMonth the totalValuePerMonth to set
     */
    public void setTotalValuePerMonth(int totalValuePerMonth) {
        this.totalValuePerMonth = totalValuePerMonth;
    }

    /**
     * @return the debts
     */

    @Override
    public String toString() {
        return "Payment{" + "wayToPay=" + wayToPay + ", totalValuePerMonth=" + totalValuePerMonth+ '}';
    }
}

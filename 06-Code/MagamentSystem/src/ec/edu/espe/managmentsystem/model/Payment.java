package ec.edu.espe.managmentsystem.model;

import java.util.Scanner;

/**
 *
 * @author Michael Simbana, POO-ERATION-GOSLING, DCCO-ESPE
 */
public class Payment {
    private String wayToPay;
    private int totalValuePerMonth;
    
    public void controlStudentsMenu(){
        
        Scanner optionIn = new Scanner(System.in);
        
        int opc =0;
        
        while(opc!=2){
            System.out.println("------- Pagos------\n");
            System.out.println("1. Agregar un Nuevo Pago\n");
            System.out.println("2. Agregar Deuda\n");
            System.out.println("Ingrese una Opcion: ");
            opc = optionIn.nextInt();
            switch(opc){
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Insert a valid option");
                    break;
            }
        }
    }
    
    
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

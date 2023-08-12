package ec.edu.espe.managmentsystem.model;

import ec.edu.espe.managamentsystem.controller.PaymentRecord;

/**
 *
 * @author Michael Simbana, POO-ERATION-GOSLING, DCCO-ESPE
 */
public class Payment {

    public String id;
    private String nombre;
    private double pagoMensual;
    private double valorPagado;
    private double valorRestante;

    public Payment(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    public Payment(String id, double valorPagado) {
        this.id = id;
        this.valorPagado = valorPagado;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the pagoMensual
     */
    public double getPagoMensual() {
        return pagoMensual;
    }

    /**
     * @param pagoMensual the pagoMensual to set
     */
    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    /**
     * @return the valorPagado
     */
    public double getValorPagado() {
        return valorPagado;
    }

    /**
     * @param valorPagado the valorPagado to set
     */
    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    /**
     * @return the valorRestante
     */
    public double getValorRestante() {
        return valorRestante;
    }

    /**
     * @param valorRestante the valorRestante to set
     */
    public void setValorRestante(double valorRestante) {
        this.valorRestante = valorRestante;
    }

}

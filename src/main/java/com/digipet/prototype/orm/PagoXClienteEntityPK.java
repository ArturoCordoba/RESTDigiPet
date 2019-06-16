package com.digipet.prototype.orm;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PagoXClienteEntityPK implements Serializable {
    private int idCliente;
    private String metodoPago;

    @Column(name = "Id_cliente", nullable = false)
    @Id
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Column(name = "Metodo_pago", nullable = false, length = 30)
    @Id
    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagoXClienteEntityPK that = (PagoXClienteEntityPK) o;
        return idCliente == that.idCliente &&
                Objects.equals(metodoPago, that.metodoPago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, metodoPago);
    }
}

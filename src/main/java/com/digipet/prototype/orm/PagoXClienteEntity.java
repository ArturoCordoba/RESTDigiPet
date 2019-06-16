package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PAGO_X_CLIENTE", schema = "digipet")
public class PagoXClienteEntity {
    private String metodoPago;
    private ClienteEntity cliente;

    @Id
    @Column(name = "Metodo_pago")
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
        PagoXClienteEntity that = (PagoXClienteEntity) o;
        return Objects.equals(metodoPago, that.metodoPago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metodoPago);
    }

    @ManyToOne
    @JoinColumn(name = "Id_cliente", referencedColumnName = "Id_cliente", nullable = false)
    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}

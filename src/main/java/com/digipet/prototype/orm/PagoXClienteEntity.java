package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PAGO_X_CLIENTE", schema = "digipet", catalog = "")
@IdClass(PagoXClienteEntityPK.class)
public class PagoXClienteEntity {
    private int idCliente;
    private String metodoPago;
    private ClienteEntity clienteByIdCliente;

    @Id
    @Column(name = "Id_cliente")
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

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
        return idCliente == that.idCliente &&
                Objects.equals(metodoPago, that.metodoPago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, metodoPago);
    }

    @ManyToOne
    @JoinColumn(name = "Id_cliente", referencedColumnName = "Id_cliente", nullable = false)
    public ClienteEntity getClienteByIdCliente() {
        return clienteByIdCliente;
    }

    public void setClienteByIdCliente(ClienteEntity clienteByIdCliente) {
        this.clienteByIdCliente = clienteByIdCliente;
    }
}

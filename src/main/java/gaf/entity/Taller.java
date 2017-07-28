package gaf.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@Table(name = "Talleres")
public class Taller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @Size(min = 1, max = 255)
    private String address;

    @Size(min = 1, max = 20)
    @Column(name = "primary_phone")
    private String primaryPhone;

    @Size(min = 1, max = 20)
    @Column(name = "secondary_phone")
    private String secondaryPhone;

    @NotNull
    @Column(name = "quantity_employees")
    private Integer quantityEmployees;

    /*@NotNull
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "Estados")
    private Estado idEstado;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public Integer getQuantityEmployees() {
        return quantityEmployees;
    }

    public void setQuantityEmployees(Integer quantityEmployees) {
        this.quantityEmployees = quantityEmployees;
    }
/*
    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }*/
}

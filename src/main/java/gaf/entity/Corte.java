package gaf.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "Cortes")
public class Corte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "clothes_quantity")
    private Integer clothesQuantity;

    @NotNull
    @Column(name = "first_due_date")
    private Date firstDueDate;

    @NotNull
    @Column(name = "second_due_date")
    private Date secondDueDate;

    @NotNull
    private Double price;

    @NotNull
    @Column(name = "taller")
    private Long tallerId;

    @NotNull
    @Column(name = "from_size")
    private Double fromSize;

    @NotNull
    @Column(name = "to_size")
    private Double toSize;

    @Column(name = "hoja_de_corte")
    private String hojaDeCorte;

    @NotNull
    @Column(name = "estado")
    private Integer estadoId;

    @Column(name = "comments")
    private String comments;

    @NotNull
    @Column(name = "clothes_delivered")
    private Integer clothesDelivered;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClothesQuantity() {
        return clothesQuantity;
    }

    public void setClothesQuantity(Integer clothesQuantity) {
        this.clothesQuantity = clothesQuantity;
    }

    public Date getFirstDueDate() {
        return firstDueDate;
    }

    public void setFirstDueDate(Date firstDueDate) {
        this.firstDueDate = firstDueDate;
    }

    public Date getSecondDueDate() {
        return secondDueDate;
    }

    public void setSecondDueDate(Date secondDueDate) {
        this.secondDueDate = secondDueDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getTallerId() {
        return tallerId;
    }

    public void setTallerId(Long tallerId) {
        this.tallerId = tallerId;
    }

    public Double getFromSize() {
        return fromSize;
    }

    public void setFromSize(Double fromSize) {
        this.fromSize = fromSize;
    }

    public Double getToSize() {
        return toSize;
    }

    public void setToSize(Double toSize) {
        this.toSize = toSize;
    }

    public String getHojaDeCorte() {
        return hojaDeCorte;
    }

    public void setHojaDeCorte(String hojaDeCorte) {
        this.hojaDeCorte = hojaDeCorte;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getClothesDelivered() {
        return clothesDelivered;
    }

    public void setClothesDelivered(Integer clothesDelivered) {
        this.clothesDelivered = clothesDelivered;
    }
}

package br.com.devleo.contagora.models;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.devleo.contagora.models.enums.PaymentStatus;

@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Instant moment;
    private Double paymentPrice;
    private Integer paymentInstallments;
    private Integer paymentStatus;
    @ManyToOne
    @JoinColumn(name = "client_ID")
    private User client;

    public Payments() {
    }

    public Payments(Long id, String description, Instant moment,
            Double paymentPrice,
            Integer paymentInstallments,
            PaymentStatus paymentStatus,
            User client) {
        this.id = id;
        this.description = description;
        this.moment = moment;
        this.paymentPrice = paymentPrice;
        this.paymentInstallments = paymentInstallments;
        this.paymentStatus = paymentStatus.getCode();
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Double getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(Double paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public Integer getPaymentInstallments() {
        return paymentInstallments;
    }

    public void setPaymentInstallments(Integer paymentInstallments) {
        this.paymentInstallments = paymentInstallments;
    }

    public PaymentStatus getPaymentStatus() {
        return PaymentStatus.valueOf(paymentStatus);
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}

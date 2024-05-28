package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payments extends BaseModel {

private  String referenceNo;
private  int amount;
    @Enumerated(EnumType.ORDINAL)
private PaymentStatus paymentStatus;
    @Enumerated(EnumType.ORDINAL)
private PaymentProvider paymentProvider;
}

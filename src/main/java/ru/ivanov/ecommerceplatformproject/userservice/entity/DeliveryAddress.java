package ru.ivanov.ecommerceplatformproject.userservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "delivery-addresses")
public class DeliveryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "city", nullable = false)
    private String city; //todo можно сделать как отдельную сущность тк городов не много и они будут одинаковыми

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt = Instant.now();

    public DeliveryAddress(String city, String street, String postalCode) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }
}

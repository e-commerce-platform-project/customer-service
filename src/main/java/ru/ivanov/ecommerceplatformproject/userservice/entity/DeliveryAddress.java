package ru.ivanov.ecommerceplatformproject.userservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import java.time.Instant;
import java.util.UUID;

//@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
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

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "city", nullable = false)
    private String city; //todo можно сделать как отдельную сущность тк городов не много и они будут одинаковыми

    @Column(name = "street", nullable = false)
    private String street; // улица, дом, квартира

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt = Instant.now();

    public DeliveryAddress(UUID userId, String fullName, String phone, String city, String street, String postalCode) {
        this.userId = userId;
        this.fullName = fullName;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }
}

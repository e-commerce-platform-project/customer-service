package ru.ivanov.ecommerceplatformproject.userservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Setter
@Getter
@Entity
@Table(name = "addresses", schema = "user")
public class Address extends BaseEntity {

    @Size(max = 128)
    @Column(name = "address", nullable = false, length = 128)
    private String address;

    @Size(max = 32)
    @Column(name = "zip_code", nullable = false, length = 32)
    private String zipCode;

    @Size(max = 128)
    @Column(name = "city", nullable = false, length = 128)
    private String city;


}

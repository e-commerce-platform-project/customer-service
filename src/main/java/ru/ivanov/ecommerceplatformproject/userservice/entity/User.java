package ru.ivanov.ecommerceplatformproject.userservice.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import ru.ivanov.ecommerceplatformproject.userservice.entity.enums.UserStatus;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Getter
@Setter
@Entity
@Table(name = "users", schema = "user")
public class User extends BaseEntity {

    @Size(max = 1024)
    @Column(name = "email", nullable = false, unique = true, length = 1024)
    private String email;

    @Size(max = 64)
    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Size(max = 64)
    @Column(name = "last_name", nullable = false, length = 64)
    private String lastName;

    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "status", nullable = false)
    private UserStatus status = UserStatus.UNVERIFIED;
}
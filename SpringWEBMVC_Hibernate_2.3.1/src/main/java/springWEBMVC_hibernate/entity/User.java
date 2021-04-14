package springWEBMVC_hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The name must not be empty")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "The second name must not be empty")
    @Column(name = "secondName")
    private String secondName;
}

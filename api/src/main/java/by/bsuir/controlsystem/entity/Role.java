package by.bsuir.controlsystem.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role")
    private String role;
}

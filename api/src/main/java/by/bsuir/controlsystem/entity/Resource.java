package by.bsuir.controlsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "resource")
@Data
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "topic")
    private String topic;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;


}

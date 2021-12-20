package by.bsuir.controlsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int id;

    @Column(name = "order_date_time")
    private LocalDate orderDateTime;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @Column(name = "status")
    private TicketStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

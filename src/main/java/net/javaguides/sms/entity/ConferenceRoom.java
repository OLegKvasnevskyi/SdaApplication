package net.javaguides.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "conferenceroom")
public class ConferenceRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conferenceroom_id", nullable = false)
    private Integer id;
    @NotBlank(message = "Conference room's name is mandatory")
    @Size(min = 2, max = 20)
    @Column(name = "name", nullable = false)
    private String name;
    private String identifier;
    private String levelStatus;
    private Boolean availability;
    @Column(name = "numberofseats", nullable = false)
    private Integer numberOfSeats;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Organization organization;
/*
    @ManyToMany(mappedBy = "reservations")
    private List<ReservationEntity> reservations;
        /*
            @OneToMany(mappedBy = "conferenceRoom", cascade = CascadeType.ALL, orphanRemoval = true)
            private List<EquipmentEntity> equipments;
        */
    public ConferenceRoom(String name) {  this.name = name; }
}
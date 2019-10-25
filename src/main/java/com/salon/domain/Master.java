package com.salon.domain;

//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@Table
public class Master extends Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(name = "master_specialization"
            ,joinColumns = @JoinColumn(name = "master_id")
            ,inverseJoinColumns = @JoinColumn(name="specialization_id"/*,referencedColumnName = "specialization_id"*/))
    private Set<Specialization> specializations=new HashSet<>();



//    @OneToMany(mappedBy = "master")
//    private List<Appointment>appointments=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

//    public List<Appointment> getAppointments() {
//        return appointments;
//    }
//
//    public void setAppointments(List<Appointment> appointments) {
//        this.appointments = appointments;
//    }
}

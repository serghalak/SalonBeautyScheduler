package com.salon.domain;


//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table
public class Specialization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Column
    private String specialiazationName;


    @ManyToMany
    @JoinTable(name="master_specialization"
            ,joinColumns = @JoinColumn(name = "specialization_id"/*,referencedColumnName = "id"*/)
            ,inverseJoinColumns = @JoinColumn(name="master_id"/*,referencedColumnName = "id"*/))
    private Set<Master> masters=new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialiazationName() {
        return specialiazationName;
    }

    public void setSpecialiazationName(String specialiazationName) {
        this.specialiazationName = specialiazationName;
    }

    public Set<Master> getMasters() {
        return masters;
    }

    public void setMasters(Set<Master> masters) {
        this.masters = masters;
    }
}
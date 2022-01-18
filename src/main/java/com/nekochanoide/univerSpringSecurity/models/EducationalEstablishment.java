package com.nekochanoide.univerSpringSecurity.models;

import javax.persistence.*;

@Entity
@Table(name = "educational_establishments")
public class EducationalEstablishment {
    @Id
    @GeneratedValue
    private long id;
    private String number;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public EducationalEstablishment() {
    }

    public EducationalEstablishment(String number, Address address) {
        this.number = number;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

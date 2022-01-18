package com.nekochanoide.univerSpringSecurity.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "parents_couples")
public class ParentsCouple {
    @Id
    @GeneratedValue
    private long id;
    private String dadFullName;
    private String momFullName;
    @OneToMany(mappedBy = "parentsCouple", cascade = CascadeType.ALL)
    private List<Child> children;
    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;

    public ParentsCouple() {
    }

    public ParentsCouple(String dadFullName, String momFullName) {
        setDadFullName(dadFullName);
        setMomFullName(momFullName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDadFullName() {
        return dadFullName;
    }

    public void setDadFullName(String dadFullName) {
        if (!Objects.equals(dadFullName, "")) {
            this.dadFullName = dadFullName;
        }
    }

    public String getMomFullName() {
        return momFullName;
    }

    public void setMomFullName(String momFullName) {
        if (!Objects.equals(momFullName, "")) {
            this.momFullName = momFullName;
        }
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

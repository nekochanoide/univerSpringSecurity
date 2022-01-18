package com.nekochanoide.univerSpringSecurity.models;

import javax.persistence.*;

@Entity
@Table(name = "children")
public class Child {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "parents_couple_id")
    private ParentsCouple parentsCouple;
    private String fullName;
    private int age;
    @ManyToOne
    @JoinColumn(name = "educational_establishment_id")
    private EducationalEstablishment educationalEstablishment;

    public Child() {
    }

    public Child(ParentsCouple parentsCouple, String fullName, int age) {
        this.parentsCouple = parentsCouple;
        this.fullName = fullName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ParentsCouple getParentsCouple() {
        return parentsCouple;
    }

    public void setParentsCouple(ParentsCouple parentsCouple) {
        this.parentsCouple = parentsCouple;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public EducationalEstablishment getEducationalEstablishment() {
        return educationalEstablishment;
    }

    public void setEducationalEstablishment(EducationalEstablishment educationalEstablishment) {
        this.educationalEstablishment = educationalEstablishment;
    }
}

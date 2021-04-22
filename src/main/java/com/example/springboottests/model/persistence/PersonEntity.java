package com.example.springboottests.model.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("person")
public class PersonEntity {
    @Id
    @Column("id")
    private Long id;
    @Column("first_name")
    private String first_name;
    @Column("last_name")
    private String last_name;

    public PersonEntity() {
    }

    public PersonEntity(Long id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(first_name, that.first_name) && Objects.equals(last_name, that.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name);
    }
}

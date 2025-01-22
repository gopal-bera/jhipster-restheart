package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mycompany.myapp.json.ObjectIdToStringDeserializer;
import com.mycompany.myapp.json.StringToObjectIdSerializer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = StringToObjectIdSerializer.class)
    @JsonDeserialize(using = ObjectIdToStringDeserializer.class )
    @JsonProperty("_id")
    @Field("_id")
    private String id;

    @Field("name")
    private String name;

    @Field("location")
    private String location;

    @Field("university")
    private String university;

    @DBRef
    @Field("students")
    @JsonIgnoreProperties(value = { "departments" }, allowSetters = true)
    private Set<Student> students = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public Department id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Department name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public Department location(String location) {
        this.setLocation(location);
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUniversity() {
        return this.university;
    }

    public Department university(String university) {
        this.setUniversity(university);
        return this;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Department students(Set<Student> students) {
        this.setStudents(students);
        return this;
    }

    public Department addStudent(Student student) {
        this.students.add(student);
        student.getDepartments().add(this);
        return this;
    }

    public Department removeStudent(Student student) {
        this.students.remove(student);
        student.getDepartments().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Department)) {
            return false;
        }
        return id != null && id.equals(((Department) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Department{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", location='" + getLocation() + "'" +
            ", university='" + getUniversity() + "'" +
            "}";
    }
}

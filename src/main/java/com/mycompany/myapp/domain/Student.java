package com.mycompany.myapp.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mycompany.myapp.json.ObjectIdToStringDeserializer;
import com.mycompany.myapp.json.StringToObjectIdSerializer;


@Document(collection = "student")
@Data   
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = StringToObjectIdSerializer.class)
    @JsonDeserialize(using = ObjectIdToStringDeserializer.class )
    @JsonProperty("_id")
    @Field("_id")
    private String id;

    @Field("name")
    private String name;

    @Field("stream")
    private String stream;

    @Field("course")
    private String course;

    @Field("percentage")
    private Float percentage;

    @Field("departments")
    List<RefType> departments = new ArrayList<>();

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
   
    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public Student id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Student name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStream() {
        return this.stream;
    }

    public Student stream(String stream) {
        this.setStream(stream);
        return this;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getCourse() {
        return this.course;
    }

    public Student course(String course) {
        this.setCourse(course);
        return this;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Float getPercentage() {
        return this.percentage;
    }

    public Student percentage(Float percentage) {
        this.setPercentage(percentage);
        return this;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    

    public List<RefType> getDepartments() {
        return this.departments;
    }

    public void setDepartments(List<RefType> departments) {
        this.departments = departments;
    }

    public Student departments(List<RefType> departments) {
        this.setDepartments(departments);
        return this;
    }
    

    // public Student addDepartment(Department department) {
    //     this.departments.add(department);
    //     department.getStudents().add(this);
    //     return this;
    // }

    // public Student removeDepartment(Department department) {
    //     this.departments.remove(department);
    //     department.getStudents().remove(this);
    //     return this;
    // }

    // // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        return id != null && id.equals(((Student) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Student{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", stream='" + getStream() + "'" +
            ", course='" + getCourse() + "'" +
            ", percentage=" + getPercentage() +
            "}";
    }
}

package com.mycompany.myapp.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mycompany.myapp.json.ObjectIdToStringDeserializer;
import com.mycompany.myapp.json.StringToObjectIdSerializer;



@Document(collection = "student1")
public class Student1 {

    // @Id
    @JsonSerialize(using = StringToObjectIdSerializer.class)
    @JsonDeserialize(using = ObjectIdToStringDeserializer.class )
    @JsonProperty("_id")
    @Field("_id")
    private String id;
    private String name;
    private String stream;
    private String course;
    private String percentage;

    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStream() {
        return stream;
    }
    public void setStream(String stream) {
        this.stream = stream;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public String getPercentage() {
        return percentage;
    }
    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
    

    public Student1() {
    }
    
    public Student1(String id, String name, String stream, String course, String percentage) {
        this.id = id;
        this.name = name;
        this.stream = stream;
        this.course = course;
        this.percentage = percentage;
    }
    @Override
    public String toString() {
        return "Student1 [id=" + id + ", name=" + name + ", stream=" + stream + ", course=" + course + ", percentage="
                + percentage + "]";
    }

}

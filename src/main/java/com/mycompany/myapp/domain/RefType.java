package com.mycompany.myapp.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mycompany.myapp.json.ObjectIdToStringDeserializer;
import com.mycompany.myapp.json.StringToObjectIdSerializer;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represent Database Reference / Foreign Key to
 * {@link #getRef()} collection...
 */
@Data
@NoArgsConstructor
public class RefType implements Serializable {

    private static final long serialVersionUID = 1L;

    public static enum RefTo {
        Post, User, Comment
    }


    @JsonSerialize(using = StringToObjectIdSerializer.class)
    @JsonDeserialize(using = ObjectIdToStringDeserializer.class )
    @JsonProperty("_id")
    @Field("_id")
    private String id;

    @JsonProperty("_ref")
    @Field("_ref")
    private String ref;

    public RefType (ObjectId id, RefTo refTo) {
        setId(id.toHexString());
        setRef(refTo.name());
    }

   public RefType(String id, RefTo refTo) {
        setId(new ObjectId(id).toString()); // Convert String to ObjectId
        setRef(refTo.name());
    }


    public String toString() {
        ToStringBuilder tsb = new ToStringBuilder(this);
        tsb.append("ref", ref);
        tsb.append("id",id);
        return tsb.toString();
    }
}

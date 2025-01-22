package com.mycompany.myapp.json;

import java.io.IOException;
import java.time.Instant;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoDate2StringDeserializer extends JsonDeserializer<String> {

    private static final Logger LOG = LoggerFactory.getLogger(MongoDate2StringDeserializer.class);

    @Override
    public String deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        if (node == null) {
            return null;
        }
        LOG.debug("MongoDate2StringDeserializer Got node : {}", node.toString());
        
        if (node.get("$date") == null) {
            if (node.isValueNode()) {
                return node.asText();
            }
            return null;
        }
        else {
            Instant instant = Instant.ofEpochMilli(node.get("$date").asLong());
            return instant.toString();
        }
    }
    
}

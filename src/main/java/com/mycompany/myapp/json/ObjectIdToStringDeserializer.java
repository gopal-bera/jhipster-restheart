package com.mycompany.myapp.json;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class ObjectIdToStringDeserializer extends JsonDeserializer<String>{
	
	private static final Logger LOG = LoggerFactory.getLogger(ObjectIdToStringDeserializer.class);


	@Override
	public String deserialize(JsonParser jp, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);
		if (node == null) {
            return null;
        }
		LOG.debug("ObjectIDDeserializer Got node : {}", node.toString());
		if(node.get("$oid") == null){
			return null;
		}
		else{
			return node.get("$oid").asText();
		}
	}

}

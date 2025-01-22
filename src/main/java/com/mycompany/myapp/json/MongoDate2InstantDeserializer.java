package com.mycompany.myapp.json;

import java.io.IOException;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class MongoDate2InstantDeserializer extends JsonDeserializer<Instant>{
	
	private static final Logger LOG = LoggerFactory.getLogger(MongoDate2InstantDeserializer.class);


	@Override
	public Instant deserialize(JsonParser jp, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);
		if (node == null) {
            return null;
        }
		LOG.debug("MongoDate2InstantDeserializer Got node : {}", node.toString());
		if(node.get("$date") == null){
			return null;
		}
		else{
			return Instant.ofEpochMilli(node.get("$date").asLong());
		}
	}
}

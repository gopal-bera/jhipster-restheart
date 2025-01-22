package com.mycompany.myapp.json;

import java.io.IOException;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class Instant2MongoDateSerializer extends JsonSerializer<Instant>{
	
	private static final Logger LOG = LoggerFactory.getLogger(Instant2MongoDateSerializer.class);


	@Override
	public void serialize(Instant value, JsonGenerator jsonGen, SerializerProvider serializers) throws IOException {
		LOG.debug("Instant2MongoDateSerializer : {}", value);
		if(value == null ){
			jsonGen.writeNull();
		}else{
			jsonGen.writeStartObject();
			jsonGen.writeNumberField("$date", value.toEpochMilli());
			jsonGen.writeEndObject();
		}		
	}

}

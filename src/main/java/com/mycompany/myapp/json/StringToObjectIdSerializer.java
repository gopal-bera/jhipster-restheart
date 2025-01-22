package com.mycompany.myapp.json;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class StringToObjectIdSerializer extends JsonSerializer<String>{
	
	private static final Logger LOG = LoggerFactory.getLogger(StringToObjectIdSerializer.class);


	@Override
	public void serialize(String value, JsonGenerator jsonGen, SerializerProvider serializers) throws IOException {
		LOG.debug("serialise : {}", value);
		if(value == null ){
			jsonGen.writeNull();
		}else{
			jsonGen.writeStartObject();
			jsonGen.writeStringField("$oid", value.toString());
			jsonGen.writeEndObject();
		}		
	}

}

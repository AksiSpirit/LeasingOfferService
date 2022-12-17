package ru.aksi.server.model.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.aksi.server.model.Stuff;

import java.io.IOException;

public class StuffSerializer extends StdSerializer<Stuff> {
    public StuffSerializer() {
        super(Stuff.class);
    }
    @Override
    public void serialize(Stuff value, JsonGenerator gen, SerializerProvider sp) throws IOException, JsonProcessingException {
        gen.writeString(value.getId().toString());
    }
}
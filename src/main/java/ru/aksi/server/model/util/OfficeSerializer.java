package ru.aksi.server.model.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.aksi.server.model.Office;

import java.io.IOException;

public class OfficeSerializer extends StdSerializer<Office> {
    public OfficeSerializer() {
        super(Office.class);
    }
    @Override
    public void serialize(Office value, JsonGenerator gen, SerializerProvider sp) throws IOException, JsonProcessingException {
        gen.writeString(value.getId().toString());
    }
}

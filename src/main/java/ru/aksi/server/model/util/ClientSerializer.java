package ru.aksi.server.model.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.aksi.server.model.Client;

import java.io.IOException;

public class ClientSerializer extends StdSerializer<Client> {
    public ClientSerializer() {
        super(Client.class);
    }
    @Override
    public void serialize(Client value, JsonGenerator gen, SerializerProvider sp) throws IOException, JsonProcessingException {
        gen.writeString(value.getId().toString());
    }
}
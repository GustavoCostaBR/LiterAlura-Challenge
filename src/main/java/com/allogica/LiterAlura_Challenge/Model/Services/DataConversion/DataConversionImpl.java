package com.allogica.LiterAlura_Challenge.Model.Services.DataConversion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class DataConversionImpl implements DataConversion {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T convertData(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T getSpecificKeyAndConvertData(String json, String nodeName, Class<T> clazz) {
        try {
            JsonNode rootNode = mapper.readTree(json);
            JsonNode modelsNode = rootNode.get(nodeName);
            return mapper.convertValue(modelsNode, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

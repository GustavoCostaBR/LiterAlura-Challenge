package com.allogica.LiterAlura_Challenge.Model.Services.DataConversion;

public interface DataConversion {
    <T> T convertData(String json, Class<T> clazz);

    <T> T getSpecificKeyAndConvertData(String json, String nodeName, Class<T> clazz);

}

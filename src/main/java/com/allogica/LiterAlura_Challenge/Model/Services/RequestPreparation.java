package com.allogica.LiterAlura_Challenge.Model.Services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class RequestPreparation {
    static final String SEARCH = "https://gutendex.com/books/?search=___";


    public String searchRequest(String bookInformation){
        return Request.callApi(SEARCH.replace("___", bookInformation));
    }
}

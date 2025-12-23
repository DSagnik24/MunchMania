package com.sagnik.foodapp_api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagnik.foodapp_api.io.FoodRequest;
import com.sagnik.foodapp_api.io.FoodResponse;
import com.sagnik.foodapp_api.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/foods")
@AllArgsConstructor
public class FoodController {

    private final FoodService foodService;

    public FoodResponse addFood(@RequestPart("food") String foodString,
                                @RequestPart("file")MultipartFile file){
        ObjectMapper objectMapper = new ObjectMapper();
        FoodRequest req = null;
        try{
            objectMapper.readValue(foodString,FoodRequest.class);
        }catch (JsonProcessingException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Json Format");
        }
        FoodResponse response = foodService.addFood(req,file);
        return response;
    }

}

package com.sagnik.foodapp_api.service;

import com.sagnik.foodapp_api.io.FoodRequest;
import com.sagnik.foodapp_api.io.FoodResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FoodService {

    String uploadFile(MultipartFile file);

    FoodResponse addFood(FoodRequest request, MultipartFile file);
}

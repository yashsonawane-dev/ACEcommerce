package com.example.AlgoCampEcom.gateway;


import com.example.AlgoCampEcom.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {

    List<CategoryDTO> getAllCategories() throws IOException;
}

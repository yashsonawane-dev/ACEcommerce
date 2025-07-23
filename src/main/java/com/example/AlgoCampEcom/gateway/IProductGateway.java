package com.example.AlgoCampEcom.gateway;


import com.example.AlgoCampEcom.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {

    ProductDTO getProductById(Long id);
}

package com.example.AlgoCampEcom.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreProductResponseDTO{
	private ProductDTO product;
	private String message;
	private String status;
}

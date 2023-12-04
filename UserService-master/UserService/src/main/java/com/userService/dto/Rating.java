package com.userService.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rating {
	
	private String ratingId;
	private String hotelId;
	private String userId;
	private int rating;
	private String feedBack;
	

}

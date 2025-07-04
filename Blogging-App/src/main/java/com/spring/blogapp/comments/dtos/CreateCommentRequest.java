package com.spring.blogapp.comments.dtos;



import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)	
public class CreateCommentRequest {
	@NonNull
	private String title;
	@NonNull
	private String body;
	
}

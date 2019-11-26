package com.ibm.feedback;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@SpringBootApplication
public class FeedbackApplication {
	
	public static void main(String[] args) {
		
        SpringApplication.run(FeedbackApplication.class, args);
		
    }

	public  FeedbackApplication()
	{
		
	}
	
	
	}

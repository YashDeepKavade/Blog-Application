package in.ls.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ls.bindings.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleRnfe(ResourceNotFoundException rnfe){
		
		String msg=rnfe.getMessage();
		ApiResponse api=new ApiResponse();
		
		
		return new ResponseEntity<ApiResponse>(api,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgumentException(MethodArgumentNotValidException ex){
		
		Map<String ,String> map=new HashMap<String, String>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String field = ((FieldError)error).getField();
			String defaultMessage = error.getDefaultMessage();
			map.put(field, defaultMessage);
		});
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
		
	}
}

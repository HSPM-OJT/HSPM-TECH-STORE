package com.hspm.ojt.domain.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.hspm.ojt.service.MapValidationErrorService;

@Service
public class MapValidationErrorServiceImpl implements MapValidationErrorService {

	@Override
	public ResponseEntity<?> validate(BindingResult bindingResult) {
		// TODO Auto-generated method stub
		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			List<FieldError> errors = bindingResult.getFieldErrors();

			for (final FieldError error : errors) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}

			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
			// return new ResponseEntity<List<FieldError>>(errors,HttpStatus.BAD_REQUEST);

		}
//       BindingResult Interface

//		if(result.hasErrors())
//			return new ResponseEntity<String>("Invalid Passing Arguments",HttpStatus.BAD_REQUEST);
		return null;
	}
	

}

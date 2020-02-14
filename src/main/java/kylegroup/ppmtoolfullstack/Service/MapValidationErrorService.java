package kylegroup.ppmtoolfullstack.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;

@Service
public class MapValidationErrorService {
    public ResponseEntity<?> MapValidationService(BindingResult result){
        HashMap<String, String> errorMap = new HashMap<String, String>();
        for(FieldError error: result.getFieldErrors()){
            errorMap.put(error.getField(), error.getDefaultMessage());
        }
        if(result.hasErrors()){
            return new ResponseEntity<HashMap<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}

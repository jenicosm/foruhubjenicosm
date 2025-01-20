package api.alura.forohub.infra.errores;

import api.alura.forohub.domain.ValidacionException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class TratadorDeErrores {

    @ExceptionHandler (EntityNotFoundException.class)
    public ResponseEntity tratarError404(){return ResponseEntity.notFound().build();}

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity tratarErrorValidacion(ValidacionException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record DatosErrorValidacion(String campo, String mensaje){
        public DatosErrorValidacion (FieldError error){ this(error.getField(), error.getDefaultMessage());}
    }

}

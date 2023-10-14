package com.demo.project.instagram.advise;

import com.demo.project.instagram.exception.AuthorizationException;
import com.demo.project.instagram.exception.PostNotExistException;
import com.demo.project.instagram.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse>
    handleException(HttpServletRequest request, PostNotExistException exception)
    {
      ErrorResponse response = ErrorResponse.builder()
               .statusCode(HttpStatus.UNAUTHORIZED)
               .error(exception.getMessage())
              .exception(exception.getClass())
              .requestUrl(request.getRequestURI())
               .createdAt(Instant.now())
               .build();

      return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request,
                                                                     UserNotFoundException exception)
    {
        ErrorResponse response = ErrorResponse.builder()
                .statusCode(HttpStatus.UNAUTHORIZED)
                .error(exception.getMessage())
                .exception(exception.getClass())
                .requestUrl(request.getRequestURI())
                .createdAt(Instant.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request,
                                                         AuthorizationException exception)
    {
        ErrorResponse response = ErrorResponse.builder()
                .statusCode(HttpStatus.FORBIDDEN)
                .error(exception.getMessage())
                .exception(exception.getClass())
                .requestUrl(request.getRequestURI())
                .createdAt(Instant.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request,
                                                                     Exception exception)
    {
        ErrorResponse response = ErrorResponse.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .error(exception.getMessage())
                .exception(exception.getClass())
                .requestUrl(request.getRequestURI())
                .createdAt(Instant.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ErrorResponse
{
    private HttpStatus statusCode;
    private String error;
    private Instant createdAt;
    private String requestUrl;
    private Class exception;
}
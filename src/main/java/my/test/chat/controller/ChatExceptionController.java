package my.test.chat.controller;

import my.test.chat.exception.ChatException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestControllerAdvice
public class ChatExceptionController {

    @ExceptionHandler(ChatException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> messageNoUniqueName(ChatException exception, WebRequest request) {
        return Map.of("errorcode", "500", "errormessage", exception.getMessage());
    }
}

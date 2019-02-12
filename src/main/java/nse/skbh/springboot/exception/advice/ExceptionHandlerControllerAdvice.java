package nse.skbh.springboot.exception.advice;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import nse.skbh.springboot.exception.entity.ResourceNotFoundException;
import nse.skbh.springboot.exception.entity.ErrorMessage;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value=HttpStatus.FORBIDDEN)
	public @ResponseBody ErrorMessage handleResourceNotFound(final ResourceNotFoundException exception,
			final HttpServletRequest request) {

		ErrorMessage error = new ErrorMessage();
		error.setErrorMessage(exception.getMessage());
		error.setRequestedURI(request.getRequestURI());
		error.setErrorCode(5000);
		error.setTimeStamp(new Date()); 
		return error;
	}

	/*@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorMessage handleException(final RuntimeException exception,
			final HttpServletRequest request) {

		ErrorMessage error = new ErrorMessage();
		error.setErrorMessage(exception.getMessage());
		error.setRequestedURI(request.getRequestURI());
		error.setErrorCode(9999);
		error.setTimeStamp(new Date());
		return error;
	}*/

}

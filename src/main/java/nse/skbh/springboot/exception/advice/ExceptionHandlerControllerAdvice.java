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
/**********************************************
Allows for more concise annotation declarations e.g.: @ControllerAdvice("org.com.pkg.detail")
is equivalent to @ControllerAdvice(basePackages="org.com.pkg.detail").
********************************************************************/
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value=HttpStatus.GATEWAY_TIMEOUT)
	public @ResponseBody ErrorMessage handleResourceNotFound(final ResourceNotFoundException exception,
			final HttpServletRequest request) {

		ErrorMessage error = new ErrorMessage();
		error.setErrorMessage(exception.getMessage());
		error.setRequestedURI(request.getRequestURI());
		error.setErrorCode(5000);
		error.setTimeStamp(new Date()); 
		return error;
	}

	

}

package nse.skbh.springboot.exception.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CommonExceptionMapper {
	@ResponseBody
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	@ExceptionHandler(CommonException.class)
	public ErrorMessage CommonExceptionMapperImpl(CommonException cm) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorMessage(cm.getMessage());
		errorMessage.setErrorCode(503);
		return errorMessage;
	}
}

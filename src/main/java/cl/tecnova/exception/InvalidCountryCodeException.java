package cl.tecnova.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCountryCodeException extends RuntimeException {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCountryCodeException() {
        super("Código invádido de país.");
    }
}
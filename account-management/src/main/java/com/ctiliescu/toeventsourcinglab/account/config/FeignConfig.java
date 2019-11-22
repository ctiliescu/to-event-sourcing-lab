package com.ctiliescu.toeventsourcinglab.account.config;

import com.ctiliescu.toeventsourcinglab.account.model.exceptions.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignConfig implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {

		int httpStatus = response.status();

		return new NotFoundException(response.reason());
	}

}
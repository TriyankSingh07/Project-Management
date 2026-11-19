package com.sts.demo.security;

import java.io.IOException;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.sts.demo.dto.ApiErrorResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.json.JsonMapper;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

	private final JsonMapper jsonMapper;

	public JwtAccessDeniedHandler(JsonMapper jsonMapper) {
		this.jsonMapper = jsonMapper;
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException {
		HttpStatus status = HttpStatus.FORBIDDEN;
		response.setStatus(status.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);

		ApiErrorResponse body = new ApiErrorResponse(Instant.now(), status.value(), status.getReasonPhrase(),
				"Access denied", request.getRequestURI());
		jsonMapper.writeValue(response.getOutputStream(), body);
	}
}

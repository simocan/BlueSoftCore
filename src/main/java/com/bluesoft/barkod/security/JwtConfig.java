package com.bluesoft.barkod.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtConfig {


    @Value("${app.jwt.header}")
    private String header;

    @Value("${app.jwt.prefix}")
    private String prefix;
    
    @Value("${app.jwt.secret}")
    private String secret;
    
    @Value("${app.jwt.expirationInMs}")
    private int expirationInMs;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public int getExpirationInMs() {
		return expirationInMs;
	}

	public void setExpirationInMs(int expirationInMs) {
		this.expirationInMs = expirationInMs;
	}    
    
    
}
package com.learn.JWTAuth.Entity;

public class JwtResponse {
	private String username; // Username field
	private String jwtToken; // JWT Token field

	public JwtResponse(String username, String jwtToken) {
		super();
		this.username = username;
		this.jwtToken = jwtToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

//    // Private constructor to prevent direct instantiation
//    private JwtResponse(Builder builder) {
//        this.username = builder.username;
//        this.jwtToken = builder.jwtToken;
//    }

//    // The Builder class
//    public static class Builder {
//        private String username;
//        private String jwtToken;
//
//        // Setter methods that return the Builder itself
//        public Builder username(String username) {
//            this.username = username;
//            return this;  // Return the builder to allow method chaining
//        }
//
//        public Builder jwtToken(String jwtToken) {
//            this.jwtToken = jwtToken;
//            return this;  // Return the builder to allow method chaining
//        }
//
//        // Build method to create the final JWTResponse object
//        public JwtResponse build() {
//            return new JwtResponse(this);
//        }
//    }
}
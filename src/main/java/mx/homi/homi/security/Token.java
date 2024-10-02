package mx.homi.homi.security;

public class Token {
	private String tokenString;
	
	public Token() {}
	
	public Token(String tokenString) {
		this.tokenString = tokenString;
	}

	public String getTokenString() {
		return tokenString;
	}

	@Override
	public String toString() {
		return "Token [tokenString=" + tokenString + "]";
	}
	

}

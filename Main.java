package encruptedSHA;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String message = "Hello, this is a secret message !";
		
		System.out.println(message);
		String hashMessage = hashSHA(message);
		System.out.println("Hash message: " + hashMessage);
	}
	public static String hashSHA (String message) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hashBytes = digest.digest(message.getBytes(StandardCharsets.UTF_8));
		
		StringBuilder hexString = new StringBuilder();
		for (byte hashByte : hashBytes) {
			String hex = Integer.toHexString(0xff & hashByte);
			if(hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
}

package ky2lab7;

import java.io.File;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

public class DemoRSA {
	
	public static PrivateKey getPrivateKey() throws Exception {
		byte[] keyBytes = Files.readAllBytes(new File(GenerateKeys.PRIVATE_KEY_FILE).toPath());
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}
	
	public static PublicKey getPublicKey() throws Exception {
		byte[] keyBytes = Files.readAllBytes(new File(GenerateKeys.PUBLIC_KEY_FILE).toPath());
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

	public static void main(String[] args) throws Exception {
		PrivateKey privateKey = getPrivateKey();
	    PublicKey publicKey = getPublicKey();
	    
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        
        String original = "This is original data";
        byte[] byteEncrypted = cipher.doFinal(original.getBytes());
        String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);
        
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] byteDecrypted = cipher.doFinal(byteEncrypted);
        String decrypted = new String(byteDecrypted);
        
        System.out.println("Original  text: " + original);
        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
	}

}

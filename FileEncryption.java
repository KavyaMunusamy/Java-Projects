import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.*;

public class FileEncryption {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public static void encryptFile(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }

    public static void decryptFile(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }

    private static void doCrypto(int cipherMode, String key, File inputFile,
                                  File outputFile) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }

    public static void main(String[] args) {
        String key = "ThisIsASecretKey";
        File inputFile = new File("input.txt");
        File encryptedFile = new File("encrypted.txt");
        File decryptedFile = new File("decrypted.txt");

        try {
            encryptFile(key, inputFile, encryptedFile);
            decryptFile(key, encryptedFile, decryptedFile);
            System.out.println("Encryption and decryption completed successfully.");
        } catch (CryptoException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class CryptoException extends Exception {
    public CryptoException() {
    }

    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

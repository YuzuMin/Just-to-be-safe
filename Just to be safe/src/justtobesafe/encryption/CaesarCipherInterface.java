package justtobesafe.encryption;

public interface CaesarCipherInterface {
    public String cc_encrypt(String message,int shift,int shift2);       //Caesar Cipher Encryption
    public String cc_decrypt(String message,int shift,int shift2);       //Caesar Cipher Decryption
}

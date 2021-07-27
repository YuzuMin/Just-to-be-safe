package justtobesafe.encryption;

import java.security.MessageDigest;

public interface SecureHashingAlgorithmInterface {

    public String sha1( String base);       //Secure one-way 160 Bit hash
    public String sha256( String base);     //Secure one-way 256 Bit hash
    public String sha384( String base);     //Secure one-way 384 Bit hash
    public String sha512( String base);     //Secure one-way 512 Bit hash
}

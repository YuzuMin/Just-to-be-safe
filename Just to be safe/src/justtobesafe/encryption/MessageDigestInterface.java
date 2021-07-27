package justtobesafe.encryption;

public interface MessageDigestInterface {
    public String md2( String base);       //Secure one-way 160 Bit has
    public String md5( String base);     //Secure one-way 384 Bit hash
}

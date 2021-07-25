package justtobesafe.encryption;

public interface MessageDigestInterface {
    public String md2( String base);       //Secure one-way 160 Bit hash
    public String md4( String base);     //Secure one-way 256 Bit hash
    public String md5( String base);     //Secure one-way 384 Bit hash
    public String md6( String base);     //Secure one-way 512 Bit hash
}

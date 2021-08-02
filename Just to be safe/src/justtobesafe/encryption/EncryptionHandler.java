package justtobesafe.encryption;

//Java Imports
import java.security.MessageDigest;

public class EncryptionHandler implements SecureHashingAlgorithmInterface,CaesarCipherInterface,MessageDigestInterface  {

    @Override
    public String sha1(String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-1");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String sha256(String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String sha384(String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-384");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String sha512(String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-512");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String cc_encrypt(String message,int shift,int shift2) {
        StringBuilder temp = new StringBuilder();

        for(int i=0; i<message.length(); i++) {
            char c = (char)(message.charAt(i) + shift);

            if(c >= 'x') {
                c = (char)(message.charAt(i) - shift2);
            } else {
                c = (char)(message.charAt(i) + shift);
            }

            temp.append(c);
        }

        return temp.toString();
    }

    @Override
    public String cc_decrypt(String message,int shift,int shift2) {
        StringBuilder temp = new StringBuilder();

        for(int i=0; i<message.length(); i++) {
            char c = (char)(message.charAt(i) - shift);

            if(c > 'x') {
                c = (char)(message.charAt(i) + shift2);
            } else {
                c = (char)(message.charAt(i) - shift);
            }

            temp.append(c);
        }
        return temp.toString();
    }

    @Override
    public String md2(String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("MD2");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String md5(String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("MD5");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

}

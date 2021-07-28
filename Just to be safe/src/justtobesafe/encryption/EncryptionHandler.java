package justtobesafe.encryption;

import java.io.*;
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

    public String readPasswordFile(String file) {
        String currentLine=""; //Init value
        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            currentLine = reader.readLine();    //Obtain value from
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentLine;
    }

    public void writePasswordFile(String file,String passwd) {
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(passwd);

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

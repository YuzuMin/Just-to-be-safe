package justtobesafe.random;

import justtobesafe.encryption.EncryptionHandler;

import java.util.Arrays;
import java.util.List;

public class RandomHandler {
    //Generates Random Password
    EncryptionHandler encryptionHandler=new EncryptionHandler();


    List<String> phoneticAlphabet = Arrays.asList("alpha", "bravo", "charlie","delta","echo","foxtrot","golf","india","juliet","kilo","lima","mike","november","oscar","papa","quebec","romeo","sierra","tango","Uniform","victor","whiskey","xray","yankee","zulu");
    
    List<String> supplierNames = Arrays.asList("sup1", "sup2", "sup3");
    List<String> supplierNames = Arrays.asList("sup1", "sup2", "sup3");
    //System.out.println(supplierNames.get(1));

    public String generateRandomString(String input){

    }
    public String generateRandomPassword(String input){
        String output=input;
        int value1=(int)(Math.random()*(3));
        int value2=(int)(Math.random()*(8));
        int value3=(int)(Math.random()*(3));

        switch(value1){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }

        switch(value2){
            case 0:
                output=encryptionHandler.md2(output);
                break;
            case 1:
                output=encryptionHandler.md4(output);
                break;
            case 2:
                output=encryptionHandler.md5(output);
                break;
            case 3:
                output=encryptionHandler.md6(output);
                break;
            case 4:
                output=encryptionHandler.sha1(output);
                break;
            case 5:
                output=encryptionHandler.sha256(output);
                break;
            case 6:
                output=encryptionHandler.sha384(output);
                break;
            case 7:
                output=encryptionHandler.sha512(output);
                break;
        }

        switch(value3){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }

        return output;
    }
}

package justtobesafe.random;

import justtobesafe.encryption.EncryptionHandler;

import java.util.Arrays;
import java.util.List;

public class RandomHandler {
    EncryptionHandler encryptionHandler=new EncryptionHandler();

    //Strings for password generation
    private final List<String> phoneticAlphabet = Arrays.asList("alpha", "bravo", "charlie","delta","echo","foxtrot","golf","india","juliet","kilo","lima","mike","november","oscar","papa","quebec","romeo","sierra","tango","Uniform",
            "victor","whiskey","xray","yankee","zulu");
    private final List<String> countries = Arrays.asList("Afghanistan", " Albania", "Algeria","Andorra","Angola","Antigua and Barbuda","Argentina","Armenia","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados",
            "Belarus","Belgium","Belize","Benin","Bhutan","Bolivia","Bosnia and Herzegovina","Botswana","Brazil","Brunei","Bulgaria","Brunei","Bulgaria","Burkina Faso","Burundi","Côte d'Ivoire","Cabo Verde","Cambodia",
            "Cameroon","Canada","Central African Republic","Chad","Chile","China","Colombia","Comoros","Congo","Costa Rica","Croatia","Cuba","Cyprus","Czechia","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador",
            "Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Eswatini","Ethiopia","Fiji","Finland","France","Gabon","Gambia","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Guinea-Bissau",
            "Guyana","Haiti","Holy See","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Kuwait","Kyrgyzstan","Laos",
            "Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia",
            "Moldova","Monaco","Mongolia","Montenegro","Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Nigeria","North Korea","North Macedonia","Norway","Oman","Pakistan",
            "Palau","Palestine State","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Qatar","Romania","Russia","Rwanda","Saint Kitts and Nevis","Saint Lucia","Saint Vincent and the Grenadines",
            "Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Island","Somalia","South Africa","South Korea","South Sudan",
            "Spain","Sri Lanka","Sudan","Suriname","Sweden","Switzerland","Syria","Tajikistan","Tanzania","Thailand","Timor-Leste","Togo","Tonga","Trinidad and Tobago","Tunisia","Turkey","Turkmenistan", "Tuvalu","Uganda",
            "Ukraine","United Arab Emirates","United Kingdom","United States of America","Uruguay","Uzbekistan","Vanuatu","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe");
    private final List<String> farmAnimals= Arrays.asList("Cattle","Chicken","Sheep","Goat","Horse","Dog","Rabbit","Duck","Pig","Donkey","Horse");
    private final List<String> colors= Arrays.asList("white","yellow","blue","green","red","black","brown","purple","azure","orange","pink","navy");
    private final List<String> actions= Arrays.asList("eats","hops","runs","jumps","swims","sits","stands","fights","plays","laughs","throws","catches");
    private final List<String> musicGenres= Arrays.asList("rock","pop","jazz","folk","country","blues","lofi","soul","funk","metal","reggae","techno");
    private final List<String> familyguy= Arrays.asList("Peter","Lois","Stewie","Meg","Chris","Quagmire","Brian","Adam","Joe","Herbert","Angela","Carter","Cleveland","Evil Monkey");


    //Generate unencrypted random string
    public String generateRandomString(){
        String output="";   //Declare and init output string

        int length=(int)(Math.random()*(8));    //Generate random number
        length+=3;
        //Loop and add data from different lists
        for(int i=0;i<=length;i++){
            int randomNum=(int)(Math.random()*(7));
            switch(randomNum){
                case 0:
                    int randomNum1=(int)(Math.random()*(phoneticAlphabet.size()));
                    String data1=phoneticAlphabet.get(randomNum1);  //Add item from phonetic alphabet list
                    output=output+data1;
                    break;
                case 1:
                    int randomNum2=(int)(Math.random()*(countries.size()));
                    String data2=countries.get(randomNum2);     //Add item from countries list
                    output=output+data2;
                    break;
                case 2:
                    int randomNum3=(int)(Math.random()*(farmAnimals.size()));
                    String data3=farmAnimals.get(randomNum3);   //Add item from farm animals list
                    output=output+data3;
                    break;
                case 3:
                    int randomNum4=(int)(Math.random()*(colors.size()));
                    String data4=colors.get(randomNum4);        //Add item from colors list
                    output=output+data4;
                    break;
                case 4:
                    int randomNum5=(int)(Math.random()*(actions.size()));
                    String data5=actions.get(randomNum5);       //Add item from actions list
                    output=output+data5;
                    break;
                case 5:
                    int randomNum6=(int)(Math.random()*(musicGenres.size()));
                    String data6=musicGenres.get(randomNum6);   //Add item from music genres list
                    output=output+data6;
                    break;
                default:
                    int randomNum7=(int)(Math.random()*(familyguy.size()));
                    String data7=familyguy.get(randomNum7);     //Add item from family guy list
                    output=output+data7;
                    break;
            }
        }
        return output;
    }

    //Generate Random Password
    public String generateRandomPassword(String input){

        String output=input;
        //Generate random number for caesar cipher operation
        int caeserCipher=(int)((Math.random()*(26))+1);
        int caeserCipherS=26-caeserCipher;

        //Generate random number to determine if the input string will be shifted
        int randomValue1=(int)(Math.random()*(3));
        switch(randomValue1){
            case 0:
                output=encryptionHandler.cc_encrypt(output,caeserCipher,caeserCipherS);
                break;
            case 1:
                output=encryptionHandler.cc_decrypt(output,caeserCipher,caeserCipherS);
                break;
            default:
                break;
        }

        //Generate random number to determine hashing algorithm used
        int randomValue2=(int)(Math.random()*(6));
        switch(randomValue2){
            case 0:
                output=encryptionHandler.md2(output);
                break;
            case 1:
                output=encryptionHandler.md5(output);
                break;
            case 2:
                output=encryptionHandler.sha512(output);
                break;
            case 3:
                output=encryptionHandler.sha1(output);
                break;
            case 4:
                output=encryptionHandler.sha256(output);
                break;
            case 5:
                output=encryptionHandler.sha384(output);
                break;
        }

        //Generate new random number for caesar cipher operation
        caeserCipher=(int)((Math.random()*(26))+1);
        caeserCipherS=26-caeserCipher;

        //Generate random number to determine if the input string will be shifted
        int randomValue3=(int)(Math.random()*(3));
        switch(randomValue3){
            case 0:
                output=encryptionHandler.cc_encrypt(output,caeserCipher,caeserCipherS);
                break;
            case 1:
                output=encryptionHandler.cc_decrypt(output,caeserCipher,caeserCipherS);
                break;
            default:
                break;
        }

        return output;
    }

}

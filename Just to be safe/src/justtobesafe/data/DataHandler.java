package justtobesafe.data;

import java.io.*;
import java.util.LinkedList;

public class DataHandler implements FileInterface, CsvInterface{

    @Override
    public String readFile(String file) {
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

    @Override
    public void writeFile(String file,String inputString) {
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(inputString);

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList<String> readCsvFile(String file) {
        LinkedList<String> list=new LinkedList<String>();
        //String[] array = {};
        String currentLine=""; //Init value
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            while((currentLine = reader.readLine() ) != null){
                list.add(currentLine);
                //System.out.println(currentLine);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        String s = "972456,972456,972456";
        String[] values = s.split(",");
        System.out.println(values[0]);
        System.out.println("readCSVFile");
         */
        return list;
    }

    @Override
    public void writeCsvFile(String file,String inputString) {
        try {
            FileOutputStream outputStream = new FileOutputStream(file,true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(inputString);

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCSVFile(String file,LinkedList<String> inputlist) {
        try {
            //EMPTY CSV FILE
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.close();
            //START WRITING
            outputStream = new FileOutputStream(file,true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (int i =0 ;i<inputlist.size();i++){
                bufferedWriter.write(inputlist.get(i)+"\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("deleteCSVFile");
    }
}

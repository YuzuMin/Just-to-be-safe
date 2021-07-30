package justtobesafe.data;

import java.io.*;

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
    public String[] readCsvFile(String file) {
        String s = "972456,972456,972456";
        String[] values = s.split(",");
        System.out.println(values[0]);
        System.out.println("readCSVFile");
        return values;
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
    public void deleteCSVFile(String file) {
        System.out.println("deleteCSVFile");
    }
}

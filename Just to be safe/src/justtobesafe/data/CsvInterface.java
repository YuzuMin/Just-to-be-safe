package justtobesafe.data;

import java.util.LinkedList;

public interface CsvInterface {
    public LinkedList<String> readCsvFile(String file);
    public void writeCsvFile(String file,String inputString);
    public void deleteCSVFile(String file,LinkedList<String> inputlist);
}

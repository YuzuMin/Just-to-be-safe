package justtobesafe.data;

public interface CsvInterface {
    public String readCsvFile(String file);
    public void writeCsvFile(String file,String inputString);
    public void deleteCSVFile(String location);
}

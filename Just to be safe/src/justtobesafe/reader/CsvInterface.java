package justtobesafe.reader;

public interface CsvInterface {
    public void readCsvFile(String location);
    public void writeCsvFile(String location);
    public void deleteCSVFile(String location);
}
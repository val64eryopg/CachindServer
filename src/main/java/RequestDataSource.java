import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RequestDataSource {
    private List<Integer> inputRequests;
    private Integer cacheSize;
    private Integer numberOfRequests;


    public RequestDataSource(String path) {
        List<Integer> inputList = readingFromFile(path);
        getCashSizeAndNumberOfRequest(inputList);
        if (inputList == null || inputList.size() != numberOfRequests) {
            this.inputRequests = null;
            this.cacheSize = null;
            this.numberOfRequests = null;
        }
    }

    public Integer getNumberOfRequests() {
        return numberOfRequests;
    }

    public Integer[] getInputRequests() {
        return inputRequests.toArray(new Integer[0]);
    }

    public Integer getCacheSize() {
        return cacheSize;
    }

    public boolean isNull() {
        return inputRequests != null && cacheSize != null && numberOfRequests != null;
    }

    private List<Integer> readingFromFile(String path) {
        List<Integer> inputData = new ArrayList<>();
        try {
            File input = new File(path);
            Scanner obj = new Scanner(input);
            while (obj.hasNext()) {
                try {
                    inputData.add(Integer.parseInt(obj.next().trim()));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return null;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputData;
    }

    private void getCashSizeAndNumberOfRequest(List<Integer> inputList) {
        if ((inputList != null) && (inputList.size() >= 3)) {
            this.cacheSize = inputList.remove(0);
            this.numberOfRequests = inputList.remove(0);
            this.inputRequests = inputList;
        }
    }

}

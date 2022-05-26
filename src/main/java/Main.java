public class Main {
    public static void main(String[] args) {
        //путь до файла с исходными данными необходимо поместить в конструктор класса RequestDataSource
        RequestDataSource getInput = new RequestDataSource("src/main/java/input.txt");
        if (getInput.isNull()) {
            LogicCash logicCash = new LogicCash(getInput.getInputRequests(), getInput.getCacheSize());
            //путь до файла с результатом необходимо прописать в конструкторе Output
            Output output = new Output(logicCash.getNumberOfRequestsToTheServer(), "src/main/java/output.txt");
            output.writeToFile();
        } else
            throw new NullPointerException("Input i`snt Correct");
    }
}

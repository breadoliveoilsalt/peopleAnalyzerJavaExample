package peopleAnalyzer.models;

public class Analysis {
    private String message;
    private int number;

    public Analysis(String message, int number) {
        this.message = message;
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public int getNumber() {
        return number;
    }


}

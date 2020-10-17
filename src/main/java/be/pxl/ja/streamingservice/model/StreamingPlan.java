package be.pxl.ja.streamingservice.model;

public enum StreamingPlan {
    BASIC("Basic", 7.99, 1),
    STANDARD("Standard", 11.99, 2),
    PREMIUM("Premium", 15.99, 4);

    private int numberOfProfiles;
    private double price;

    StreamingPlan(String plan, double price, int numberOfProfiles) {
        this.numberOfProfiles = numberOfProfiles;
        this.price = price;
    }

    public int getNumberOfProfiles() {
        return numberOfProfiles;
    }

    public double getPrice() {
        return price;
    }
}

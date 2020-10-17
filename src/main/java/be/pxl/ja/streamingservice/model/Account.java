package be.pxl.ja.streamingservice.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String email;
    private String password;
    private PaymentInfo paymentInfo;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles = new ArrayList<>();
    private Profile profile;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;

        profile = new Profile();
        profile.setName("profile1");

        profiles.add(profile);
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public Profile getFirstProfile() {
        return profiles.get(0);
    }

}

package com.basit.profitplus.models;

public class PackagesDetails {

    private String packageAmount, packageDurations , packageBonus ;


    public PackagesDetails(String packageAmount, String packageDurations, String packageBonus) {
        this.packageAmount = packageAmount;
        this.packageDurations = packageDurations;
        this.packageBonus = packageBonus;
    }

    public PackagesDetails() {
    }


    public String getPackageAmount() {
        return packageAmount;
    }

    public void setPackageAmount(String packageAmount) {
        this.packageAmount = packageAmount;
    }

    public String getPackageBonus() {
        return packageBonus;
    }

    public void setPackageBonus(String packageBonus) {
        this.packageBonus = packageBonus;
    }

    public String getPackageDurations() {
        return packageDurations;
    }

    public void setPackageDurations(String packageDurations) {
        this.packageDurations = packageDurations;
    }
}

package br.com.fezor.currencyConverter.models;

import com.google.gson.annotations.SerializedName;

public class Conversion {
    @SerializedName("conversion_result")
    private double convertedValue;
    @SerializedName("base_code")
    private String actualCurrency;
    @SerializedName("target_code")
    private String targetCurrency;
    private double value;

    public Conversion(double convertedValue, String actualCurrency, String targetCurrency, double value){
        this.convertedValue = convertedValue;
        this.actualCurrency = actualCurrency;
        this.targetCurrency = targetCurrency;
        this.value = value;
    }

    public Conversion(Currency myCurrency){
        this.value = myCurrency.value();
        this.convertedValue = myCurrency.conversion_result();
        this.actualCurrency = myCurrency.base_code();
        this.targetCurrency = myCurrency.target_code();
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getActualCurrency() {
        return actualCurrency;
    }

    public void setActualCurrency(String actualCurrency) {
        this.actualCurrency = actualCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "The value " + value + " [" + actualCurrency + "] "
                + "corresponds to the final value of " + convertedValue + " [" + targetCurrency + "]";
    }
}

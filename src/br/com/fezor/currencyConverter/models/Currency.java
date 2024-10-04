package br.com.fezor.currencyConverter.models;

public record Currency(double value, double conversion_result, String base_code, String target_code) {

}

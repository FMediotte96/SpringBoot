package com.tutorialesvip.tutorialunittest.models;

public class CountryResponse {
    private String countryName;
    private String capitalName;
    private String independenceDate;
    private int yearsOfIndependence;
    private int monthsOfIndependence;
    private int daysOfIndependence;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public String getIndependenceDate() {
        return independenceDate;
    }

    public void setIndependenceDate(String independenceDate) {
        this.independenceDate = independenceDate;
    }

    public int getYearsOfIndependence() {
        return yearsOfIndependence;
    }

    public void setYearsOfIndependence(int yearsOfIndependence) {
        this.yearsOfIndependence = yearsOfIndependence;
    }

    public int getMonthsOfIndependence() {
        return monthsOfIndependence;
    }

    public void setMonthsOfIndependence(int monthsOfIndependence) {
        this.monthsOfIndependence = monthsOfIndependence;
    }

    public int getDaysOfIndependence() {
        return daysOfIndependence;
    }

    public void setDaysOfIndependence(int daysOfIndependence) {
        this.daysOfIndependence = daysOfIndependence;
    }

}
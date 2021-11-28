package com.zendesk.springboot.model;

public class Forecast {
    private String date;
    private Double temperatureC;
    private Double temperatureF;
    private String summary;

    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return this.date;
    }
    public void setTemperatureC(Double temperatureC){
        this.temperatureC = temperatureC;
    }
    public Double getTemperatureC(){
        return this.temperatureC;
    }
    public void setTemperatureF(Double temperatureF){
        this.temperatureF = temperatureF;
    }
    public Double getTemperatureF(){
        return this.temperatureF;
    }
    public void setSummary(String summary){
        this.summary = summary;
    }
    public String getSummary(){
        return this.summary;
    }
}

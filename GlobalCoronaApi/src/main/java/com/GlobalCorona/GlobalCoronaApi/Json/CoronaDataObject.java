package com.GlobalCorona.GlobalCoronaApi.Json;

import java.sql.Date;

public class CoronaDataObject {
    String Province_State;
    String Country_Region;
    Date Last_Update;
    Float Confirmed;
    Float Deaths;
    Float Recovered;
    Float Active;
    Float Case_Fatality_ratio;


    public CoronaDataObject(String province_State, String country_Region, Date last_Update, Float confirmed, Float deaths, Float recovered, Float active, Float case_fatality_ratio) {
        Province_State = province_State;
        Country_Region = country_Region;
        Last_Update = last_Update;
        Confirmed = confirmed;
        Deaths = deaths;
        Recovered = recovered;
        Active = active;
        Case_Fatality_ratio = case_fatality_ratio;
    }

    public String getProvince_State() {
        return Province_State;
    }

    public void setProvince_State(String province_State) {
        Province_State = province_State;
    }

    public String getCountry_Region() {
        return Country_Region;
    }

    public void setCountry_Region(String country_Region) {
        Country_Region = country_Region;
    }

    public Date getLast_Update() {
        return Last_Update;
    }

    public void setLast_Update(Date last_Update) {
        Last_Update = last_Update;
    }

    public Float getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(Float confirmed) {
        Confirmed = confirmed;
    }

    public Float getDeaths() {
        return Deaths;
    }

    public void setDeaths(Float deaths) {
        Deaths = deaths;
    }

    public Float getRecovered() {
        return Recovered;
    }

    public void setRecovered(Float recovered) {
        Recovered = recovered;
    }

    public Float getActive() {
        return Active;
    }

    public void setActive(Float active) {
        Active = active;
    }

    public Float getCase_Fatality_ratio() {
        return Case_Fatality_ratio;
    }

    public void setCase_Fatality_ratio(Float case_Fatality_ratio) {
        Case_Fatality_ratio = case_Fatality_ratio;
    }

    public void display(){
        System.out.println("CoronaDataObject{" +
                "Province_State='" + Province_State  +
                ", Country_Region='" + Country_Region  +
                ", Last_Update=" + Last_Update +
                ", Confirmed=" + Confirmed +
                ", Deaths=" + Deaths +
                ", Recovered=" + Recovered +
                ", Active=" + Active +
                ", Case_Fatality_Ratio=" + Case_Fatality_ratio);
    }

}

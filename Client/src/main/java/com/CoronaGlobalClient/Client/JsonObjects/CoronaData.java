package com.CoronaGlobalClient.Client.JsonObjects;

import java.sql.Date;

public class CoronaData {

    String date;
    String province_State;
    String country_Region;
    String last_Update;
    Float confirmed;
    Float deaths;
    Float recovered;
    Float active;
    Float case_Fatality_ratio;

    public CoronaData(String date, String province_State, String country_Region, String last_Update, Float confirmed, Float deaths, Float recovered, Float active, Float case_Fatality_ratio) {
        this.date = date;
        this.province_State = province_State;
        this.country_Region = country_Region;
        this.last_Update = last_Update;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.active = active;
        this.case_Fatality_ratio = case_Fatality_ratio;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProvince_State() {
        return province_State;
    }

    public void setProvince_State(String province_State) {
        this.province_State = province_State;
    }

    public String getCountry_Region() {
        return country_Region;
    }

    public void setCountry_Region(String country_Region) {
        this.country_Region = country_Region;
    }

    public String getLast_Update() {
        return last_Update;
    }

    public void setLast_Update(String last_Update) {
        this.last_Update = last_Update;
    }

    public Float getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Float confirmed) {
        this.confirmed = confirmed;
    }

    public Float getDeaths() {
        return deaths;
    }

    public void setDeaths(Float deaths) {
        this.deaths = deaths;
    }

    public Float getRecovered() {
        return recovered;
    }

    public void setRecovered(Float recovered) {
        this.recovered = recovered;
    }

    public Float getActive() {
        return active;
    }

    public void setActive(Float active) {
        this.active = active;
    }

    public Float getCase_Fatality_ratio() {
        return case_Fatality_ratio;
    }

    public void setCase_Fatality_ratio(Float case_Fatality_ratio) {
        this.case_Fatality_ratio = case_Fatality_ratio;
    }

    @Override
    public String toString() {
        return "CoronaData{" +
                "date='" + date + '\'' +
                ", province_State='" + province_State + '\'' +
                ", country_Region='" + country_Region + '\'' +
                ", last_Update=" + last_Update +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", active=" + active +
                ", case_Fatality_ratio=" + case_Fatality_ratio +
                '}';
    }
}

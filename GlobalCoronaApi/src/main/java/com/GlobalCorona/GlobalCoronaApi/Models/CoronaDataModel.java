package com.GlobalCorona.GlobalCoronaApi.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class CoronaDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    String Province_State;
    String Country_Region;
    String date;
    Date Last_Update;
    Float Confirmed;
    Float Deaths;
    Float Recovered;
    Float Active;
    Float Case_Fatality_ratio;

    public CoronaDataModel() {

    }

    public CoronaDataModel(String province_State, String country_Region, Date last_Update, Float confirmed, Float deaths, Float recovered, Float active, Float case_fatality_ratio) {
        Province_State = province_State;
        Country_Region = country_Region;
        Last_Update = last_Update;
        Confirmed = confirmed;
        Deaths = deaths;
        Recovered = recovered;
        Active = active;
        Case_Fatality_ratio = case_fatality_ratio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoronaDataModel that = (CoronaDataModel) o;
        return Objects.equals(Province_State, that.Province_State) && Objects.equals(Country_Region, that.Country_Region) && Objects.equals(Last_Update, that.Last_Update) && Objects.equals(Confirmed, that.Confirmed) && Objects.equals(Deaths, that.Deaths) && Objects.equals(Recovered, that.Recovered) && Objects.equals(Active, that.Active) && Objects.equals(Case_Fatality_ratio, that.Case_Fatality_ratio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Province_State, Country_Region, Last_Update, Confirmed, Deaths, Recovered, Active, Case_Fatality_ratio);
    }

    @Override
    public String toString() {
        return "CoronaDataModel{" +
                "Province_State='" + Province_State + '\'' +
                ", Country_Region='" + Country_Region + '\'' +
                ", Last_Update=" + Last_Update +
                ", Confirmed=" + Confirmed +
                ", Deaths=" + Deaths +
                ", Recovered=" + Recovered +
                ", Active=" + Active +
                ", Case_Fatality_Ratio=" + Case_Fatality_ratio +
                '}';
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCase_Fatality_ratio(Float case_Fatality_ratio) {
        Case_Fatality_ratio = case_Fatality_ratio;
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

    public void setTotal_Test_Results(Float case_fatality_ratio) {
        Case_Fatality_ratio = case_fatality_ratio;
    }
}

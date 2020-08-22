package com.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.util.Date;


public class Form {
    private String contestname;
    private String workname;
    private String sponsor;
    private String position;
    private Date datetime;
    private String belong;
    private String nums;
    private String score;
    private String type;
    private String eventcategory;
    private String awardgrade;
    private String awardlevel;
    private String fileurl;

    public Form() {
    }

    public Form(String contestname, String workname, String sponsor, String position, Date datetime, String belong, String nums, String score, String type, String eventcategory, String awardgrade, String awardlevel, String fileurl) {
        this.contestname = contestname;
        this.workname = workname;
        this.sponsor = sponsor;
        this.position = position;
        this.datetime = datetime;
        this.belong = belong;
        this.nums = nums;
        this.score = score;
        this.type = type;
        this.eventcategory = eventcategory;
        this.awardgrade = awardgrade;
        this.awardlevel = awardlevel;
        this.fileurl = fileurl;
    }

    @Override
    public String toString() {
        return "Form{" +
                "contestname='" + contestname + '\'' +
                ", workname='" + workname + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", position='" + position + '\'' +
                ", datetime=" + datetime +
                ", belong='" + belong + '\'' +
                ", nums='" + nums + '\'' +
                ", score='" + score + '\'' +
                ", type='" + type + '\'' +
                ", eventcategory='" + eventcategory + '\'' +
                ", awardgrade='" + awardgrade + '\'' +
                ", awardlevel='" + awardlevel + '\'' +
                ", fileurl='" + fileurl + '\'' +
                '}';
    }

    public String getContestname() {
        return contestname;
    }

    public void setContestname(String contestname) {
        this.contestname = contestname;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEventcategory() {
        return eventcategory;
    }

    public void setEventcategory(String eventcategory) {
        this.eventcategory = eventcategory;
    }

    public String getAwardgrade() {
        return awardgrade;
    }

    public void setAwardgrade(String awardgrade) {
        this.awardgrade = awardgrade;
    }

    public String getAwardlevel() {
        return awardlevel;
    }

    public void setAwardlevel(String awardlevel) {
        this.awardlevel = awardlevel;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }
}

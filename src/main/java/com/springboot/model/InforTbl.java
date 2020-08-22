package com.springboot.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
@Entity
@Table(name="infortbl")
public class InforTbl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="contestname")
    private String contestname;
    private String workname;
    private String sponsor;
    private String position;

    private Timestamp datetime;
    private String belong;
    private Integer nums;
    private double score;
    private String type;
    private String eventcategory;
    private String awardgrade;
    private String awardlevel;
    private String fileurl;
    private String stumsg;
    private String tecmsg;
    private String  picurl;
    private String flag;
    private String author;
    private String suggest;

    public InforTbl() {
    }

    public InforTbl(String contestname, String workname, String sponsor, String position, Timestamp datetime, String belong, Integer nums, double score, String type, String eventcategory, String awardgrade, String awardlevel, String fileurl, String stumsg, String tecmsg, String picurl, String flag, String author, String suggest) {
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
        this.stumsg = stumsg;
        this.tecmsg = tecmsg;
        this.picurl = picurl;
        this.flag = flag;
        this.author = author;
        this.suggest = suggest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
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

    public String getStumsg() {
        return stumsg;
    }

    public void setStumsg(String stumsg) {
        this.stumsg = stumsg;
    }

    public String getTecmsg() {
        return tecmsg;
    }

    public void setTecmsg(String tecmsg) {
        this.tecmsg = tecmsg;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    @Override
    public String toString() {
        return "InforTbl{" +
                "id=" + id +
                ", contestname='" + contestname + '\'' +
                ", workname='" + workname + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", position='" + position + '\'' +
                ", datetime=" + datetime +
                ", belong='" + belong + '\'' +
                ", nums=" + nums +
                ", score=" + score +
                ", type='" + type + '\'' +
                ", eventcategory='" + eventcategory + '\'' +
                ", awardgrade='" + awardgrade + '\'' +
                ", awardlevel='" + awardlevel + '\'' +
                ", fileurl='" + fileurl + '\'' +
                ", stumsg='" + stumsg + '\'' +
                ", tecmsg='" + tecmsg + '\'' +
                ", picurl='" + picurl + '\'' +
                ", flag='" + flag + '\'' +
                ", author='" + author + '\'' +
                ", suggest='" + suggest + '\'' +
                '}';
    }
}
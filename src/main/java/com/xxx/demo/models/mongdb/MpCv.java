package com.xxx.demo.models.mongdb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author luomouren
 *         测点cv值-与数据库mongodb表mpcv对应
 */
@Document
public class MpCv implements Serializable {

    private static final long serialVersionUID = 1L;
    //id属性是给mongodb用的，用@Id注解修饰
    @Id
    private String id;
    private String cvId;
    private String mpId;
    private Double value;
    // 示数对应时间
    private Date dataTime;
    // 数据采集时间
    private Date samTime;

    public MpCv() {
        super();
    }

    public MpCv(String _id, String cvId, String mpId, Double value, Date dataTime, Date samTime) {
        super();
        this.id = id;
        this.cvId = cvId;
        this.mpId = mpId;
        this.value = value;
        this.dataTime = dataTime;
        this.samTime = samTime;
    }

    public String getCvId() {
        return cvId;
    }

    public void setCvId(String cvId) {
        this.cvId = cvId;
    }

    public String getMpId() {
        return mpId;
    }

    public void setMpId(String mpId) {
        this.mpId = mpId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Date getSamTime() {
        return samTime;
    }

    public void setSamTime(Date samTime) {
        this.samTime = samTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

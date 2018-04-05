package com.blackey.bys.dto;

import com.blackey.bys.components.model.Business;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityForm {

    private String id;

    private String business_id;

    /**
     * 市场价
     */
    private String salePrice;

    /**
     * 折扣价
     */
    private String discountPrice;

    /**
     * 抢购价
     */
    private String rushPrice;

    private String stock;

    /**
     * 已售出
     */
    private String saleOut;

    private String attention;

    private String detail;

    private String name;

    private String mainPage;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getRushPrice() {
        return rushPrice;
    }

    public void setRushPrice(String rushPrice) {
        this.rushPrice = rushPrice;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getSaleOut() {
        return saleOut;
    }

    public void setSaleOut(String saleOut) {
        this.saleOut = saleOut;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainPage() {
        return mainPage;
    }

    public void setMainPage(String mainPage) {
        this.mainPage = mainPage;
    }
}

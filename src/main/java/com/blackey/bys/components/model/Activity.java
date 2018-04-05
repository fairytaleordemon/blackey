package com.blackey.bys.components.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "businessId")
    private Business business;

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

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    @Basic(fetch = FetchType.LAZY)
    private String detail;

    private String name;


    @Basic
    private String mainPage;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
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

package com.bur1y.ClothesForHands.database.table;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Title", nullable = false, length = 100)
    private String title;

    @Column(name = "CountInPack", nullable = false)
    private Integer countInPack;

    @Column(name = "Unit", nullable = false, length = 10)
    private String unit;

    @Column(name = "CountInStock")
    private Double countInStock;

    @Column(name = "MinCount", nullable = false)
    private Double minCount;

    @Lob
    @Column(name = "Description")
    private String description;

    @Column(name = "Cost", nullable = false, precision = 10, scale = 2)
    private BigDecimal cost;

    @Column(name = "Image", length = 100)
    private String image;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MaterialTypeID", nullable = false)
    private MaterialType materialTypeID;

    public MaterialType getMaterialTypeID() {
        return materialTypeID;
    }

    public void setMaterialTypeID(MaterialType materialTypeID) {
        this.materialTypeID = materialTypeID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMinCount() {
        return minCount;
    }

    public void setMinCount(Double minCount) {
        this.minCount = minCount;
    }

    public Double getCountInStock() {
        return countInStock;
    }

    public void setCountInStock(Double countInStock) {
        this.countInStock = countInStock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getCountInPack() {
        return countInPack;
    }

    public void setCountInPack(Integer countInPack) {
        this.countInPack = countInPack;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
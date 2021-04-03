package com.company.agora.entity;

import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.BaseLongIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Table(name = "AGORA_AGORA_PRODUCT")
@Entity(name = "agora_AgoraProduct")
public class AgoraProduct extends BaseLongIdEntity implements HasUuid {
    private static final long serialVersionUID = -7590740135784984601L;

    @Column(name = "UUID")
    private UUID uuid;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @NotNull
    @JoinColumn(name = "PRODUCT_MERCHANT_ID_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User productMerchantID;

    @NotNull
    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @NotNull
    @Column(name = "PRODUCT_DESCRIPTION", nullable = false, length = 2048)
    private String productDescription;

    @NumberFormat(pattern = "$xx.xx", decimalSeparator = ".")
    @Column(name = "PRODUCT_TASTE_PRICE", precision = 2, scale = 2)
    private BigDecimal productTastePrice;

    @NumberFormat(pattern = "$xx.xx", decimalSeparator = ".")
    @Column(name = "PRODUCT_SALE_PRICE", precision = 2, scale = 2)
    private BigDecimal productSalePrice;

    @Column(name = "PRODUCT_PICTURE_ID")
    private Long productPictureID;

    @Column(name = "PRODUCT_BARCODE")
    private Long productBarcode;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AGORA_EVENT_PRODUCT_ID")
    private AgoraEventProduct agoraEventProduct;
    @JoinTable(name = "AGORA_AGORA_EVENT_PRODUCT_AGORA_PRODUCT_LINK",
            joinColumns = @JoinColumn(name = "AGORA_PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "AGORA_EVENT_PRODUCT_ID"))
    @ManyToMany
    private List<AgoraEventProduct> agoraEventProducts;

    public List<AgoraEventProduct> getAgoraEventProducts() {
        return agoraEventProducts;
    }

    public void setAgoraEventProducts(List<AgoraEventProduct> agoraEventProducts) {
        this.agoraEventProducts = agoraEventProducts;
    }

    public AgoraEventProduct getAgoraEventProduct() {
        return agoraEventProduct;
    }

    public void setAgoraEventProduct(AgoraEventProduct agoraEventProduct) {
        this.agoraEventProduct = agoraEventProduct;
    }

    public Long getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(Long productBarcode) {
        this.productBarcode = productBarcode;
    }

    public Long getProductPictureID() {
        return productPictureID;
    }

    public void setProductPictureID(Long productPictureID) {
        this.productPictureID = productPictureID;
    }

    public BigDecimal getProductSalePrice() {
        return productSalePrice;
    }

    public void setProductSalePrice(BigDecimal productSalePrice) {
        this.productSalePrice = productSalePrice;
    }

    public BigDecimal getProductTastePrice() {
        return productTastePrice;
    }

    public void setProductTastePrice(BigDecimal productTastePrice) {
        this.productTastePrice = productTastePrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public User getProductMerchantID() {
        return productMerchantID;
    }

    public void setProductMerchantID(User productMerchantID) {
        this.productMerchantID = productMerchantID;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
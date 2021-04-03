package com.company.agora.entity;

import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.BaseLongIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.UUID;

@Table(name = "AGORA_AGORA_EVENT")
@Entity(name = "agora_AgoraEvent")
public class AgoraEvent extends BaseLongIdEntity implements HasUuid {
    private static final long serialVersionUID = 4037584161697704279L;

    @Column(name = "UUID")
    private UUID uuid;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORGANISER_ID_ID")
    private User organiserID;

    @NotNull
    @Column(name = "EVENT_NAME", nullable = false)
    private String eventName;

    @NotNull
    @Column(name = "EVENT_DESCRIPTION", nullable = false, length = 2048)
    private String eventDescription;

    @NotNull
    @Column(name = "EVENT_START_DATE", nullable = false)
    private OffsetDateTime eventStartDate;

    @NotNull
    @Column(name = "EVENT_END_DATE", nullable = false)
    private OffsetDateTime eventEndDate;

    @NotNull
    @Column(name = "EVENT_LOCATION", nullable = false)
    private String eventLocation;

    @NotNull
    @Column(name = "EVENT_CONTACT_NAME", nullable = false)
    private String eventContactName;

    @NotNull
    @Column(name = "EVENT_CONTACT_PHONE", nullable = false, length = 30)
    private String eventContactPhone;

    @NotNull
    @Column(name = "EVENT_PUBLISHED", nullable = false)
    private Integer eventPublished;

    @NumberFormat(pattern = "$xxx.xx", decimalSeparator = ".")
    @NotNull
    @Column(name = "EVENT_KIOSK_COST", nullable = false, precision = 2, scale = 2)
    @PositiveOrZero(message = "Cost must be greater than $0")
    @DecimalMax("2")
    private BigDecimal eventKioskCost;

    @NotNull
    @Column(name = "EVENT_KIOSK_COUNT", nullable = false)
    private Integer eventKioskCount;

    @Temporal(TemporalType.TIME)
    @Column(name = "EVENT_DAILY_SITE_CLOSE")
    private Date eventDailySiteClose;

    @Column(name = "EVENT_TIME_ZONE", length = 20)
    private String eventTimeZone;

    @NotNull
    @Column(name = "EVENT_WEB_SITE", nullable = false)
    private String eventWebSite;

    public String getEventWebSite() {
        return eventWebSite;
    }

    public void setEventWebSite(String eventWebSite) {
        this.eventWebSite = eventWebSite;
    }

    public String getEventTimeZone() {
        return eventTimeZone;
    }

    public void setEventTimeZone(String eventTimeZone) {
        this.eventTimeZone = eventTimeZone;
    }

    public Date getEventDailySiteClose() {
        return eventDailySiteClose;
    }

    public void setEventDailySiteClose(Date eventDailySiteClose) {
        this.eventDailySiteClose = eventDailySiteClose;
    }

    public Integer getEventKioskCount() {
        return eventKioskCount;
    }

    public void setEventKioskCount(Integer eventKioskCount) {
        this.eventKioskCount = eventKioskCount;
    }

    public BigDecimal getEventKioskCost() {
        return eventKioskCost;
    }

    public void setEventKioskCost(BigDecimal eventKioskCost) {
        this.eventKioskCost = eventKioskCost;
    }

    public EventPublishedValues getEventPublished() {
        return eventPublished == null ? null : EventPublishedValues.fromId(eventPublished);
    }

    public void setEventPublished(EventPublishedValues eventPublished) {
        this.eventPublished = eventPublished == null ? null : eventPublished.getId();
    }

    public String getEventContactPhone() {
        return eventContactPhone;
    }

    public void setEventContactPhone(String eventContactPhone) {
        this.eventContactPhone = eventContactPhone;
    }

    public String getEventContactName() {
        return eventContactName;
    }

    public void setEventContactName(String eventContactName) {
        this.eventContactName = eventContactName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public OffsetDateTime getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(OffsetDateTime eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public OffsetDateTime getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(OffsetDateTime eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public User getOrganiserID() {
        return organiserID;
    }

    public void setOrganiserID(User organiserID) {
        this.organiserID = organiserID;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
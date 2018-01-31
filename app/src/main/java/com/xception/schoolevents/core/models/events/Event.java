
package com.xception.schoolevents.core.models.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event {

    @SerializedName("form")
    @Expose
    private String form;

    @SerializedName("createdBy")
    @Expose
    private String createdBy;

    @SerializedName("owner")
    @Expose
    private String owner;

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;

    @SerializedName("dateStart")
    @Expose
    private String dateStart;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("dateEnd")
    @Expose
    private String dateEnd;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("publishState")
    @Expose
    private String publishState;

    @SerializedName("medias")
    @Expose
    private List<Media> medias = null;

    @SerializedName("linksToItem")
    @Expose
    private List<Object> linksToItem = null;

    @SerializedName("payload_schema")
    @Expose
    private String payloadSchema;

    @SerializedName("payload")
    @Expose
    private Payload payload;

    @SerializedName("address")
    @Expose
    private Address address;

    @SerializedName("slug")
    @Expose
    private String slug;

    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("appIds")
    @Expose
    private String appIds;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("entireDays")
    @Expose
    private Boolean entireDays;

    @SerializedName("publishDateStart")
    @Expose
    private String publishDateStart;

    @SerializedName("publishDateEnd")
    @Expose
    private String publishDateEnd;

    @SerializedName("parentsFixedAt")
    @Expose
    private String parentsFixedAt;

    @SerializedName("editor_access")
    @Expose
    private Boolean editorAccess;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("excerpt")
    @Expose
    private String excerpt;

    @SerializedName("template")
    @Expose
    private String template;

    @SerializedName("icon")
    @Expose
    private String icon;

    @SerializedName("externalLink")
    @Expose
    private String externalLink;

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublishState() {
        return publishState;
    }

    public void setPublishState(String publishState) {
        this.publishState = publishState;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public List<Object> getLinksToItem() {
        return linksToItem;
    }

    public void setLinksToItem(List<Object> linksToItem) {
        this.linksToItem = linksToItem;
    }

    public String getPayloadSchema() {
        return payloadSchema;
    }

    public void setPayloadSchema(String payloadSchema) {
        this.payloadSchema = payloadSchema;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAppIds() {
        return appIds;
    }

    public void setAppIds(String appIds) {
        this.appIds = appIds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getEntireDays() {
        return entireDays;
    }

    public void setEntireDays(Boolean entireDays) {
        this.entireDays = entireDays;
    }

    public String getPublishDateStart() {
        return publishDateStart;
    }

    public void setPublishDateStart(String publishDateStart) {
        this.publishDateStart = publishDateStart;
    }

    public String getPublishDateEnd() {
        return publishDateEnd;
    }

    public void setPublishDateEnd(String publishDateEnd) {
        this.publishDateEnd = publishDateEnd;
    }

    public String getParentsFixedAt() {
        return parentsFixedAt;
    }

    public void setParentsFixedAt(String parentsFixedAt) {
        this.parentsFixedAt = parentsFixedAt;
    }

    public Boolean getEditorAccess() {
        return editorAccess;
    }

    public void setEditorAccess(Boolean editorAccess) {
        this.editorAccess = editorAccess;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

}

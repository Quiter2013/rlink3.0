package com.robustel.gateway.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "gateway_api_define")
public class RouteInfo {
    @Id
    private String id;

    private String path;

    @Column(name = "service_id")
    private String serviceId;

    private String url;

    private Boolean retryable;

    private Boolean enabled;

    @Column(name = "strip_prefix")
    private Boolean stripPrefix;

    @Column(name = "api_name")
    private String apiName;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return service_id
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return retryable
     */
    public Boolean getRetryable() {
        return retryable;
    }

    /**
     * @param retryable
     */
    public void setRetryable(Boolean retryable) {
        this.retryable = retryable;
    }

    /**
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return strip_prefix
     */
    public Boolean getStripPrefix() {
        return stripPrefix;
    }

    /**
     * @param stripPrefix
     */
    public void setStripPrefix(Boolean stripPrefix) {
        this.stripPrefix = stripPrefix;
    }

    /**
     * @return api_name
     */
    public String getApiName() {
        return apiName;
    }

    /**
     * @param apiName
     */
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }
}
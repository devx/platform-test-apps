package com.rackspace.srvcheck.domain;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceCheck extends ResourceSupport {

    private final long serviceCheckId;
    private final String host;

    @JsonCreator
    public ServiceCheck(@JsonProperty("serviceCheckId") long serviceCheckId, @JsonProperty("host") String host) {
        this.serviceCheckId = serviceCheckId;
        this.host = host;
    }

    public long getServiceCheckId() {
        return serviceCheckId;
    }

    public String getHost() {
        return host;
    }
}
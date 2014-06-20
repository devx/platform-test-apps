package com.rackspace.srvcheck.controller;

import com.rackspace.srvcheck.domain.ServiceCheck;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ServiceCheckController {

    private final AtomicLong counter = new AtomicLong();
    private final Map<Long, ServiceCheck> serviceCheckMap = new HashMap<Long, ServiceCheck>();

    @RequestMapping(value = "/service/checks", method = POST)
    @ResponseBody
    public HttpEntity<ServiceCheck> create(
            @RequestParam(value = "host", required = true) String host) {

        ServiceCheck serviceCheck = new ServiceCheck(counter.incrementAndGet(), host);
        serviceCheck.add(linkTo(methodOn(ServiceCheckController.class).create(host)).withSelfRel());

        serviceCheckMap.put(counter.get(), serviceCheck);

        return new ResponseEntity<ServiceCheck>(serviceCheck, HttpStatus.OK);
    }

    @RequestMapping(value = "/service/checks/{id}", method = GET)
    @ResponseBody
    public HttpEntity<ServiceCheck> get(
            @PathVariable(value = "id") long id) {

        ServiceCheck serviceCheck = serviceCheckMap.get(id);

        ServiceCheck responseServiceCheck = new ServiceCheck(serviceCheck.getServiceCheckId(), serviceCheck.getHost());
        responseServiceCheck.add(linkTo(methodOn(ServiceCheckController.class).get(id)).withSelfRel());

        return new ResponseEntity<ServiceCheck>(responseServiceCheck, HttpStatus.OK);
    }
}
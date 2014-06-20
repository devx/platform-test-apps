package com.rackspace.srvcheck.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.rackspace.srvcheck.domain.ServiceCheck;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class ServiceCheckController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/service/checks", method = POST)
    @ResponseBody
    public HttpEntity<ServiceCheck> create(
            @RequestParam(value = "host", required = true) String host) {

        ServiceCheck greeting = new ServiceCheck(counter.incrementAndGet(), host);
        greeting.add(linkTo(methodOn(ServiceCheckController.class).create(host)).withSelfRel());

        return new ResponseEntity<ServiceCheck>(greeting, HttpStatus.OK);
    }
}
package com.tommyziegler.web;

import com.tommyziegler.hateoas.LinkWithOptionalMethod;
import com.tommyziegler.properties.SpringCloudProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/rest")
class SpringCloudRestController {

    private final SpringCloudProperties springCloudProperties;

    @Autowired public SpringCloudRestController(SpringCloudProperties springCloudProperties) {
        this.springCloudProperties = springCloudProperties;
    }

    @RequestMapping(method = RequestMethod.GET) public ResourceSupport getRestLinks() {

        ResourceSupport resourceSupport = new ResourceSupport();

        springCloudProperties.getLinks().forEach(((rel, hrefAndMethod) -> resourceSupport
                .add(new LinkWithOptionalMethod(rel, hrefAndMethod.getHref(),
                        Optional.ofNullable(hrefAndMethod.getMethod())))));

        return resourceSupport;
    }
}
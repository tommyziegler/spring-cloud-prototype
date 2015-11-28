package com.tommyziegler.hateoas;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.UriTemplate;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Optional;

@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true, includeFieldNames=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkWithOptionalMethod extends Link {

    @XmlAttribute
    @Getter private RequestMethod method;

    public LinkWithOptionalMethod(String rel, String href, Optional<RequestMethod> method) {
        super(new UriTemplate(href), rel);
        if(method.isPresent()) {
            this.method = method.get();
        }
    }
}
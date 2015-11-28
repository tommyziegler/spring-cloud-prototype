package com.tommyziegler.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMethod;

public class HrefAndMethod {
    @Getter @Setter
    private String href;

    @Getter @Setter
    private RequestMethod method;
}

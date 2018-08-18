package com.example.sample.devicemagicsample.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(name = "download", strict = false)
public class Phrase {

    @Element(name = "value")
    @Path("item")
    private String value;

    public String getValue() {
        return value;
    }
}

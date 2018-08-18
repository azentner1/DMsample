package com.example.sample.devicemagicsample.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;


public class DownloadItem {

    @Text
    public String item;

    public String getItem() {
        return item;
    }
}

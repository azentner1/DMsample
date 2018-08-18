package com.example.sample.devicemagicsample.api.response;

import com.example.sample.devicemagicsample.model.DownloadItem;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "downloads", strict = false)
public class DownloadItemsResponse {

    @ElementList(entry = "item", inline = true)
    private List<DownloadItem> downloadItems;

    public List<DownloadItem> getDownloadItems() {
        return downloadItems;
    }
}

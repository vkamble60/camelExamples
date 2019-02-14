package com.test.route;

import org.apache.camel.builder.RouteBuilder;
import com.test.processor.MyProcessor;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:/home/vkamble/NotBackedUp/inputFolder?noop=true").process(new MyProcessor()).to("file:/home/vkamble/NotBackedUp/outputFolder");
    }

}

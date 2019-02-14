package com.test.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import com.test.exception.CamelCustomException;
import com.test.processor.MyProcessor;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        onException(CamelCustomException.class).process(new Processor() {

            public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
        }).log("Received body ${body}").handled(true);

        from("file:/home/vkamble/NotBackedUp/inputFolder?noop=true").process(new MyProcessor()).to("file:/home/vkamble/NotBackedUp/outputFolder");

        from("file:/home/vkamble/NotBackedUp/inbox?noop=true").process(new MyProcessor()).to("file:/home/vkamble/NotBackedUp/outputFolder");
    }

}

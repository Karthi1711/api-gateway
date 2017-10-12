package com.oms.apigateway.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
@EnableAutoConfiguration
public class DocumentationController implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList();
        resources.add(swaggerResource("customer-service", "/api/customer/v2/api-docs", "2.0"));
        resources.add(swaggerResource("inventory-service", "/api/inventory/v2/api-docs", "2.0"));
        resources.add(swaggerResource("product-service", "/api/product/v2/api-docs", "2.0"));
        resources.add(swaggerResource("event-service", "/api/event/v2/api-docs", "2.0"));
        resources.add(swaggerResource("mail-service", "/api/mail/v2/api-docs", "2.0"));
        resources.add(swaggerResource("order-comp-service", "/api/order/v2/api-docs", "2.0"));
        return resources;
    }
    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}

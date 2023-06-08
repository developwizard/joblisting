package com.dewiz.joblisting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.autoconfigure.mongo.PropertiesMongoConnectionDetails;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
//@EnableSwagger2
public class JoblistingApplication {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.companyname.app"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiInfoMetaData());
    }

    private ApiInfo apiInfoMetaData() {

        return new ApiInfoBuilder().title("NAME OF SERVICE")
                .description("API Endpoint Decoration")
                .contact(new Contact("Dev-Team", "https://www.dev-team.com/", "dev-team@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

    @Bean
    PropertiesMongoConnectionDetails mongoProperties(final MongoProperties mongoProperties) {
        final String withDatabaseName =
                mongoProperties.getUri().replace("/?", "/" + mongoProperties.getDatabase() + "?");
        mongoProperties.setUri(withDatabaseName);

        return new PropertiesMongoConnectionDetails(mongoProperties);
    }

    public static void main(String[] args) {
        SpringApplication.run(JoblistingApplication.class, args);
    }

}

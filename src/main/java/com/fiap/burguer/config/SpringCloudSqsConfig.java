package com.fiap.burguer.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudSqsConfig {


//    String accessKeyId;
//
//    String secretAccessKey = "2rxy6YCAVABJrc3qd31HIJ+tnT6NffmAsDlmOZIZ";
//
//    String token = "IQoJb3JpZ2luX2VjEKX//////////wEaCXVzLXdlc3QtMiJHMEUCIE3l2M1k7iKBJ4ay5SvM+USg2RGqQlZTR7Rlo3y/EjdvAiEA+yXrjRbd8t0hlUXKd8ilrtGS7IfAhMNx+beQMFtYUlsqxAIIrv//////////ARABGgwwOTAxMTE5MzExNzAiDEgzXn1rTJPMg80/rSqYAhoWXHfkQlsqnkxTiaa+hA+GFGTeo0sr/PuK6kS9Zc1zhvGDvh8VYsnybGIcS5/48rY6a4uYytFOO8QMl2yIN3KS+aJnMSeLbhEdEem59/6D6MW0ELD2eoDCy8mZ3gHRObA5CM48FmgJAdT2M7e6WkFhQIDffMvznknInBDf6RmieIl0E0+gk1zXbI9sG7k6wZJM0ux2fHX873HRmOjCGH91ZgFZwHCZ9cAGYwoCpYC+IkRQ/m0HglM94gOWJm5hw+zu7ysCBxGBwFTnQQ7A0xMjKqUn4yWI3H45xDlSHHP6DCa2QAEVIq9MkfApIYUaIxW6vOy0z8+XiY6yZ1p9a38H9VkaGd3nwphX76nStAw1YEjcSWGzIQowktfvvAY6nQHH8CTlFQvMd0MKcWt3IHDj0wWbxe/k1ibmfypEzFmavJLgUL9Qkm4a5gyh7uJg3+Y8DGPJir3f/GWdGVB+dudN2VXQlW3Hy+rJ+wROE4grkItRDD2Sf92zcmMXqTf7tIvRxXibjvCKpp8DlMNbMgNLXdmaX+fsuuaud/oIuFlPkFNZVJYwRa2MQjVaVzqV/jeIbm0NL0C1OsLATWMx";
//
//
//
//    @Bean
//    public QueueMessagingTemplate queueMessagingTemplate() {
//        return new QueueMessagingTemplate(amazonSQSAsync());
//    }
//
//    public AmazonSQSAsync amazonSQSAsync() {
//
//        AmazonSQSAsyncClientBuilder amazonSQSAsyncClientBuilder = AmazonSQSAsyncClientBuilder.standard();
//        AmazonSQSAsync amazonSQSAsync = null;
//        amazonSQSAsyncClientBuilder.withRegion(Regions.US_EAST_1);
//        BasicSessionCredentials credentials = new BasicSessionCredentials(accessKeyId, secretAccessKey, token);
//        amazonSQSAsyncClientBuilder.withCredentials(new AWSStaticCredentialsProvider(credentials));
//        amazonSQSAsync = amazonSQSAsyncClientBuilder.build();
//        return amazonSQSAsync;
//
//    }
}

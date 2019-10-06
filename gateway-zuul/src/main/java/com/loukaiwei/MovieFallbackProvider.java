package com.loukaiwei;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

//要么在这里加Componet，要么在Config文件里面加
//@Component
public class MovieFallbackProvider implements FallbackProvider {
    @Override
    public String getRoute() {
        return "movie-service";//如果对所有微服务做回退，把这里设置为null
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
                httpHeaders.setContentType(mediaType);
                return httpHeaders;
            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(cause.getMessage().getBytes());
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 911;
            }

            @Override
            public String getStatusText() throws IOException {
                return "bu ke yong ";
            }

            @Override
            public void close() {

            }
        };
    }
}

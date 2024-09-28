//package com.freelance.skc.port.adapters.gw.filters;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.freelance.skc.port.adapters.backoffice.resource.common.RequestBodyValidator;
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.ErrorResponse;
//import org.springframework.web.util.ContentCachingResponseWrapper;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@Component
//@Order(1)
//public class FilterRequestValidation implements Filter {
//
//    @Value("${spring.datasource.backend.uri}")
//    private String BACKEND_URL;
//
//    @Override
//    public void doFilter(
//            ServletRequest servletRequest,
//            ServletResponse servletResponse,
//            FilterChain filterChain
//    ) throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        String backendUrl = BACKEND_URL + httpRequest.getRequestURI();
//        response.setContentType("application/json");
//
//        RequestBodyValidator.validateNotNullFields(httpRequest).ifPresentOrElse(
//                field -> {
//                    response.setStatus(HttpStatus.BAD_GATEWAY.value());
//                    PrintWriter writer;
//                    try {
//                        writer = response.getWriter();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                    writer.write("{\"error\": " + field + ", \"message\": \"Field is required\"}");
//                    writer.flush();
//
//                },
//                () -> {
//                    // чтобы пошел на след фильтры
//                    try {
//                        filterChain.doFilter(servletRequest,servletResponse);
//                    } catch (IOException | ServletException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//        );
//
//    }
//
//
//}
//

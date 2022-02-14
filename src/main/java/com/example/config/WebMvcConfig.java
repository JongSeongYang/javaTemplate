package com.example.config;


import com.example.interceptor.CommonInterceptor;
import com.example.interceptor.UserAuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final UserAuthInterceptor userAuthInterceptor;
    private final CommonInterceptor commonInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(commonInterceptor)
                        .addPathPatterns("/api/v1/**");

        registry.addInterceptor(userAuthInterceptor)
                .addPathPatterns("/api/v1/auth/**")
                .addPathPatterns("/api/v1/point/**")
                .addPathPatterns("/api/v1/wallet/**")
                .addPathPatterns("/api/v1/member/**")
                .addPathPatterns("/api/v1/fcm/**")
                .addPathPatterns("/api/v1/push/**")
                .addPathPatterns("/api/v1/products/**")
                .addPathPatterns("/api/v1/notice/qna/**")
                .addPathPatterns("/api/v1/notice/qna/**")
                .excludePathPatterns("/api/v1/auth")
                .excludePathPatterns("/api/v1/auth/mailStmp")
                .excludePathPatterns("/api/v1/auth/exist")
                .excludePathPatterns("/api/v1/auth/mail")
                .excludePathPatterns("/api/v1/fcm/device")
                .excludePathPatterns("/api/v1/member/phone")
//                .excludePathPatterns("/api/v1/notice/top")
//                .excludePathPatterns("/api/v1/notice")
//                .excludePathPatterns("/api/v1/notice/{noticeId}")
//                .excludePathPatterns("/api/v1/notice/category/**")
//                .excludePathPatterns("/api/v1/notice/faq/**")
                .excludePathPatterns("/api/v1/auth/password/reset")
                .excludePathPatterns("/api/v1/auth/mail/**")
                .excludePathPatterns("/api/v1/auth/sms/**")
                .excludePathPatterns("/api/v1/auth/request")
                .excludePathPatterns("/api/v1/auth/login")
                .excludePathPatterns("/api/v1/wallet/withdraw")
                .excludePathPatterns("/api/v1/wallet/deposit")
                .excludePathPatterns("/api/v1/wallet/exchange")
                .excludePathPatterns("/api/v1/wallet/klaytn/**");
    }
}

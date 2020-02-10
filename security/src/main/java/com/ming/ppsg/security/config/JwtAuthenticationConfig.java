package com.ming.ppsg.security.config;

import org.springframework.beans.factory.annotation.Value;

public class JwtAuthenticationConfig {

    @Value("${shuaicj.security.jwt.url:/auth/**}")
    private String url;

    @Value("${shuaicj.security.jwt.header:Authorization}")
    private String header;

    @Value("${shuaicj.security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${shuaicj.security.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${shuaicj.security.jwt.secret}")
    private String secret;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("JwtAuthenticationConfig{");
        sb.append("url='").append(url).append('\'');
        sb.append(", header='").append(header).append('\'');
        sb.append(", prefix='").append(prefix).append('\'');
        sb.append(", expiration=").append(expiration);
        sb.append(", secret='").append(secret).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
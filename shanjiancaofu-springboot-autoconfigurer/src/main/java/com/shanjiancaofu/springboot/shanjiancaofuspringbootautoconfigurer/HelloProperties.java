package com.shanjiancaofu.springboot.shanjiancaofuspringbootautoconfigurer;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my.hello")
public class HelloProperties {
    private String prifix;
    private String suffix;

    public String getPrifix() {
        return prifix;
    }

    public void setPrifix(String prifix) {
        this.prifix = prifix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}

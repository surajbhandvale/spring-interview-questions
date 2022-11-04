package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class SingletoneBean {

    @Autowired
    private PrototypeBean prototypeBean;

    public SingletoneBean(){
      log.info("Singleton instance created....");
    }

    public PrototypeBean getPrototypeBean(){
        return prototypeBean;
    }
}

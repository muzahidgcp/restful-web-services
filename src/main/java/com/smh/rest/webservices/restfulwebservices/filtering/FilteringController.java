package com.smh.rest.webservices.restfulwebservices.filtering;

//import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering(){
        SomeBean bean = new SomeBean("filed1","filed2","field3");
        //MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);
        return bean;
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList(){
        return Arrays.asList(new SomeBean("filed1","filed2","field3"),
                new SomeBean("filed4","filed5","field6"));
    }

}

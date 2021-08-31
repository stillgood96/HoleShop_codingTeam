package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;

// 126 page
@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController02 {

    @RequestMapping(value="/basic", method = {RequestMethod.GET, RequestMethod.POST})
    public void basicGet() {

        log.info("basic get........");
    }

    @GetMapping("/basicOnlyGet")
    public void basicGet2() {

        log.info("basic get only get........");
    }

    // 129page
    // Controller의 파라미터 수집 테스트
    // Controller를 작성할 때 가장 편리한 기능은 파라미터가 자동으로 수집되는 기능이다.
    //매번 request.getParameter()를 이용하는 불편함을 없앨 수 있다.
    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        log.info("" + dto);

        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
        log.info("name" + name);
        log.info("age" + age);

        return "ex02";
    }
}

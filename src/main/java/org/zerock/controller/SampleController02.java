package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

    // 리스트에 대한 처리
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids) {

        log.info("ids" + ids);

        return "ex02List";
    }

    // 배열에 대한 처리
    @GetMapping("/ex02Array")
    public String ex02Array(@RequestParam("ids") String [] ids) {

        log.info("ids" + ids);

        return "ex02Array";
    }

    // 133page
    // 만일 전달하는 데이터가 SampleDTO와 같이 객체 타입이고 여러 개를 처리해야 한다면
    // SampleDTO의 리스트를 포함하는 SampleDTOList 클래스를 설계해야한다.
    // 파라미터는 [인덱스]와 같은 형식으로 전달해서 처리할 수 있다.
    // ex) /ex02Bean?list[0].name=aaa&list[1].name=bbb
    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
        log.info("list dtos: " +list);

        return "ex02Bean";
    }

    // 135page
    // 파라미터를 자동으로 데이터변환을 해주지만
    // 경우에 따라서 파라미터를 변환해서 처리해주어야 한다.
    // 예를들어 2021-09-01과 같은 문자열로 전달된 데이터를 java.util.Date로 변환하는 작업이 그렇다.
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info("todo: " + todo );
        return "ex03";
    }
}

package org.zerock.controller;


import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Log4j
@Controller
public class SampleController {

    @GetMapping("/doA")
    public void doA() {

        log.info("doA Called .......................");
        log.info("-------------------------");
    }
}

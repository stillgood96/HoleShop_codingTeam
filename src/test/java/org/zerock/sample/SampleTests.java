package org.zerock.sample;


import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

// 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는 것을 나타내주는 Annotation
@RunWith(SpringJUnit4ClassRunner.class)
// 지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록한다. (스프링의 빈으로 등록된다 )
// servlet-context가 아닌 root-context로 지정된 이유는 servlet-context의 경우 웹 클라이언트 요청, view 관련에 대해 빈을 설정해주고
// root-context는 뷰와 관련이 없는 DB, service레이어의 빈을 설정하는데 여기서 테스트는 서비스 쪽담당..이니까 ?
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {

    @Autowired
    private Restaurant restaurant;

    @Test
    public void testExist() {

        assertNotNull(restaurant);

        log.info(restaurant);
        log.info("-------------------------");
        log.info(restaurant.getChef());
    }

}

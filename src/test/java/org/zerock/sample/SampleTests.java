package org.zerock.sample;


import lombok.Setter;
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
//Log4j는 Lombok을 이용해서 로그를 기록하는 Logger를 변수로 생성한다.
// 로그에 대한 설정은 src/main/resources에 properties파일로 존재한다.
@Log4j
public class SampleTests {

    // @Autowired는 해당 인스턴스 변수가 스프링으로부터 자동으로 주입해 달라는 표시이다.
    @Setter(onMethod_ = {@Autowired})
    private Restaurant restaurant;

    // @Test는 JUnit에서 테스트 대상을 표시하는 어노테이션
    @Test
    public void testExist() {

        // assertNotNull은 restaurant 변수가 null이 아니어야만 테스트가 성공한다는 것을 의미한다.
        assertNotNull(restaurant);

        log.info(restaurant);
        log.info("-------------------------");
        log.info(restaurant.getChef());
    }

    // 이 테스트 클래스로 주목해야하는 점.
    // 1. new Restaurant()와 같이 생성자를 이용하지 않았는데 객체가 만들어졌다는 점.
    // - 스프링은 관리가 필요한 객체(Bean)을 어노테이션 등을 이용해서 객체를 생성하고 관리하는 일종의 '컨테이너' 혹은 '팩토리'의 기능을 가지고 있습니다.

    // 2. Restaurant 클래스의 @Data 어노테이션으로 Lombok을 이용해서 여러 메서드가 만들어진 점
    // Lombok은 자동으로 getter/ setter 등을 만들어 주는데 스프링은 생성자 주입 혹은 setter 주입을 이용해서 동작한다.
    // Lombok을 통해서 getter/setter 등을 자동으로 생성하고 'onMethod' 속성을 이용해서 작성된 setter에 @Autowired 어노테이션을 추가한다.
    // 근데 오류나와서 나는 그냥 @Autowired 이용했다.

    // 3. Restaurant 객체의 Chef 인스턴스 변수(멤버변수)에 Chef 타입의 객체가 주입되어 있다는 점
    // 스프링은 @Autowired와 같은 어노테이션을 이용해서 개발자가 직접 객체들과의 관계를 관리하지 않고 자동으로 관리되도록 한다.



}

package org.zerock.sample;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;
// @Data는 Lombok에서 가장 자주 사용되는 어노테이션이다.
// @ToString, @EqualsAndHashCode, @Getter / Setter, @RequiredArgsConstructor를 모두 결합한 형태로
// 한번에 자주 사용되는 메서드들을 생성할 수 있다는 장점이 있다.
@Component
@Data
public class Restaurant {

    // @Autowired는 스프링 내부에서 자신이 특정한 객체에 의존적이므로 자신에게 해당 타입의 빈을 주입해주라는 표시이다.
    @Setter(onMethod_ = {@Autowired})
    private Chef chef;

}

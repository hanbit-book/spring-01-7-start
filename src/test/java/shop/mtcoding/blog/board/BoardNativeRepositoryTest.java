package shop.mtcoding.blog.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(BoardNativeRepository.class) // 내가 만든 해당 객체를 테스트 전용 IoC에 로드
@DataJpaTest // DB 관련 모든 객체를 IoC에 로드
public class BoardNativeRepositoryTest {

    @Autowired // DI
    private BoardNativeRepository boardNativeRepository;

    @Test
    public void save_test(){
        // given (데이터 준비)
        String title = "제목6";
        String content = "내용6";

        // when (insert 메서드 테스트)
        boardNativeRepository.save(title, content);
    } // 메서드 종료시 자동 rollback이 됩니다.
}

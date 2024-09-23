package shop.mtcoding.blog.board;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardNativeRepository.class) // 내가 만든 해당 객체를 테스트 전용 IoC에 로드
@DataJpaTest // DB 관련 모든 객체를 IoC에 로드
public class BoardNativeRepositoryTest {

    @Autowired // DI
    private BoardNativeRepository boardNativeRepository;

    @Test
    public void findById_test(){
        int id = 1;
        Board board = boardNativeRepository.findById(id);
        Assertions.assertThat(board.getTitle()).isEqualTo("제목1");
        Assertions.assertThat(board.getContent()).isEqualTo("내용1");
    }

    @Test
    public void findAll_test(){
        List<Board> boards = boardNativeRepository.findAll();
        Assertions.assertThat(boards.get(0).getId()).isEqualTo(5);
        Assertions.assertThat(boards.get(0).getTitle()).isEqualTo("제목5");
        Assertions.assertThat(boards.get(0).getContent()).isEqualTo("내용5");
    }

    @Test
    public void save_test(){
        // given (데이터 준비)
        String title = "제목6";
        String content = "내용6";

        // when (insert 메서드 테스트)
        boardNativeRepository.save(title, content);
    } // 메서드 종료시 자동 rollback이 됩니다.
}

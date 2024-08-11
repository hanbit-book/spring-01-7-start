package shop.mtcoding.blog.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// 생략...
@Controller
public class BoardController {

    // 1. @Repository로 IoC에 등록된 객체를 DI합니다.
    @Autowired
    private BoardNativeRepository boardNativeRepository;

    // 2. Post 메서드로 사용자에게 데이터를 전달받을 수 있습니다.
    // 3. input태그의 name값과 동일한 이름으로 매개변수에 변수명을 적으면 값을 전달받을 수 있습니다.
    @PostMapping("/board/save")
    public String boardSave(String title, String content){
        // 4. 레포지토리에게 DB에 저장해달라고 요청합니다.
        boardNativeRepository.save(title, content);
        // 5. DB에 저장되면, /board 요청으로 리다이렉션(302) 합니다.
        return "redirect:/board";
    }
    // 생략...

    @GetMapping("/board")
    public String boardList(){
        return "board/list";
    }

    @GetMapping("/board/save-form")
    public String boardSaveForm(){
        return "board/save-form";
    }

    @GetMapping("/board/1")
    public String boardDetail(){
        return "board/detail";
    }

    @GetMapping("/board/1/update-form")
    public String boardUpdateForm(){
        return "board/update-form";
    }
}

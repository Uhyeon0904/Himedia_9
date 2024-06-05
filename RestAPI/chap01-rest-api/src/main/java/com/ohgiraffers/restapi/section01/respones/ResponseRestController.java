package com.ohgiraffers.restapi.section01.respones;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* RestController: 기존에는 뷰로 응답을 해줬지만 REST는 데이터로 응답을 한다.
* 응답 값이 resBody로 처리가 된다. */
@RestController
@RequestMapping("/res")
public class ResponseRestController {

    /* 1. 문자열 응답 */
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    /* 2. 기본 자료형 응답 */
    @GetMapping("/random")
    public int getRandomNumber() {
        return (int)(Math.random() * 1000) + 1;
    }

    /* 3. Object 응답 */
    @GetMapping("/message")
    public Message getMessage() {
        return new Message(200, "메세지를 응답합니다.");
    }

    /* 4. List 응답 */
    @GetMapping("/list")
    public List<String> getList() {
        return List.of(new String[] {"사과", "바나나", "복숭아"});
    }

    /* 5. Map 응답 */
    @GetMapping("/map")
    public Map<Integer, String> getMap() {
        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(200, "정상 응답"));
        messageList.add(new Message(404, "페이지를 찾을 수 없습니다."));
        messageList.add(new Message(500, "개발자의 잘못입니다."));
        /* toMap: 키와 값으로 이뤄져야 하는데 키는
        * Message 클래스에 httpStatusCode이고, 값은 message로 설정 */
        return messageList
                .stream()
                .collect(Collectors
                        .toMap(Message::getHttpStatusCode, Message::getMessage));
    }

    /* 6. 파일 응답 */
    /* produces = MediaType.IMAGE_PNG_VALUE: 이미지 응답 상태를 PNG로 */
    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage() throws IOException {
        /* 디렉토리에 있는 경로를 읽고 바이트 타입으로 읽겠다. */
        return getClass().getResourceAsStream("/images/spring.png").readAllBytes();
    }

    /* 7. ResponseEntity 응답
    * body, headers, status 객체를 만들 수 있다는 장점이 있다. */
    @GetMapping("/entity")
    public ResponseEntity<Message> getEntity() {
        /* 요청 응답이 200(요청 성공) 이라면 반환 데이터는 123, "hello world"가 나온다. */
        return ResponseEntity.ok(new Message(123, "hello world"));
    }
}

package com.ohgiraffers.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    /* main.html -> form action ="single-file" 매칭 */
    @PostMapping("/single-file")
    public String singleFileUpload(@RequestParam String singleFileDescription,
                                   /* 파일은 받아오는 타입이 MultipartFile 형식으로 받아와야 한다.
                                   * @RequestParam 생략 가능, 단, 파라미터 이름이 인자 이름과 같아야 된다. */
                                   @RequestParam MultipartFile singleFile,
                                   Model model) {

        System.out.println("singleFileDescription = " + singleFileDescription);
        System.out.println("singleFile = " + singleFile);

        /* 서버로 전달 된 File을 서버에서 설정하는 경로에 저장한다. */
        String root = "src/main/resources/static";
        String filePath = root + "/uploadFiles";
        File dir = new File(filePath);
        /* 파일 경로를 컨트롤 할 수 있는 기능이 있다. */

        System.out.println("dir = " + dir.getAbsolutePath());
        /* getAbsolutePath(): 절대 경로 */

        if (!dir.exists()) dir.mkdirs();
        /* dir 경로가 존재하지 않는다면 경로를 만들어라, /uploadFiles: 현재 이 경로는 없으므로 생성 */

        /* 파일명 변경 처리 */
        String originFileName = singleFile.getOriginalFilename();
        /* getOriginalFilename(): 사용자가 등록한 파일의 이름 원본을 가져온다.
        * 예) 고양이, 냐옹냐옹; 확장자는 가져오지 않는다. */

        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        /* lastIndexOf("."): 파일 이름의 마지막 점의 인덱스를 찾는다.
        *  substring(): . 점 기준으로 문자열 끝까지를 반환한다. */

        String saveName = UUID.randomUUID() + ext;
        /* UUID: 유니크한 아이디를 만들어주는 기능
        * randomUUID(): 랜덤으로 생성 */

        // 파일 저장
        try {
            singleFile.transferTo(new File(filePath + "/" + saveName));
            model.addAttribute("message", "파일 업로드 완료!");
        } catch (IOException e) {
            model.addAttribute("message", "파일 업로드 실패!");
        }

        return "result";
    }

    @PostMapping("/multi-file")
    public String multiFileUpload(@RequestParam String multiFileDescription,
                                 @RequestParam List<MultipartFile> multiFile,
                                 Model model) {

        System.out.println("multiFileDescription = " + multiFileDescription);
        System.out.println("multiFile = " + multiFile);

        /* 서버로 전달 된 File을 서버에서 설정하는 경로에 저장한다. */
        String root = "src/main/resources/static";
        String filePath = root + "/uploadFiles";
        File dir = new File(filePath);
        System.out.println(dir.getAbsoluteFile());

        if (!dir.exists()) dir.mkdirs();

        List<FileDTO> files = new ArrayList<>();

        /* 파일명 변경 처리 후 저장 : 다중 파일 반복문 처리 */
        try {
            for (MultipartFile file : multiFile) {
                String originFileName = file.getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                String saveName = UUID.randomUUID() + ext;

                /* 파일에 관한 정보 추출 후 보관 */
                files.add(new FileDTO(originFileName, saveName, filePath, multiFileDescription));

                /* 파일 저장*/
                file.transferTo(new File(filePath + "/" + saveName));
            }
            /* 서버의 정해진 경로로 파일 저장이 완료 되면
            * LIST<FileDTO> 타입의 객체에 저장된 정보를 DB에 Insert 한다.*/
            model.addAttribute("message", "파일 업로드 완료!");

        } catch (IOException e) {
            /* 파일 저장 중간에 실패 시 이전에 저장 된 파일 삭제 */
            for (FileDTO file : files) {
                new File(filePath + "/" + file.getSavedName()).delete();
                model.addAttribute("message", "파일 업로드 실패!");
            }
        }

        return "result";
    }
}

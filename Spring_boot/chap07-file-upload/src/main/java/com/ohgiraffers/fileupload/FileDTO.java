package com.ohgiraffers.fileupload;


/* 업로드 된 파일과 관련한 정보를 모아서 관리하는 DTO */
public class FileDTO {

    private String originFileNam;
    /* 원본 파일 이름 */

    private String savedName;
    /* 저장 이름 */

    private String filePath;
    /* 파일 경로 */

    private String fileDescription;
    /* 파일 설명 */

    public FileDTO() {}

    public FileDTO(String originFileNam, String savedName, String filePath, String fileDescription) {
        this.originFileNam = originFileNam;
        this.savedName = savedName;
        this.filePath = filePath;
        this.fileDescription = fileDescription;
    }

    public String getOriginFileNam() {
        return originFileNam;
    }

    public void setOriginFileNam(String originFileNam) {
        this.originFileNam = originFileNam;
    }

    public String getSavedName() {
        return savedName;
    }

    public void setSavedName(String savedName) {
        this.savedName = savedName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "originFileNam='" + originFileNam + '\'' +
                ", savedName='" + savedName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                '}';
    }
}

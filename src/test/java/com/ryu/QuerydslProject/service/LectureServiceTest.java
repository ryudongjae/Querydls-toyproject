package com.ryu.QuerydslProject.service;

import com.ryu.QuerydslProject.domain.Lecture.Lecture;
import com.ryu.QuerydslProject.repository.lecture.LectureRepository;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.EntityManager;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class LectureServiceTest {

    @Autowired
    LectureService lectureService;
    @Autowired
    LectureRepository lectureRepository;
    
    @Test
    @DisplayName("")
    void duplicate_lecture()throws Exception{
        //given
        
        //when
        
        //then
        
    
    }
    
    @Test
    @DisplayName("")        
    void lecture_save()throws Exception{
        //given
        
        //when
        
        //then
        
    
    }
    
    @Test
    @DisplayName("")        
    void lecture_saveByPhoto()throws Exception{
        //given
        
        //when
        
        //then
        
    
    }
    
    @Test
    @DisplayName("")        
    void lecture_update()throws Exception{
        //given
        
        //when
        
        //then
        
    
    }
    
    @Test
    @DisplayName("")        
    void lecture_find()throws Exception{
        //given
        
        //when
        
        //then
        
    
    }
    private Lecture getLecture(FileInfo fileInfo) throws URISyntaxException {
        URI uri = new URI("https://www.inflearn.com/");
        Lecture lecture = new Lecture("?????????", "?????????", "?????????", fileInfo.getFilePath(), fileInfo.getFileSize(), fileInfo.getFileName(), "?????????", uri);
        lectureService.join(lecture);
        return lecture;
    }
    private MultipartFile getMultipartFile(Lecture lecture) throws IOException {
        File file = new File(new File("").getAbsolutePath() + "/src/main/resources/static"+ lecture.getRepresentImagePath());
        FileItem fileItem = new DiskFileItem("newFile", Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());


        try {
            InputStream input = new FileInputStream(file);
            OutputStream os = fileItem.getOutputStream();
            IOUtils.copy(input, os);

        } catch (IOException ex) {

        }

        //????????? ?????? ?????? multipartfile??? ????????????
        MultipartFile mFile1 = new CommonsMultipartFile(fileItem);
        return mFile1;
    }

    private MultipartFile getMultipartFile() throws IOException {
        File file = new File(new File("").getAbsolutePath() + "/src/main/resources/static/images/jpa.png");
        FileItem fileItem = new DiskFileItem("originFile", Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());

        try {
            InputStream input = new FileInputStream(file);
            OutputStream os = fileItem.getOutputStream();
            IOUtils.copy(input, os);
        } catch (IOException ex) {

        }

        //jpa.png -> multipart ??????
        MultipartFile mFile = new CommonsMultipartFile(fileItem);
        return mFile;
    }
}
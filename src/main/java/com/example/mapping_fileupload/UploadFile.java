package com.example.mapping_fileupload;

import java.io.File;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadFile {

    private final String file_dir = "D:\\mapping_fileupload\\src\\main\\resources\\static\\images";  // Static location for file  ensure to mack use of \\   when you assign path in windows 

    public boolean fileUpload(MultipartFile mFile){

        boolean f=false;

        try {
    
            Files.copy(mFile.getInputStream(),Paths.get(file_dir+File.separator+mFile.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
            f=true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }


    
}

package com.example.mapping_fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {
    @Autowired
    UploadFile uploadFile;
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file){


       try {
        
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Resorce Not Found ");
        }

        if(!file.getContentType().equals("image/jpeg")){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG File formet allow  "); 

        }
       
     boolean f=uploadFile.fileUpload(file);
     if(f==true){
        return ResponseEntity.ok(" Receved ");

          }


       

       } catch (Exception e) {
      
                  e.printStackTrace(); 
                      
       }

       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("  Bhai koi error ho gya haai theek krtehai "); 

    }
    
}

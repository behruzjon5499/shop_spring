package com.clean.code.springboot.service;

import com.clean.code.springboot.model.FileStorage;
import com.clean.code.springboot.repository.FileStorageRepository;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FileStorageService {
    private final FileStorageRepository fileStorageRepository;

    @Value("${upload.folder}")
    private String uploadFolder;
    private final Hashids hashids;
    public FileStorageService(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
        this.hashids = new Hashids(getClass().getName(),6);
    }

    public void save(MultipartFile multipartFile) {

        FileStorage fileStorage = new FileStorage();
        fileStorage.setName(multipartFile.getName());
        fileStorage.setExtension(getExt(multipartFile.getOriginalFilename()));
        fileStorage.setFileSize(multipartFile.getSize());
        fileStorage.setContentType(multipartFile.getContentType());
        fileStorageRepository.save(fileStorage);

        Date now = new Date();
        File uploadFolder = new File(String.format("%s/upload/upload_files/%d/%d/%d/",this.uploadFolder,1900+now.getYear(),1+now.getMonth(),now.getDate()));

        if(!uploadFolder.exists() && uploadFolder.mkdirs()){
            System.out.println("aytilgan papkalar yaratildi");
        }
        fileStorage.setHashId(hashids.encode(fileStorage.getId()));
        fileStorage.setUploadPath(String.format("upload/upload_files/%d/%d/%d/%s.%s",1900+now.getYear(),1+now.getMonth(),now.getDate(),fileStorage.getHashId(),fileStorage.getExtension()));

        fileStorageRepository.save(fileStorage);
        uploadFolder = uploadFolder.getAbsoluteFile();
        File file = new File(uploadFolder,String.format("%s.%s",fileStorage.getHashId(),fileStorage.getExtension()));

        try{
            multipartFile.transferTo(file);
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

    public String getExt(String fileName) {

        String ext = null;

        if (fileName != null && !fileName.isEmpty()) {
            int dot = fileName.lastIndexOf(".");
            if (dot > 0 && dot < fileName.length()) {
                ext = fileName.substring(dot + 1);
            }
        }
        return ext;
    }


  @Transactional(readOnly = true)
    public FileStorage findByHashId(String hashId){
        return fileStorageRepository.findByHashId(hashId);
  }
  public void delete(String hashId){
        FileStorage fileStorage = fileStorageRepository.findByHashId(hashId);
        File file = new File(String.format("%s/%s",this.uploadFolder,fileStorage.getUploadPath()));
        if (file.delete()){
            fileStorageRepository.delete(fileStorage);
        }
  }
}

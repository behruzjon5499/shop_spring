package com.clean.code.springboot.service;

import com.clean.code.springboot.model.FileStorage;
import com.clean.code.springboot.repository.FileStorageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
    private final FileStorageRepository fileStorageRepository;


    public FileStorageService(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
    }
    public void save(MultipartFile multipartFile){

        FileStorage fileStorage = new FileStorage();
        fileStorage.setName(multipartFile.getName());
        fileStorage.setExtension(getExt(multipartFile.getOriginalFilename()));
        fileStorage.setFileSize(multipartFile.getSize());
        fileStorage.setContentType(multipartFile.getContentType());
        fileStorageRepository.save(fileStorage);
    }
  public String getExt(String fileName){

        String ext  =null;

        if (fileName!=null && !fileName.isEmpty()){
            int dot = fileName.lastIndexOf(".");
            if (dot > 0 && dot < fileName.length()){
                ext= fileName.substring(dot+1);
            }
        }
        return ext;
  }
}

package com.uditkumawat.craftproject.service;

import com.uditkumawat.craftproject.model.DocumentType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AWSStorageServiceImpl implements StorageService{

    @Override
    public String saveFile(MultipartFile file, Long driverId, DocumentType docType){
        return null;
    }
}

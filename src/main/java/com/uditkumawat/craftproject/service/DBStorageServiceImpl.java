package com.uditkumawat.craftproject.service;

import com.uditkumawat.craftproject.exception.FileStorageException;
import com.uditkumawat.craftproject.model.Document;
import com.uditkumawat.craftproject.model.DocumentType;
import com.uditkumawat.craftproject.model.Driver;
import com.uditkumawat.craftproject.repository.DocumentRepository;
import com.uditkumawat.craftproject.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBStorageServiceImpl implements StorageService{

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public String saveFile(MultipartFile file,Long driverId,DocumentType documentType) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Driver driver = driverRepository.getById(driverId);

            Document document = new Document(fileName, documentType, file.getBytes(),driver);
            documentRepository.save(document);
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
}

package com.uditkumawat.craftproject.service;

import com.uditkumawat.craftproject.exception.FileStorageException;
import com.uditkumawat.craftproject.model.Document;
import com.uditkumawat.craftproject.model.DocumentType;
import com.uditkumawat.craftproject.model.Driver;
import com.uditkumawat.craftproject.repository.DocumentRepository;
import com.uditkumawat.craftproject.repository.DriverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBStorageServiceImpl implements StorageService{

    private static final Logger logger = LoggerFactory.getLogger(DBStorageServiceImpl.class);

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public String saveFile(MultipartFile file,Long driverId,DocumentType documentType) throws FileStorageException{
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
        } catch(Exception ex){
            logger.error("Exception occurred while saving file for driverId {} and docType {}",driverId,documentType,ex);
            throw ex;
        }
    }
}

package com.uditkumawat.craftproject.controller;

import com.uditkumawat.craftproject.exception.FileStorageException;
import com.uditkumawat.craftproject.exception.NoSuchDriverExistsException;
import com.uditkumawat.craftproject.model.DocumentType;
import com.uditkumawat.craftproject.model.UploadFileResponse;
import com.uditkumawat.craftproject.service.DriverService;
import com.uditkumawat.craftproject.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Controller for handling API request for uploading documents.
 */

@RestController
public class DocumentsUploadController {

    private static final Logger logger = LoggerFactory.getLogger(DocumentsUploadController.class);

    @Autowired
    @Qualifier("DBStorageServiceImpl")
    private StorageService storageService;

    @Autowired
    private DriverService driverService;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
                                         @RequestParam("driverId") Long driverId,
                                         @RequestParam("docType") DocumentType docType) throws NoSuchDriverExistsException, FileStorageException {

        logger.info("Document upload for driverId {} and documentType {}", driverId, docType);
        try {
            String fileName = storageService.saveFile(file, driverId, docType);

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();

            //once the documents are uploaded , setting documentsUploaded flag to true
            driverService.setDocumentsUploadedFlag(driverId);

            return new UploadFileResponse(fileName, fileDownloadUri,
                    file.getContentType(), file.getSize());
        }catch(Exception ex){
            logger.error("Exception while uploading document for driverId {} and documentType {}", driverId, docType);
            throw ex;
        }
    }

}

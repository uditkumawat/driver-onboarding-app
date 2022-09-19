package com.uditkumawat.craftproject.service;

import com.uditkumawat.craftproject.model.DocumentType;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    String saveFile(MultipartFile file, Long driverId, DocumentType docType);
}

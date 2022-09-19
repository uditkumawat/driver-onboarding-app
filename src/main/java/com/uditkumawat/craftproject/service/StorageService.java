package com.uditkumawat.craftproject.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    String saveFile(MultipartFile file);
}

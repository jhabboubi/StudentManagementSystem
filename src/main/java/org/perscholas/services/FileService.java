package org.perscholas.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.dao.IAuthGroupRepo;
import org.perscholas.dao.IImagesRepo;
import org.perscholas.exceptions.FileStorageException;
import org.perscholas.models.Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@Slf4j
public class FileService {

    IImagesRepo iImagesRepo;

    @Autowired
    public FileService(IImagesRepo iImagesRepo) {
        this.iImagesRepo = iImagesRepo;
    }

    //   /Users/habboubi/IdeaProjects/sms/src/main/webapp/mvc.png
    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

        public Long uploadFile(MultipartFile file) {
            Images img;
            try {

                // file name clean up!

                log.warn(file.getContentType());
                String filename = StringUtils.cleanPath(file.getOriginalFilename());
                // location of file on disk
                Path copyLocation = Paths.get(uploadDir + File.separator + filename);
                // saving file to location and setting what happens in case of duplicate file name
                Files.copy(file.getInputStream(),copyLocation, StandardCopyOption.REPLACE_EXISTING);
                // saving filename to database for future reference
                img = iImagesRepo.save(new Images(filename));

                // handling exception
            } catch (Exception e) {
                e.printStackTrace();
                throw new FileStorageException("Could not store file " + file.getOriginalFilename() + ". Please try again.");
            }
            log.warn("returned Long ID: " + img.getId() + " Image name: " + img.getImageName());
            return img.getId();
        }





        // getting all images
        public List<Images> getAllImages(){
            return iImagesRepo.findAll();
        }
}

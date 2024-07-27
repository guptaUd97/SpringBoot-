package com.spring.imgupload.Service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.imgupload.Model.ImageData;
import com.spring.imgupload.Repo.StroageRepo;
import com.spring.imgupload.Util.ImageUtils;

@Service
public class ImageService {
	
	@Autowired
	private StroageRepo stroageRepo;
	
	 public String uploadImage(MultipartFile file) throws IOException {

	        ImageData imageData = stroageRepo.save(ImageData.builder()
	                .name(file.getOriginalFilename())
	                .type(file.getContentType())
	                .imageData(ImageUtils.compressImage(file.getBytes())).build());
	        if (imageData != null) {
	            return "file uploaded successfully : " + file.getOriginalFilename();
	        }
	        return null;
	    }

	    public byte[] downloadImage(String fileName){
	        Optional<ImageData> dbImageData = stroageRepo.findByName(fileName);
	        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
	        return images;
	    }

}

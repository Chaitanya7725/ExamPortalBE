package com.exam.crud.example.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exam.crud.example.entity.Image;
import com.exam.crud.example.service.ImageService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path = "image")
public class ImageController {

	@Autowired
	private ImageService service;
	
	@PostMapping("/upload")
	public ResponseEntity<String> addImage(@RequestParam("imageFile") MultipartFile file) {
		return service.addImages(file);
	}
	
	@GetMapping("/{imageName}")
	public Image getImage(@PathVariable("imageName") String imageName) throws IOException {

		Image img = service.findByName(imageName);
		return img;
	}
	
	@GetMapping("/getallimages")
	public List<Image> getImages() throws IOException {
		return service.getAllImages();
	}
}

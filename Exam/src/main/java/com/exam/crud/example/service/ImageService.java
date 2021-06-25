package com.exam.crud.example.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exam.crud.example.entity.Image;
import com.exam.crud.example.respository.ImageRepository;

@Service
public class ImageService {
	
	@Autowired
	private ImageRepository repository;

	public ResponseEntity<String> addImages(MultipartFile file) {
		
		Image img = null;
		try {
			img = new Image(file.getOriginalFilename(), file.getContentType(),compressBytes(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		repository.save(img);
		return new ResponseEntity<String>("Image uploaded successfully", HttpStatus.OK);
	}

	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

	public Image findByName(String imageName) throws IOException {

		final Optional<Image> retrievedImage = repository.findByName(imageName);
		Image img = new Image(retrievedImage.get().getId(), retrievedImage.get().getName(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getPicByte()));
		return img;
	}

	public java.util.List<Image> getAllImages() {
		java.util.List<Image> final1=new ArrayList<>();
		java.util.List<Image> retrievedImage = repository.findAll();
		for (Image image : retrievedImage) {
			Image img = new Image(image.getId(), image.getName(), image.getType(),
					decompressBytes(image.getPicByte()));
			final1.add(img);
		}
		return final1;
	}
	
}

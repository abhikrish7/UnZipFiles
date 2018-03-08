package com.unzip;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.unzip.bo.UnZipBO;

@SpringBootApplication
public class UnZipApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(UnZipApplication.class, args);
		UnZipBO unZip = context.getBean(UnZipBO.class);
		System.out.println("*******Started UnZipping Files********");
		try {
			unZip.UnZipFiles();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("*******Completed UnZipping Files********");
	}
}

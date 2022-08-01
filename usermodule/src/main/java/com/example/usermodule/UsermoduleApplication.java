package com.example.usermodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.placementmodule.PlacementmoduleApplication;
import com.example.studentmodule.StudentmoduleApplication;
import com.example.adminmodule.AdminmoduleApplication;
import com.example.certificatemodule.CertificatemoduleApplication;
import com.example.collegemodule.CollegemoduleApplication;

@Import({PlacementmoduleApplication.class,StudentmoduleApplication.class,AdminmoduleApplication.class,CollegemoduleApplication.class,CertificatemoduleApplication.class})
@SpringBootApplication
public class UsermoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermoduleApplication.class, args);
	}
	
}

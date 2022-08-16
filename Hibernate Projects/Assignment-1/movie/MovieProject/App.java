package com.movie.MovieProject;

import java.io.IOException;
import java.util.Scanner;

import com.service.MovieService;

public class App {
    public static void main( String[] args ) throws IOException {
    	Scanner input = new Scanner(System.in);
    	
    	MovieService movieService = new MovieService();
    	String option;
    	boolean loop;
    	
    	do {
    		loop = true;
    		
    		System.out.println("Enter-1: To add Movie details");
    		System.out.println("Enter-2: To get Movie details");
    		System.out.println("Enter-3: To update Movie details");
    		System.out.println("Enter-4: To delete Movie details");
    		System.out.println("Enter-5: To exit");
    		System.out.println("-------------------------------------------");
    		
    		System.out.println("Please enter your option: ");
    		option = input.nextLine();
    		
    		switch (option) {
				case "1":
					System.out.println(movieService.addMovieDetails());
					break;
				case "2":
					System.out.println(movieService.getMovieDetails());
					break;
				case "3":
					System.out.println(movieService.updateMovieDetails());
					break;
				case "4":
					System.out.println(movieService.deleteMovieDetails());
					break;
				case "5":
					loop = false;
					break;
				default:
					System.out.println("You entered wrong option \n");
					break;
			}
    	} while (loop);
       
    }
}

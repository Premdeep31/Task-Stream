package com.jackle.FilmCorporation;

import java.io.IOException;
import java.util.Scanner;
import com.service.HollywoodService;

public class App {
    public static void main( String[] args ) throws IOException {
    	Scanner input = new Scanner(System.in);
    	HollywoodService hs = new HollywoodService();
    	boolean loop;
    	int option;
    	
    	do {
    		loop = true;
    		
    		System.out.println("\n\n---------------------------------------------------------");
    		System.out.println("Press-1: To get Movie details");
    		System.out.println("Press-2: To get Movies by Director name");
    		System.out.println("Press-3: To add English Movies in Hollywood table");
    		System.out.println("Press-4: To update revenue by 100000 dollars");
    		System.out.println("Press-5: To delete Movie");
    		System.out.println("Press-6: To find distinct languages in Movie table");
    		System.out.println("Press-7: To get Movie name and its Director");
    		System.out.println("Press-8: To Exit");
    		System.out.println("---------------------------------------------------------");
    		System.out.println("Enter your option: ");
  
    		option = input.nextInt();    				
    		
    		switch (option) {
				case 1:
					hs.getMoviesByLanguge();
					break;
					
				case 2:
					hs.getMoviesByDirector();
					break;
					
				case 3:
					hs.addMovies();
					break;
					
				case 4:
					hs.updateRevenue();
					break;
					
				case 5: 
					hs.deleteMovie();
					break;
					
				case 6:
					hs.getDistinctLanguages();
					break;
					
				case 7:
					hs.getMovieAndDirector();
					break;
					
				case 8:
					loop = false;
					System.out.println("Exit Completed \n =================================================");
					break;
	
				default:
					System.out.println("You entered wrong option!");
					break;
			}
    	} while (loop);
    
    }
}

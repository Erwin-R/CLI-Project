package com.potatochip;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Hello world!");
        System.out.println("""
                1️⃣ - Book Car
                2️⃣ - View All User Booked Cars
                3️⃣ - View All Bookings
                4️⃣ - View Available Cars
                5️⃣ - View Available Electric Cars
                6️⃣ - View all users
                7️⃣ - Exit
                """);

        Scanner scanner = new Scanner(System.in);

        while(true){
            int input = scanner.nextInt();
            if(input == 6){
                ;
            }
            if(input == 7){
                break;
            }

        }


    }
}
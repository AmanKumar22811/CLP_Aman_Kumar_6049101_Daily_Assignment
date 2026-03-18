package com.example.springDataJpaAssignment;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springDataJpaAssignment.entities.Trainee;
import com.example.springDataJpaAssignment.repositories.ITraineJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ITraineJpaRepository traineeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Insert Trainee");
            System.out.println("2. List All Trainees");
            System.out.println("3. List Trainee by ID");
            System.out.println("4. Update Trainee");
            System.out.println("5. Delete Trainee by ID");
            System.out.println("6. Exit");
            
            System.out.print("Enter your choice : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // 1 Insert
                case 1:
                    Trainee t = new Trainee();
                    System.out.print("Enter Name : ");
                    t.setTarineeName(sc.nextLine());

                    System.out.print("Enter Domain : ");
                    t.setDomain(sc.nextLine());

                    System.out.print("Enter Location: ");
                    t.setLocation(sc.nextLine());

                    traineeRepository.save(t);
                    
                    System.out.println("Trainee Inserted Successfully!");
                    break;

                // 2️ List All
                case 2:
                    List<Trainee> list = traineeRepository.findAll();
                    
                    System.out.println("\nAll Trainees : ");
                    
                    list.forEach(System.out::println);
                    break;



                // 3 Find by ID
                case 3:
                    System.out.print("Enter ID : ");
                    int id = sc.nextInt();

                    Optional<Trainee> trainee = traineeRepository.findById(id);
                    
                    if (trainee.isPresent()) {
                        System.out.println(trainee.get());
                    } else {
                        System.out.println("Trainee not found!");
                    }
                    break;

                // 4 Update
                case 4:
                    System.out.print("Enter ID to Update : ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Optional<Trainee> existing = traineeRepository.findById(updateId);

                    if (existing.isPresent()) {
                        Trainee tr = existing.get();

                        System.out.print("Enter New Name : ");
                        tr.setTarineeName(sc.nextLine());

                        System.out.print("Enter New Domain : ");
                        tr.setDomain(sc.nextLine());

                        System.out.print("Enter New Location: ");
                        tr.setLocation(sc.nextLine());

                        traineeRepository.save(tr);
                        System.out.println("Updated Successfully!");
                    } else {
                        System.out.println("Trainee not found!");
                    }
                    break;

                // 5 Delete
                case 5:
                    System.out.print("Enter ID to Delete : ");
                    int deleteId = sc.nextInt();

                    traineeRepository.deleteById(deleteId);
                    
                    System.out.println("Deleted Successfully!");
                    break;

                // 6 Exit
                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
package sia.sdjpa;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SdJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdJpaApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(BookstoreService bookstoreService) {
        return args -> {
            System.out.println("\nInsert author with books  ...");
            bookstoreService.insertAuthorWithBooks();

            System.out.println("\nDelete a book of an author...");
            bookstoreService.deleteBookOfAuthor();

            System.out.println("\nDelete all book of an author...");
            bookstoreService.deleteAllBooksOfAuthor();
        };
    }
}

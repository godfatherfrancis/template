package main.java.com.highresfelix.review;

/**
 * created by @highresfelix on 8/30/19
 */

public class Product {
    String title;
    String author;
    String genre;

    public Product() {

    }

    @Override
    public String toString() {
        String contents = String.format("Title: %s, Author: %s, Genre: %s", this.title, this.author, this.genre);
        return contents;
    }

    public void prompt() {
        System.out.println("Please enter information about a album/book/game");

        System.out.println("Enter Title:");
        title = ProductReview.nextLine();

        System.out.println("Enter author:");
        author = ProductReview.nextLine();

        System.out.println("Enter genre:");
        genre = ProductReview.nextLine();

        System.out.println("Information entered.");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

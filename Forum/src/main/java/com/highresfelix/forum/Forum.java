package main.java.com.highresfelix.forum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * created by @highresfelix on 9/3/19
 */

public class Forum {

    public static void main(String[] args) throws IOException {
        ArrayList<Post> posts = readFile();

        Scanner consoleScanner = new Scanner(System.in);

        int replyId = -1;
        while (true) {
            // loop over posts and print the ones with the right reply id
            printPosts(posts, replyId);
            // ask the user to type a new reply id
            System.out.println("Type the id you want to see replies to:");
            replyId = Integer.valueOf(consoleScanner.nextLine());
        }
    }

    private static void printPosts(ArrayList<Post> posts, int replyId) {
        int id = 0;
        for (Post post : posts) {
            if (post.replyId == replyId) {
                System.out.printf("(%d) %s by %s\n", id, post.text, post.author);
            }
            id++;
        }
    }

    private static ArrayList<Post> readFile() throws FileNotFoundException {
        ArrayList<Post> posts = new ArrayList<>();

        // read all the post into memory
        File file = new File("post.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] columns = line.split("\\|");
            Post post = new Post(Integer.valueOf(columns[0]), columns[1], columns[2]);
            posts.add(post);
        }
        return posts;
    }
}

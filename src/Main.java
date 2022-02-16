import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProgrammingBook b1 = new ProgrammingBook("B1", "OOP", 50, "AuthorA", "Java", "Spring1");
        ProgrammingBook b2 = new ProgrammingBook("B2", "Website", 40, "AuthorB", "PHP", "Spring2");
        ProgrammingBook b3 = new ProgrammingBook("B3", "GameDevelop", 60, "AuthorC", "Ruby", "Spring3");
        ProgrammingBook b4 = new ProgrammingBook("B4", "AI", 70, "AuthorD", "Python", "Spring4");
        ProgrammingBook b5 = new ProgrammingBook("B5", "Machine", 55, "AuthorE", "C++", "Spring5");
        FictionBook c1 = new FictionBook("C1", "Fiction1", 40, "AuthorF", "Viễn tưởng 1");
        FictionBook c2 = new FictionBook("C2", "Fiction2", 45, "AuthorG", "Viễn tưởng 2");
        FictionBook c3 = new FictionBook("C3", "Fiction3", 50, "AuthorH", "Viễn tưởng 1");
        FictionBook c4 = new FictionBook("C4", "Fiction4", 70, "AuthorI", "Viễn tưởng 1");
        FictionBook c5 = new FictionBook("C5", "Fiction5", 30, "AuthorJ", "Viễn tưởng 2");

        Book[] books = {b1, b2, b3, b4, b5, c1, c2, c3, c4, c5};
        System.out.println("TotalPrice is : " + getTotalPrice(books));
        System.out.println("Total Java Language Programming Book : " + countProgrammingByLanguage(books, "Java"));
        System.out.println("Total 'Viễn tưởng 1' Category Fiction Book: " + countFictionByCategory(books, "Viễn tưởng 1"));
        System.out.println("Total Fiction Book Price less than 100 : " + countFictionByPrice(books, 100));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book name: ");
        String bookName = sc.nextLine();
        findPrice(books, bookName);

    }

    public static int getTotalPrice(Book[] bookList) {
        int totalPrice = 0;
        for (Book book : bookList) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }

    public static int countProgrammingByLanguage(Book[] bookList, String inputLanguage) {
        int count = 0;
        for (Book book : bookList) {
            if (book instanceof ProgrammingBook) {
                String language = ((ProgrammingBook) book).getLanguage();
                if (language.equals(inputLanguage)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countFictionByCategory(Book[] bookList, String inputCategory) {
        int count = 0;
        for (Book book : bookList) {
            if (book instanceof FictionBook) {
                String category = ((FictionBook) book).getCategory();
                if (category.equals(inputCategory)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countFictionByPrice(Book[] bookList, int inputPrice) {
        int count = 0;
        for (Book book : bookList) {
            if (book instanceof FictionBook) {
                int price = ((FictionBook) book).getPrice();
                if (price < inputPrice) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int findPrice(Book[] bookList, String inputBookName) {
        int index = -1;
        for (int i = 0; i < bookList.length; i++) {
            String nameBook = bookList[i].getName();
            if (nameBook.equals(inputBookName)) {
                index = i;
            }
        }
        if (index >= 0) {
            System.out.println(inputBookName + " has price : " + bookList[index].getPrice());
        } else {
            System.out.println(inputBookName + " Not found");
        }
        return index;
    }
}
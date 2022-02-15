import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProgrammingBook b1 = new ProgrammingBook("B1","OOP",50,"AuthorA","Java","Spring1");
        ProgrammingBook b2 = new ProgrammingBook("B2","Website",40,"AuthorB","PHP","Spring2");
        ProgrammingBook b3 = new ProgrammingBook("B3","GameDevelop",60,"AuthorC","Ruby","Spring3");
        ProgrammingBook b4 = new ProgrammingBook("B4","AI",70,"AuthorD","Python","Spring4");
        ProgrammingBook b5 = new ProgrammingBook("B5","Machine",55,"AuthorE","C++","Spring5");
        FictionBook c1 = new FictionBook("C1","Fiction1",40,"AuthorF","Viễn tưởng 1");
        FictionBook c2 = new FictionBook("C2","Fiction2",45,"AuthorG","Viễn tưởng 2");
        FictionBook c3 = new FictionBook("C3","Fiction3",50,"AuthorH","Viễn tưởng 1");
        FictionBook c4 = new FictionBook("C4","Fiction4",70,"AuthorI","Viễn tưởng 1");
        FictionBook c5 = new FictionBook("C5","Fiction5",30,"AuthorJ","Viễn tưởng 2");

        Book[] books = {b1,b2,b3,b4,b5,c1,c2,c3,c4,c5};
        int totalPrice = 0;
        int countL= 0;
        int countC= 0;
        int countP= 0;
        for (Book a : books) {
            totalPrice += a.getPrice();
            if (a instanceof ProgrammingBook) {
                String language = ((ProgrammingBook) a).getLanguage();
                if (language.equals("Java")) {
                    countL++;
                }
            } else if(a instanceof FictionBook){
                String category = ((FictionBook) a).getCategory();
                if (category.equals("Viễn tưởng 1")){
                    countC++;
                }
                if (((FictionBook) a).getPrice()< 100){
                    countP++;
                }
            }
        }
        System.out.println("Total price = " + totalPrice + "k");
        System.out.println("Java Language book : " + countL);
        System.out.println("Category 'Viễn tưởng 1' : " + countC);
        System.out.println("Fiction book price less than 100k: " + countP);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book name: ");
        String bookName = sc.nextLine();
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals(bookName)){
                System.out.println(bookName + " - Price = " + books[i].getPrice());
            }
        }
    }
}

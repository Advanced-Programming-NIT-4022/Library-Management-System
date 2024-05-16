  import java.util.Scanner;
  import java.util.HashMap;
  import java.util.ArrayList;
  public class Book {


      static String[] namee = new String[10000];
      static ArrayList<String> book = new ArrayList<String>();
      static HashMap<String, Integer> informbook = new HashMap<String, Integer>();
      static HashMap<String, Integer> people1 = new HashMap<String, Integer>();
      static HashMap<Integer, String> informauthor = new HashMap<Integer, String>();
      static HashMap<String, String> informdecri = new HashMap<String, String>();
      static int chek;
      static int bookId = 999;

      //for add book
      static void informationBook(int c1, int userId) {


          Scanner namBook = new Scanner(System.in);
          Scanner autho = new Scanner(System.in);
          Scanner decri = new Scanner(System.in);
          String ab;


          if (CLI.add.equals(CLI.job1)) {


              System.out.println("whhat is your name book ? pleas write: ");
              ab = namBook.nextLine().toLowerCase();
              book.add(ab);
              informbook.put(ab, bookId);


              System.out.println("author name : ");
              String author = autho.nextLine().toLowerCase();
              informauthor.put(bookId, author);

              System.out.println("write about book : ");

              String decrii = decri.nextLine().toLowerCase();
              informdecri.put(author, decrii);

              System.out.println("add is sucecfully bookID : " + bookId);

              bookId--;
              CLI.job(c1, userId);

          }
          else if (CLI.Rent1.equals(CLI.job1)) {

              System.out.println("pleas write name of the book you want");

              String nameavaill = namBook.nextLine().toLowerCase();


              for (int i = 0; i < book.size(); i++) {
                  chek = 0;
                  int o12 = book.get(i).toLowerCase().compareTo(nameavaill.toLowerCase());
                  if (o12 == 0) {



                      chek = 1;
                      break;
                  }
              }

              if (chek == 1) {

                  System.out.println("is available");

                  System.out.println("rent is sucecfully");
                  Rent.rentBook(userId, nameavaill);

                  for (int i = 0; i < book.size(); i++) {

                      int o = book.get(i).toLowerCase().compareTo(nameavaill.toLowerCase());

                      if (o == 0) {

                          book.remove(book.get(i));

                          break;
                      }

                  }
                  book.remove(nameavaill);
                  c1 = 1;
                  CLI.job(c1, userId);


              } else {
                  System.out.println("not available");

                  if (c1 == 0) {
                      System.out.println("rent is not sucecfully");
                      CLI.job(c1, userId);

                  }


              }
              CLI.job(c1, userId);

          }
          else if (CLI.avail.equals(CLI.job1)) {
              System.out.println("pleas write name of the book you want");

              String nameavail = namBook.nextLine().toLowerCase();


              for (int i = 0; i < book.size(); i++) {
                  chek = 0;
                  int o13 = book.get(i).toLowerCase().compareTo(nameavail.toLowerCase());
                  if (o13 == 0) {
                      chek = 1;
                      break;
                  }
              }

              if (chek == 1) {

                  System.out.println("is available");


              } else {
                  System.out.println("not available");


                  CLI.job(c1, userId);
              }


              CLI.job(c1, userId);

          }

      }
  }



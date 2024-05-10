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

      //for add book
      static void informationBook(int i12, int i13, int i14, int c1, int userId) {

          int bookId = 9 - 999;
          Scanner namBook = new Scanner(System.in);
          Scanner autho = new Scanner(System.in);
          Scanner decri = new Scanner(System.in);
          String ab;


          if (i12 == 0) {


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
              i12 = 1;
              bookId--;
              CLI.job(c1, userId);

          }


          if (i13 == 0) {
              System.out.println("pleas write name of the book you want");

              String nameavail = namBook.nextLine().toLowerCase();

              int chek = 0;


              for (int i = 0; i < book.size(); i++) {

                  int o = book.get(i).toLowerCase().compareTo(nameavail.toLowerCase());
                  if (o == 0) {
                      chek = 1;
                  }
              }

              if (chek == 1) {

                  System.out.println("is available");
                  if (c1 == 0) {
                      people1.put(nameavail.toLowerCase(), Rent.rentId);
                      System.out.println("rent is sucecfully");

                      for (int i = 0; i < book.size(); i++) {

                          int o = book.get(i).toLowerCase().compareTo(nameavail.toLowerCase());

                          if (o == 0) {

                              book.remove(book.get(i));

                          }

                      }
                      i13 = 1;
                      c1 = 1;
                  }


              } else {
                  System.out.println("not available");

                  if (c1 == 0) {
                      System.out.println("rent is not sucecfully");


                  }

                  CLI.job(c1, userId);


                  i13 = 1;
                  c1 = 1;

              }
              CLI.job(c1, userId);

          }


          if (i14 == 0) {

              System.out.println("pleas write name of the book you want");

              String nameavail = namBook.nextLine().toLowerCase();

              int chek = 0;


              for (int i = 0; i < book.size(); i++) {

                  int o = book.get(i).toLowerCase().compareTo(nameavail.toLowerCase());
                  if (o == 0) {
                      chek = 1;
                  }
              }

              if (chek == 1) {

                  System.out.println("is available");
                  if (c1 == 0) {
                      people1.put(nameavail.toLowerCase(), Rent.rentId);
                      System.out.println("rent is sucecfully");

                      for (int i = 0; i < book.size(); i++) {

                          int o = book.get(i).toLowerCase().compareTo(nameavail.toLowerCase());

                          if (o == 0) {

                              book.remove(book.get(i));

                          }

                      }
                      i13 = 1;
                      c1 = 1;

                  }


              } else {
                  System.out.println("not available");

                  if (c1 == 0) {
                      System.out.println("rent is not sucecfully");


                  }


              }
              CLI.job(c1, userId);
          }
      }
  }




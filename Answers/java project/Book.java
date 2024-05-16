public class Book {
        private static int idCounter = 1;
        private int bookID;
        private String title;
        private String author;
        private boolean isAvailable;
        private String description;

        public Book(String title, String author, String description) {
            this.bookID = idCounter++;
            this.title = title;
            this.author = author;
            this.isAvailable = true;
            this.description = description;
        }

        // Getters and Setters
        public int getBookID() {
            return bookID;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            isAvailable = available;
        }

        public String getDescription() {
            return description;
        }
    }


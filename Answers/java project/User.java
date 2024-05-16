public class User {
        private static int idCounter = 1;
        private int userID;
        private String name;
        private String phoneNumber;

        public User(String name, String phoneNumber) {
            this.userID = idCounter++;
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        // Getters and Setters
        public int getUserID() {
            return userID;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }


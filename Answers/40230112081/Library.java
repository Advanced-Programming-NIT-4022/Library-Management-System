public class Library {
    private String libName;
    private int libCap;
    private String oprHours;

    // repos & registries
    public myFileCLass usersFileHandle;
    public myFileCLass adminsFileHandle;
    public myFileCLass booksFileHandle;
    public myFileCLass rentalFileHandle;
    // verifications
    public Verifications v;
    // constructor
    public Library(String name, String duration, int cap){
        this.oprHours = duration;
        this.libCap = cap;
        this.libName = name;
        usersFileHandle = new myFileCLass();
        adminsFileHandle = new myFileCLass();
        booksFileHandle = new myFileCLass();
        rentalFileHandle = new myFileCLass();
        usersFileHandle.dir = "Users.txt";
        adminsFileHandle.dir = "Admins.txt";
        booksFileHandle.dir = "Books.txt";
        rentalFileHandle.dir = "Rental.txt";
    }
    // getters
    public String getLibName() { return this.libName; }
    public int getLibCap() { return this.libCap; }
    public String getOprHours() { return this.oprHours; }

    // login as admin

    // login as normal user


}

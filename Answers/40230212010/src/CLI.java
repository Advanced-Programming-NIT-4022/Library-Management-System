
public class CLI {
    Library libraray;

    public CLI(Library libraray) {
        this.libraray = libraray;
    }
    public void NormalCommand(){
        System.out.println("___________________________________________");
        System.out.println("1. lib add book <name> <author> <subtitle>\n2. lib get hrs\n3. lib rent <bookName>\n4. lib get available books\n5. lib return <bookName>\n6. lib rent <bookName> <memberName> <memberID>\n7. Exit");
        System.out.println("___________________________________________");
    }
    public void AdminCommand(){
        System.out.println("___________________________________________");
        System.out.println("1. lib add member <studentID> <password>\n2. lib remove member <memberID>\n3. lib add book <name> <author> <subtitle>");
        System.out.println("___________________________________________");
    }

}

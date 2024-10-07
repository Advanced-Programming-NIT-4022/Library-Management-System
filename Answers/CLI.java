public class CLI {
    Library ketkh=new Library();
    Rent r=new Rent();
    Book bok=new Book();
    Normaluser nu=new Normaluser();
    Admin addd=new Admin();
    public void libaddbook(String bname,String writer,String sub) {
        if (!(ketkh.bookesm.contains(bname) && bok.writerdooni.containsValue(writer) && bok.subdooni.containsValue(sub))) {
            Book b = new Book();
            b.bmaker(bname, writer, sub);
            ketkh.mylib.add(b);
            ketkh.bookesm.add(b.bookname);
            bok.writerdooni.put(bname,writer);
            bok.subdooni.put(bname,sub);
        } else {
            System.out.println("this book already exists!");
        }
    }
    public void libgethrs() {
        System.out.println("az 9:00 sobh ta 11:00 shab.");
    }
    public void librent(String bname,String mn1) {
        r.rentmem.put(mn1, nu.memidsave.get(mn1));
        if (ketkh.bookesm.contains(bname)) {
            r.rentsaz(bname);
            ketkh.bookesm.remove(bname);
            System.out.println("book is rented!");
        } else {
            System.out.println("book not found!");
        }
    }
    public void libaddmember(String sname,String password) {
        if (nu.mempasssave.containsKey(sname)==false && nu.mempasssave.containsValue(password)==false) {
            nu.makeaccount(sname, password);
            System.out.println("member added!");
        } else {
            System.out.println("this member already exists!");
        }
    }
    public void librentforamember(String boname,String memn) {
        if (nu.mempasssave.containsKey(memn)) {
            librent(boname,memn);
        } else {
            System.out.println("user not found!");
        }
    }
    public void libgetavailablebooks() {
        System.out.println(ketkh.bookesm);
    }
    public void libremovemember(String memname) {
        if (nu.mempasssave.containsKey(memname)) {
            nu.mempasssave.remove(memname);
            nu.memidsave.remove(memname);
            if (addd.adminsave.containsKey(memname)) {
                addd.adminsave.remove(memname);
            }
            if (r.rentmem.containsKey(memname)) {
                r.rentmem.remove(memname);
            }
            System.out.println("member removed.");
        } else {
            System.out.println("user not found!");
        }
    }
    public void libreturn(String bookn) {
        if (r.bookrent.containsKey(bookn)) {
            r.bookrent.remove(bookn);
            ketkh.bookesm.add(bookn);
            System.out.println("book returned.");
        } else if (ketkh.bookesm.contains(bookn)) {
            System.out.println("the book hasnt been rented yet!");
        } else {
            System.out.println("this book hasnt been in our library!");
        }
    }
}
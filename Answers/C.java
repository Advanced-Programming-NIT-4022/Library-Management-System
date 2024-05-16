public interface C {
    void add_book(String name , String author , String subtitle);
    void get_hrs();
    void rent(String book_name);
    void add_member(String std_id , String password);
    void rent (String book_name , String member_name , String member_id);
    void available_book();
    void remove_member(String member_id);
    void return_book(String book_name);
}

public class User
{
    private String name;
    private int ID;
    private int number;
    public User(String name , int ID , int number)
    {
        this.name=name;
        this.ID=ID++;
        this.number=number;
    }

    public String getName()
    {
        return name;
    }
    public int getNumber()
    {
        return number;
    }
    public int getID()
    {
        return ID;
    }
    //I had to search so many times to find this cool thing here :>
    //I'm doing this so that i can work with arraylist easily
    /*public String toString()
    {
        return name+ID+number;
    }*/
}
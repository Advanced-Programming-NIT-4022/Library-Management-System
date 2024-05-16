public class User
{
    private String name;
    private int ID;
    private String number;
    public User(String name , int ID , String number)
    {
        this.setName(name);
        this.ID=ID;
        this.setName(number);
    }
    //it is is better to use setter instead of "this. =" formation

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getNumber()
    {
        return number;
    }
    public void setNumber(String number)
    {
        this.number=number;
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
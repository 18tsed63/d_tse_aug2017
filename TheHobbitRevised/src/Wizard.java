
public class Wizard extends Traveler
{
	//Call Traveler's constructor (look it up p587) to set the name field and then 
	//   set the color field for this class   
	//Wizards travel 3 times as far as other travelers in their party because they scout ahead.
	//  Override the travel method, calling the method from the superclass and passing it
	//  triple the miles passed in as a parameter.
	//  Ex.  Calling travel(50) would increase a Wizard's distance traveled by 150.
	//Wizards have colors associated with them.  Saruman the White, Gandalf the Grey, etc
	//  Override the Traveler's getName method to append the Wizard's color 
	
	private String color;
	
	public Wizard(String name, String color)
	{
		super(name);
		this.color = color;
	}
	
	public void travel(int miles)
	{
		super.travel(miles);
		miles = super.getDistanceTraveled() * 2;
		super.travel(miles);
	}
	
	public String getName()
	{
		String name = super.getName() + " the " + color;
		return name;
	}
}

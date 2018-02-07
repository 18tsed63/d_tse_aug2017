
public class Hobbit extends Traveler
{
	//Call Traveler's constructor (look it up p587) to set the name field and then 
	//   set the value of ringobssessed to false.  
	//Hobbits travel just like any other Traveler. Do they need a travel method?  
	//  Try it without and find out.  =]  
	
	private boolean ringObsessed;
	
	public Hobbit(String name)
	{
		super(name);
		ringObsessed = false;
	}
	
	
	
}

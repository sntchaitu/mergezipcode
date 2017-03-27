package merge;


/**
 * 
 * This is a bean class for Interval with two properties i.e., (start and end value) and
 * a list  of intervals of zipcodes.
 *
 */

public class Interval {
	
	
	private int intervalStart;
	private int intervalEnd;
	
	//Default Constructors
	public Interval()
	{
		
	}
	//Parameterized constructor
	public Interval(int intervalStart, int intervalEnd)
	{
		super();
		this.intervalStart = intervalStart;
		this.intervalEnd = intervalEnd;
	}
	//Getter and Setter Methods
	public int getIntervalStart() {
		return intervalStart;
	}
	public void setIntervalStart(int intervalStart) {
		this.intervalStart = intervalStart;
	}
	public int getIntervalEnd() {
		return intervalEnd;
	}
	public void setIntervalEnd(int intervalEnd) {
		this.intervalEnd = intervalEnd;
	}
	
}

package merge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/**
 * This is the service class for Interval class and it has methods to polulate 
 * zip  code Interval, merge the interval list to minimum number of intervals and displaying them.
 *
 */
import java.util.Comparator;
import java.util.List;


public class IntervalService {

	List<Interval> intervalList = new ArrayList<Interval>();
	List<Interval> resultList = null;
	public List<Interval> getResultList() {
		return resultList;
	}
	public void setResultList(List<Interval> resultList) {
		this.resultList = resultList;
	}

	/**
	 * This IntervalComparator class provides custom comparator to sort two intervals
	 * 1) based on their start value and if both start values are equal 
	 * 2) then it will sort based on end their value
	 */
	private class IntervalComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval interval1, Interval interval2) {
			// TODO Auto-generated method stub
			int value = Integer.compare(interval1.getIntervalStart(), interval2.getIntervalStart());
			if(value!=0)
			{
				return value;
			}
			value = Integer.compare(interval1.getIntervalEnd(), interval2.getIntervalEnd());
			return value;
		}

	}
	
	
	/**
	 * This method merges the given interval list and produces the minimum number of zipcode interval required to represent
	 * the same restrictions as specified in the input
	 * 
	 */
	public List<Interval> mergeIntervals(List<Interval> intervalList)
	{
		 if(intervalList==null || intervalList.size()==1)
	        {
	            return intervalList;
	        }
		 
		 //sort the intervals
		 Collections.sort(intervalList,new IntervalComparator());
		 List<Interval> result = new ArrayList<>();
		 Interval first;
		 int size = intervalList.size();
		 
		 for(int i=0;i<size;)
		 {
			 first = new Interval(intervalList.get(i).getIntervalStart(),intervalList.get(i).getIntervalEnd());
			 Interval second;
			 i++;
			 while(i<size)
			 {
				 second = intervalList.get(i);
				 if(overlap(first,second))
				 {
					 first.setIntervalEnd(Math.max(first.getIntervalEnd(),second.getIntervalEnd()));
					 i++;
				 }
				 else
				 {
					 break;
				 }
			 }
			 result.add(first);
		 }
		 
		 
		return result;
		 
	}
	private boolean overlap(Interval i1,Interval i2)
	{
		  if (i1.getIntervalEnd() >= i2.getIntervalStart() && i1.getIntervalStart() <= i2.getIntervalEnd())
		  {
	            return true;
		  }   
	      return false;
	}
	
	/**
	 * This method accepts zip code interval(lower bound, upper bound)
	 * input from the user and populates them in a list.
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	
	public void processIntervals() throws NumberFormatException, IOException
	{
		populateIntervals();
		resultList =  mergeIntervals(intervalList);
	}
	public void processIntervals(List<Interval> intervalList) throws NumberFormatException, IOException
	{
		//populateIntervals();
		resultList =  mergeIntervals(intervalList);
	}
	public void populateIntervals() throws NumberFormatException, IOException{
		
		/**
		 * Accept different Ranges from the user as input
		 * Conditions: Lower Bound Value should be less than Upper Bound value
		 * 			   Enter any value and press Enter to avoid invalid inputs
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//numberOfRanges field is used to enter the number of ranges user wish to input
		System.out.println("Enter the number of ranges: ");
		int numberOfRanges = Integer.parseInt(br.readLine());
		int start, end;
		
		for(int i=1;i<=numberOfRanges;i++){
			
			System.out.print("Lower bound for Range "+i+" : ");
			try{
				start = Integer.parseInt(br.readLine());
				System.out.print("Upper bound for Range "+i+" : ");
				end = Integer.parseInt(br.readLine());
				/**
				 * checking if the lower bound value is greater than the 
				 * upper bound value, if so accept the input again
				 */
				if(start > end){
					System.out.println("Lower Bound Value should be less than Upper Bound Value!");
					i--;
				}
				else{
					//creating a Range object with upper bound and lower bound values
					Interval interval = new Interval(start, end);
					/**
					 * passing the input range to this method so as to compute minimum number of ranges
					 */
					intervalList.add(interval);
					
				}
			}
			catch(NumberFormatException e){
				System.out.println("Please enter valid number!");
				i--;
				continue;
			}
			
		}
	}
	
	/**
	 * This method displays the set of Ranges of zip codes
	 * 
	 */
	public void displaySetOfIntervals(){
		
		for(int i=0;i<resultList.size();i++){
			System.out.print("["+resultList.get(i).getIntervalStart()+", "+resultList.get(i).getIntervalEnd()+"]\n");
		}
	}
}
	
		
	
	


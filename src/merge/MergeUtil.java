package merge;

public class MergeUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			/**
			 * create an object of service class and invoke populateRanges() method which
			 * will accept set of ranges as input from the user
			 */
			IntervalService intervalService = new IntervalService();
			intervalService.processIntervals();
			
			/**
			 * invoking displaySetOfRanges() method on service class object
			 * to display the final list of ranges
			 */
			System.out.println("Final Zipcode Ranges");
			intervalService.displaySetOfIntervals();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception occurred! Please try later");
		}
	}

}

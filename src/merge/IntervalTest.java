package merge;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class IntervalTest {
	
	private List<Interval> intervals;
	private List<Interval> actualResult;
	@Before
	public  void init(){
		intervals = new ArrayList<Interval>();
		actualResult = new ArrayList<Interval>();
	}
	
	@After
	public void destroy(){
		intervals.clear();
		//Range.getRangeList().clear();
	}
	
	//positive test case
	@Test
	public void testValuesOfMinimumNoOfRanges(){
		
		init();
		
		Interval range1 = new Interval(1, 3);
		Interval range2 = new Interval(2,7);
		Interval range3 = new Interval(5,9);
		Interval range4 = new Interval(11, 13);
		
		Interval r1 = new Interval(1, 9);
		Interval r2 = new Interval(11, 13);
		
		intervals.add(range1);
		intervals.add(range2);
		intervals.add(range3);
		intervals.add(range4);
		actualResult.add(r1);
		actualResult.add(r2);
		
		IntervalService service = new IntervalService();
		List<Interval> expectedResult = service.mergeIntervals(intervals);	
		Assert.assertEquals(true, customComparision(actualResult,expectedResult));
				
		destroy();
		
	}
	public boolean customComparision(List<Interval> first, List<Interval> second){
		

				// return true, if contents equal and false if not
			for (int i = 0; i < first.size(); i++)
			{
				if(first.get(i).getIntervalStart()!=second.get(i).getIntervalStart() || first.get(i).getIntervalEnd()!=second.get(i).getIntervalEnd())
				{
					return false;
				}
			}
			return true;
		}
  //failure test case
	@Test
	public void testsizeOfMinimumNoOfRanges(){
		
		init();
		
		Interval range1 = new Interval(1, 3);
		Interval range2 = new Interval(2,7);
		Interval range3 = new Interval(5,9);
		Interval range4 = new Interval(11, 13);
		
		Interval r1 = new Interval(1, 9);
		Interval r2 = new Interval(1, 3);
		Interval r3 = new Interval(11, 13);
		
		intervals.add(range1);
		intervals.add(range2);
		intervals.add(range3);
		intervals.add(range4);
		actualResult.add(r1);
		actualResult.add(r2);
		actualResult.add(r3);
		
		IntervalService service = new IntervalService();
		List<Interval> expectedResult = service.mergeIntervals(intervals);
		Assert.assertEquals(expectedResult.size(),actualResult.size());		
	
		
				
		destroy();
		
	}
	
}

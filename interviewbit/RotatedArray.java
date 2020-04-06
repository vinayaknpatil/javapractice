import java.util.Arrays;
import java.util.List;

/**
 * Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array will not contain duplicates.
 * @author vpatil
 *
 */
public class RotatedArray {
	
	public static void main(String [] args)
	{
		Integer [] input = new Integer [] {4, 5, 6, 7, 0, 1, 2};
		
		// List<Integer> inpArr = Arrays.asList(input);
		
		List<Integer> list = Arrays.asList(60437, 60449, 61231, 61617, 61632, 61722, 61818, 61948, 62943, 62967, 63011,
				63823, 65145, 65804, 65818, 66739, 66857, 67595, 69350, 71102, 71899, 72411, 72686, 73517, 74932, 76094,
				76343, 76903, 77288, 77426, 77683, 78292, 79165, 79675, 79677, 80362, 80879, 80923, 82952, 83789, 83890,
				84804, 85330, 87968, 88540, 89290, 89427, 89757, 89878, 91137, 91955, 92820, 93262, 94680, 95100, 96071,
				96280, 96537, 96556, 97945, 98173, 98583, 99869, 76, 426, 1579, 1865, 4324, 4634, 5149, 5348, 7859,
				8459, 9818, 10649, 10688, 11072, 11522, 12704, 12954, 13010, 13044, 14013, 14843, 16571, 16725, 16843,
				17396, 17397, 17670, 17753, 19722, 20831, 21004, 21501, 21987, 22809, 23801, 24161, 24351, 24772, 24833,
				25453, 25847, 25854, 25882, 26732, 28087, 28646, 33173, 33585, 35508, 36471, 37394, 37763, 37817, 41076,
				41629, 41693, 41700, 42126, 42509, 42932, 43315, 44765, 45646, 46088, 47469, 47837, 48520, 49249, 49968,
				51178, 51998, 52215, 53059, 53066, 53347, 54722, 54910, 55927, 58494, 59801, 60213);
		
		RotatedArray arr = new RotatedArray();
		System.out.println(arr.findMin(list));
	}

	 public int findMin(final List<Integer> a) {
		 
		 if(a == null)
			 return -1;
		 
		 if(a.size() == 1)
			 return a.get(0);
		 
		 int size = a.size();
		 
		 if(a.get(0) < a.get(1) && a.get(0) < a.get(size-1))
		 {
			 return a.get(0);
		 }
		 
		 
		 if(a.get(size-1) < a.get(size-2) && a.get(size-1) < a.get(0))
		 {
			 return a.get(size-1);
		 }
		 
		 int start  = 0;
		 int end = a.size() - 1;
		 
		 while(start <= end)
		 {
			// System.out.println("Start "+start+" end "+end);
			
			 
			 int mid = (start + end)/2;
			 
			 if(a.get(mid) < a.get(mid-1) && a.get(mid) < a.get(mid+1))
			 {
				 return a.get(mid);
			 }
			 
			 if(a.get(mid) < a.get(start) )
			 {
				 end = mid-1;
			 }
			 else if(a.get(mid) > a.get(end))
			 {
				 start = mid+1;
			 }
			 else if(a.get(mid) > a.get(start) && a.get(mid) < a.get(end))
			 {
				 start = start -1;
				 
			 }
			 else if(a.get(mid) < a.get(start) && a.get(mid) > a.get(end))
			 {
				 end = end + 1;
				 
			 }
			 
		 }
		 
		 return -1;
		 
	    }
	


	 public int findMin1(final List<Integer> a) {
		if (a.size() == 0 || a == null) {
			return -1;
		}
		int start = 0;
		int end = a.size() - 1;
		if (a.get(start) <= a.get(end)) // array is sorted
			return a.get(start);
		while (start <= end) {
			int mid = (start+end)/2;
			if(mid==0) {
				if(a.get(mid)<a.get(end))
					return a.get(mid);
				else
					return a.get(end);
			}
			if(mid==a.size()-1) {
				if(a.get(mid)<a.get(start))
					return a.get(mid);
				else
					return a.get(start);
			}
			// check if mid is pivot
			if (a.get(mid+1) >= a.get(mid) && a.get(mid-1)>=a.get(mid)) {
				return a.get(mid);
			} else if (a.get(mid) < a.get(end)) {
				end = mid -1 ;
			} else {
				start = mid + 1;
			}
		}
		return a.get(0);
	}


}

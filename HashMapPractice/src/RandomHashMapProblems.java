import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RandomHashMapProblems {

	public static void main(String[] args) {

		int[] nums = new int[] { -1, -1, -1, 1};

		System.out.println(threeSum(nums));
	

	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> results = new ArrayList<>();
		Map<Integer, Integer> searchedValues = new HashMap<>();
		
		Map<Integer, Integer> allValues = new HashMap<>();
		Map<Integer, Integer> mrdValuesSearched = new HashMap<>();


		if (nums.length < 3) {
			return results;
		}

		for (int i = 0; i < nums.length; i++) {
			allValues.put(nums[i], nums[i]);
		}
		
	

		for (int i = 0; i < nums.length; i++) {

			List<Integer> sumsList = new ArrayList<>();

			
			 if(allValues.containsKey(-nums[i]) && allValues.containsKey(0) && nums[i] != 0 &&
					 !mrdValuesSearched.containsKey(nums[i]) && !mrdValuesSearched.containsKey(-nums[i])) {
			  
				 if(nums[i] != 1 && nums[i] != -1) {
					 List<Integer> mrdSumsList = new ArrayList<>();
				  
					 mrdSumsList.add(-(nums[i])); mrdSumsList.add(0); mrdSumsList.add(nums[i]);
					 
					 mrdValuesSearched.put(nums[i], i);
					 mrdValuesSearched.put(-nums[i], -i);
	
					 
					 results.add(mrdSumsList);
				 }
			  
			  
			 }
			  
			 

			if (!searchedValues.containsKey(nums[i])) {

				if (nums[i] % 2 == 0) {

					int toFind = -(nums[i] / 2);
					int nFound = 0;

					for (int a = 0; a < nums.length; a++) {

						if (nums[a] == toFind) {
							System.out.println(nums[a]);
							sumsList.add(nums[a]);
							nFound++;

						}

						if (nFound == 2) {
							break;
						}

					}

					if (nFound == 2) {
						sumsList.add(nums[i]);
						results.add(sumsList);
						searchedValues.put(nums[i], i);
						searchedValues.put(-nums[i], i);

					}
					// int[] nums = new int[] { -3, 5, 3, 0, -2, -1, -3, -2, 4 };

				} else {
					
					System.out.println("going here");

					double toFind = (double) nums[i];
					int upperToFind = (int) (-(toFind / 2) + 0.5);
					int lowerToFind = (int) (-(toFind / 2) - 0.5);
					
					if(allValues.containsKey(upperToFind) && allValues.containsKey(lowerToFind)) {
						
						sumsList.add(allValues.get(upperToFind));		
						sumsList.add(allValues.get(lowerToFind));	
						results.add(sumsList);
						searchedValues.put(nums[i], i);
						searchedValues.put(-nums[i], i);


					}

				}

			}
		}

		return results;

	}

}

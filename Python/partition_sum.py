def printSets(set1, set2) : 

	# Print set 1. 
	for i in range(0, len(set1)) : 
		print ("{} ".format(set1[i]), end =""); 
	print ("") 

	# Print set 2. 
	for i in range(0, len(set2)) : 
		print ("{} ".format(set2[i]), end =""); 
	print ("") 

# Utility function to find the sets of the array which have equal sum. 
def findSets(arr, n, set1, set2, sum1, sum2, pos) : 

	# If entire array is traversed, compare both the sums. 
	if(pos == n): 
		
		# If sums are equal print both sets and return true to show sets are found. 
		if(sum1 == sum2): 
			printSets(set1, set2) 
			return True

		# If sums are not equal then return sets are not found. 
		else: 
			return False	

	# Add current element to set 1. 
	set1.append(arr[pos]) 

	# Recursive call after adding current element to set 1. 
	res = findSets(arr, n, set1, set2, sum1 + arr[pos], sum2, pos + 1) 

	# If this inclusion results in equal sum sets partition then return true to show desired sets are found. 
	if(res): 
		return res 

	# If not then backtrack by removing current element from set1 and include it in set 2. 
	set1.pop() 
	set2.append(arr[pos]) 

	# Recursive call after including current element to set 2. 
	return findSets(arr, n, set1, set2, sum1, sum2 + arr[pos], pos + 1) 

# Return true if array arr can be partitioned into two equal sum sets or not. 
def isPartitionPoss(arr, n) : 

	# Calculate sum of elements in array. 
	sum = 0

	for i in range(0, n): 
		sum += arr[i] 

	# If sum is odd then array cannot be partitioned. 
	if(sum % 2 != 0) : 
		return False

	# Declare vectors to store both the sets. 
	set1 = [] 
	set2 = [] 

	# Find both the sets. 
	return findSets(arr, n, set1, set2, 0, 0, 0) 

# Driver code 
arr = [5,1,12,312,134,649,16,537,765,123,2554] 
n = len(arr) 
if (isPartitionPoss(arr, n) == False) : 
	print ("-1") 

//Given an array of of size n and a number k, find all elements that appear more than n/k times

//http://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/


n/k*k=n
if bigger than n/k, so at most exists k-1 elements

class eleCount {
    int element;
    int count;
}; 

2) Traverse through the input array and update temp[] 
(add/remove an element or increase/decrease count) for every traversed element. 
The array temp[] stores potential (k-1) candidates at every step. This step takes O(nk) time.

Consider k = 4, n = 9 
Given array: 3 1 2 2 2 1 4 3 3 

i = 0
         3 _ _
temp[] has one element, 3 with count 1

i = 1
         3 1 _
temp[] has two elements, 3 and 1 with 
counts 1 and 1 respectively

i = 2
         3 1 2
temp[] has three elements, 3, 1 and 2 with
counts as 1, 1 and 1 respectively.

i = 3
         - - 2 
         3 1 2
temp[] has three elements, 3, 1 and 2 with
counts as 1, 1 and 2 respectively.

i = 4
         - - 2 
         - - 2 
         3 1 2
temp[] has three elements, 3, 1 and 2 with
counts as 1, 1 and 3 respectively.

i = 5
         - - 2 
         - 1 2 
         3 1 2
temp[] has three elements, 3, 1 and 2 with
counts as 1, 2 and 3 respectively. 
Now the question arises, what to do when temp[] is full and we see a new element – we remove the bottom row from stacks of elements, i.e., we decrease count of every element by 1 in temp[]. We ignore the current element.

i = 6
         - - 2 
         - 1 2 
temp[] has two elements, 1 and 2 with
counts as 1 and 2 respectively.

i = 7
           - 2 
         3 1 2 
temp[] has three elements, 3, 1 and 2 with
counts as 1, 1 and 2 respectively.

i = 8          
         3 - 2
         3 1 2 
temp[] has three elements, 3, 1 and 2 with
counts as 2, 1 and 2 respectively.

finally:
	   /*Step 3: Check the elements in the temp array, if they are more than n/k
    for (int i=0; i<k-1; i++)
    {
        // Calculate actual count of elements 
        int ac = 0;  // actual count
        for (int j=0; j<n; j++)
            if (arr[j] == temp[i].e)
                ac++;
 
        // If actual count is more than n/k, then print it
        if (ac > n/k)
           cout << "Number:" << temp[i].e
                << " Count:" << ac << endl;
    }
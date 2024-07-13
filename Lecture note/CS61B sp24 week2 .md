## tips
1.  [a java visualizer web](https://cscircles.cemc.uwaterloo.ca/java_visualize/)
2. the golden rules of equals: we copy the bits from what set in the right of the equal sign and rewrite them into what in the left of the `=` sign
3. copy the bits = pass by value 
	- reference type cannot fit the memory box, we need to use an arrow(reference) to where objects really lives(could be set to null)
4. array and list are not primitive types
	1. `int[] a = new int[]{0, 1, 2, 3, 4}`
		- if the type of elements in array is not primitive (eg. String) it would not store the element, it would store their address 
	2. `List<String> lst = new ArrayList<>()`
		- Most implementations of the List interface in Java are mutable like ArrayList and LinkedList
		 - but if we use `List.of` to create a list like this ` List<Integer> list = List.of(1, 2, 3)`; The list is immutable.
	3. how to get the length of array/list/set ?
		- **Array**:  `int length = array.length;`use the length property
		- **List**:  `int size = list.size();` 
		- **Set**: ` int size = set.size();` use `size()` method
	4. how could we get the specific elements in array/list/set?
		-  **Array**: Use the index directly with square brackets (`array[index]`).
		- **List**: Use the get(int index) method (`list.get(index)`).
		- **Set**: Since sets do not support indexed access, use an iterator or convert the set to a list/array first.(`Iterator<Integer> iterator = set.iterator();if (iterator.hasNext()) {int element = iterator.next();`)`
5. the difference between `IntList`and `SLList`
	1. if we using `SLList`, there is no need to specify null which make recursion easier
	2. a typical example for IntList![[Screenshot 2024-07-12 at 6.01.22 PM.png]]
	3. the comparison of IntList and SLList, there is the IntList ![[Screenshot 2024-07-12 at 6.15.23 PM.png]]here is [the SLList](https://cscircles.cemc.uwaterloo.ca/java_visualize/#code=%0A%0Apublic+class+SLList+%7B%0A++++public+IntNode+first%3B%0A+++%0A+++class+IntNode+%7B%0A++++public+int+item%3B%0A++++public+IntNode+next%3B%0A%0A++++public+IntNode(int+i,+IntNode+n)+%7B%0A++++++++item+%3D+i%3B%0A++++++++next+%3D+n%3B%0A++++%7D%0A%0A+++%7D%0A%0A++++public+SLList(int+x)+%7B%0A++++++++first+%3D+new+IntNode(x,+null)%3B%0A++++%7D%0A%0A++++public+void+addFirst(int+x)+%7B%0A++++++++first+%3D+new+IntNode(x,+first)%3B%0A++++%7D%0A++++/**+Retrieves+the+front+item+from+the+list.+*/%0A++++public+int+getFirst()+%7B%0A++++++++return+first.item%3B%0A++++%7D%0A++++public+static+void+main(String%5B%5D+argv)%7B%0A++++++++SLList+list+%3D+new+SLList(5)%3B%0A+++++++list.addFirst(2)%3B%0A+++++++list.getFirst()%3B%0A+++++++%0A++++%7D%0A%7D%0A&mode=display&curInstr=10)
	4. so basically the `SLList` class (the `first` instance) acts as a middleman between the list user and the naked recursive data structure. ![](https://cs61b-2.gitbook.io/~gitbook/image?url=https%3A%2F%2Fjoshhug.gitbooks.io%2Fhug61b%2Fcontent%2Fchap2%2Ffig22%2FIntList_vs_SLList.png&width=768&dpr=4&quality=100&sign=6f49ad6f&sv=1)
6. Improvement : Public vs. Private
	1. if we change the public keyword to the private keyword, it would ban the access of the things that out of the current class to get this instance **i.e. Private variables and methods can only be accessed by code inside the same  java file**
	2. java has a reflection library that allows you to get the primary instance variable
7.  Improvement : Nested Classes
	1. if we set a static class inside another class, the inner class's instance cannot access the instance outside itself anymore
	2. if the instance private but the class is public, we could make this class variables outside, but we could not use it to do anything else
	3. NOTICE: item & next could be many in one SLList, but there could only be one SLList eg.![[Screenshot 2024-07-12 at 11.36.06 PM.png]]
	4. Here since the number of parameter of the method are not equal, so the overloaded is allowable![[Screenshot 2024-07-12 at 11.37.50 PM.png]]
	5. keep track of size when user modify the list instead calculating it after the whole SLList has been set, would save much more time
		- and without using SLList, there is no room for size() method in the IntList
8.  Improvement : Sentinel node
	- instead of using a specific block to consider the case when the `first == null`, we could set the SLList as the combination of size and sentinel, which promise the first item in SLList would never become null
	- so the empty list would like this:![](https://cs61b-2.gitbook.io/~gitbook/image?url=https%3A%2F%2Fjoshhug.gitbooks.io%2Fhug61b%2Fcontent%2Fchap2%2Ffig22%2Fempty_sentinelized_SLList.png&width=768&dpr=4&quality=100&sign=a956853e&sv=1)
	- 
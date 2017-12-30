package ds.humanResource;

public class ParPtrTree {
	private Integer[] Parent; // The value of the array is the index of parent
	private Integer[] Ability; // The value of the array is the ability of corresponding member
	private Integer[] GroupAbility; // The value of the array is the total group ability. This is available only for leader.
	private Integer[] GroupSize; // The value of the array is the number of group members. This is available only for leader.
	
	public ParPtrTree(int size) {
		Parent = new Integer[size]; // Create parent array
		for (int i = 0; i < size; i++)
			Parent[i] = null;
		
		Ability = new Integer[size]; // Create ability array
		for (int i = 0; i < size; i++)
			Ability[i] = null;
		
		GroupAbility = new Integer[size]; // Create GroupAbility array
		for (int i = 0; i < size; i++)
			GroupAbility[i] = null;
		
		GroupSize = new Integer[size]; // Create GroupSize array
		for (int i = 0; i < size; i++)
			GroupSize[i] = null;
	}
	
	public void setAbility(Integer index, Integer ability) {
		// fill your code
		Ability[index] = ability;
	}
	
	public void setGroupAbility(Integer index, Integer GA) {
		// fill your code
		GroupAbility[index] = GA;
	}
	
	public void setGroupSize(Integer index, Integer GS) {
		// fill your code
		GroupSize[index] = GS;
	}
	
	public void addGroupAbility(Integer index, Integer GA) {
		// fill your code
		GroupAbility[index] += GA;
	}
	
	public void addGroupSize(Integer index, Integer GS) {
		// fill your code
		GroupSize[index] += GS;
	}
	
	public Integer getAbility(Integer index) {
		// fill your code
		return Ability[index];
	}

	public Integer getGroupAbility(Integer index) {
		// fill your code
		return GroupAbility[FIND(index)];
	}
	
	public Integer getGroupSize(Integer index) {
		// fill your code
		return GroupSize[FIND(index)];
	}
	
	public Integer getDepth(Integer index) {
		// fill your code
		int temp=0;
		while(Parent[index]!=null) {
			index = Parent[index];
			temp++;
		}
		return temp;
	}

	/** Determine if nodes are in different trees */
	public boolean differ(int a, int b) {
		// fill your code
		return FIND(a)!=FIND(b);
	}

	/** Merge two subtrees.
	 * 'b' group is attached to 'a' group, which means that the leader of 'a' group goes to the leader of the merged group. */
	public void UNION(int a, int b) {
		// fill your code
		int aroot = FIND_pathCompression(a);
		int broot = FIND_pathCompression(b);
		// What if aroot and broot are the same?
		int agroupabilitytemp = getGroupAbility(aroot);
		int bgroupabilitytemp = getGroupAbility(broot);
		int agroupsizetemp = getGroupSize(aroot);
		int bgroupsizetemp = getGroupSize(broot);
		//System.out.println("aroot's group ability is "+getGroupAbility(aroot));	// 1
		//System.out.println("broot's group ability is "+getGroupAbility(broot)); // 2
		if(agroupabilitytemp>bgroupabilitytemp) {
			Parent[broot] = aroot;
			GroupAbility[aroot] = agroupabilitytemp + bgroupabilitytemp;
			GroupSize[aroot] = agroupsizetemp + bgroupsizetemp;
		}
		else if(agroupabilitytemp == bgroupabilitytemp) {
			if(aroot>broot) {
				Parent[aroot] = broot;
				GroupAbility[broot] = agroupabilitytemp + bgroupabilitytemp;
				GroupSize[broot] = agroupsizetemp + bgroupsizetemp;
			}
			else {
				Parent[broot] = aroot;
				GroupAbility[aroot] = agroupabilitytemp + bgroupabilitytemp;
				GroupSize[aroot] = agroupsizetemp + bgroupsizetemp;
			}
		}
		else {
			Parent[aroot] = broot;
			//System.out.println("aroot's group ability is "+getGroupAbility(aroot));	// 2
			//System.out.println("broot's group ability is "+getGroupAbility(broot)); // 2
			GroupAbility[broot] = agroupabilitytemp + bgroupabilitytemp;
			//System.out.println(GroupAbility[broot]);
			GroupSize[broot] = agroupsizetemp + bgroupsizetemp;
		}
		return;
	}

	/** Find the root node and connect the curr node to root directly. **/
	public Integer FIND_pathCompression(Integer curr) {
		// fill your code
		// must use path compression
		if(Parent[curr] == null) return curr;
		Parent[curr] = FIND_pathCompression(Parent[curr]);
		return Parent[curr];
	}
	
	/** Find the root of the curr tree. No path compression */
	public Integer FIND(Integer curr) {
		// fill your code
		// without path compression
		if (Parent[curr] == null) return curr;
		while (Parent[curr] != null) {
			curr = Parent[curr];
		}
		return curr;
	}
}

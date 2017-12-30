package ds.humanResource;

public class HumanResource {
	private ParPtrTree PPT;
	private static final int MAXMEMBER = 100000;
	
	public HumanResource(){
		PPT = new ParPtrTree(MAXMEMBER);
	}
	
	public void Hire(int member, int ability){
		// fill your code
		PPT.setAbility(member, ability);
		PPT.setGroupAbility(member, ability);
		PPT.setGroupSize(member, 1);
	}
	
	public boolean Merge(int member1, int member2){
		// fill your code
		if(PPT.FIND(member1) == PPT.FIND(member2)) {
			return false;
		}
		//System.out.println("Merge is activated");
		PPT.UNION(member1, member2);
		//System.out.println("Group Ability is "+PPT.getGroupAbility(2));
		return true;
	}
	
	public void AbilityOfPerson(int member){
		System.out.println(PPT.getAbility(member));
		// fill your code
	}
	
	public void DepthOfPerson(int member){
		System.out.println(PPT.getDepth(member));
		// fill your code
	}
	
	public void AbilityOfGroup(int member) {
		System.out.println(PPT.getGroupAbility(PPT.FIND(member)));
		// fill your code
	}
	
	public void SizeOfGroup(int member) {
		System.out.println(PPT.getGroupSize(PPT.FIND(member)));
		//fill your code
	}
}

package ds.test;
import java.io.StringReader;
import java.util.Scanner;

import ds.humanResource.HumanResource;

public class Main {
	private static final int MERGE = 0;
	private static final int HIRE = 1;
	private static final int AOP = 2;	//Ability of person
	private static final int DOP = 3;	//Depth of person
	private static final int AOG = 4;	//Ability of group
	private static final int SOG = 5;	//Size of group

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HumanResource HumanResourceManagement = new HumanResource();

		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			Scanner i_scanner = new Scanner(new StringReader(line));
			String cmd = i_scanner.next();
			int member1 = 0;
			int member2 = 0;
			int ability = 0;

			switch (getCommandNum(cmd)) {
				case MERGE:
					member1 = i_scanner.nextInt();
					member2 = i_scanner.nextInt();
					if(HumanResourceManagement.Merge(member1, member2))
						System.out.println("The group of "+member1+" and the group of "+member2+" are merged.");
					else
						System.out.println("The two members are in the same group already.");
					break;
				case HIRE:
					member1 = i_scanner.nextInt();
					ability = i_scanner.nextInt();
					HumanResourceManagement.Hire(member1, ability);
					// fill your code
					break;
				case AOP:
					member1 = i_scanner.nextInt();
					HumanResourceManagement.AbilityOfPerson(member1);
					// fill your code				
					break;
				case DOP:
					member1 = i_scanner.nextInt();
					HumanResourceManagement.DepthOfPerson(member1);
					// fill your code
					break;
				case AOG:
					member1 = i_scanner.nextInt();
					HumanResourceManagement.AbilityOfGroup(member1);
					// fill your code
					break;
				case SOG:
					member1 = i_scanner.nextInt();
					HumanResourceManagement.SizeOfGroup(member1);
					// fill your code				
					break;
			}
			i_scanner.close();
		}

		scanner.close();
	}

	private static int getCommandNum(String cmd) {
		// System.out.println(cmd);
		if (cmd.equals("merge"))
			return MERGE;
		else if (cmd.equals("hire"))
			return HIRE;
		else if (cmd.equals("aop"))
			return AOP;
		else if (cmd.equals("dop"))
			return DOP;
		else if (cmd.equals("aog"))
			return AOG;
		else
			return SOG;
	}
}

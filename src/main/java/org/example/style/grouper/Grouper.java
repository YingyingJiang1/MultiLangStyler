package org.example.style.grouper;

public interface Grouper {
	static int START = -100000;

//	int getGroupId(int type);

//	String getGroupName(int groupId);
	String getGroupName(String name);

//	int getGroupId(String groupName);
//	boolean isBinaryOp(int groupId);
	int calculateGroupDistance(String group1, String group2);
}

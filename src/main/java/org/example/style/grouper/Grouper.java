package org.example.style.grouper;

public interface Grouper {
	static int START = 1 << 30;

//	int getGroupId(int type);

//	String getGroupName(int groupId);
	String getGroupName(String name);
	String getGroupName(int type);
	boolean isGroup(int type);

//	int getGroupId(String groupName);
//	boolean isBinaryOp(int groupId);
	int calculateGroupDistance(String group1, String group2);
}

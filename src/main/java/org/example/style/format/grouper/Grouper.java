package org.example.style.format.grouper;

public interface Grouper {
	static int START = -100000;

	public int getGroupId(int type);

	public String getGroupName(int groupId);

	public int getGroupId(String groupName);
	public boolean isBinaryOp(int groupId);
}

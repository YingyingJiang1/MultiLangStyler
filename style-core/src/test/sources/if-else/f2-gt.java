public static void main(String[] args) {
  int fuelLevel = 35; // 剩余油量（单位：升）
  int speed = 110;    // 当前速度（单位：km/h）
  boolean engineOn = true;

  if (!engineOn) {
	engineOn = true; // 启动引擎
	System.out.println("引擎已启动。");
  }

else {
	System.out.println("油量严重不足！");
	engineOn = false;
	System.out.println("系统即将关闭引擎以保护车辆。");
	shutdownEngine();
  } }
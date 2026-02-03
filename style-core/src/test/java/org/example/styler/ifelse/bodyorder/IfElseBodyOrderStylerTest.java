package org.example.styler.ifelse.bodyorder;

import org.example.TestBase;
import org.example.stylekit.Coordinator;
import org.junit.jupiter.api.Test;

class IfElseBodyOrderStylerTest extends TestBase {

	@Test
	void applyStyle() {
		Coordinator coordinator = new Coordinator();
		String code = """
public static void main(String[] args) {
        int fuelLevel = 35; // 剩余油量（单位：升）
        int speed = 110;    // 当前速度（单位：km/h）
        boolean engineOn = true;

        if (!engineOn) {
            engineOn = true; // 启动引擎
            System.out.println("引擎已启动。");
        } else if (fuelLevel > 50) {
            System.out.println("油量充足。");
            shutdownEngine();
        } else {
            System.out.println("油量严重不足！");
            engineOn = false;
            System.out.println("系统即将关闭引擎以保护车辆。");
            shutdownEngine();
        }

    }
				""";
		String groundTruth = """
public static void main(String[] args) {
        int fuelLevel = 35; // 剩余油量（单位：升）
        int speed = 110;    // 当前速度（单位：km/h）
        boolean engineOn = true;

        if (!engineOn) {
            engineOn = true; // 启动引擎
            System.out.println("引擎已启动。");
        } else if (fuelLevel <= 50) {
            System.out.println("油量严重不足！");
            engineOn = false;
            System.out.println("系统即将关闭引擎以保护车辆。");
            shutdownEngine();
        }

    else {
            System.out.println("油量充足。");
            shutdownEngine();
        } }
				""";
//		ProgramStyle style = new ProgramStyle();
//		IfElseBodyOrderStyle ifelseStyle = new IfElseBodyOrderStyle();
//		ifelseStyle.addRule(null, new IfElseBodyOrderProperty(false));
//		style.add(ifelseStyle);
//		String result = controller.applyStyle(code, style, "java" );
//		assertEquals(groundTruth, result);
	}
}
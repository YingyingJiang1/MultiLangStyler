package org.example.parser.common;

import org.antlr.v4.runtime.tree.*;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.example.parser.common.context.ExtendContext;
import org.example.style.InconsistencyInfo;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/13 12:35
 */
public class MyParseTreeWalker extends ParseTreeWalker {
	public static Logger logger = LoggerFactory.getLogger(MyParseTreeWalker.class);

	private MyParser parser;
	private List<Styler> enterStylers = new ArrayList<>();
	private List<Styler> exitStylers = new ArrayList<>();
	private List<InconsistencyInfo> infos = new ArrayList<>(); // This should be moved to Styler classes.

	public MyParseTreeWalker(MyParser parser, List<Styler> stylers) {
		this.parser = parser;
		for (Styler styler : stylers) {
			if (styler.executeWhenExit) {
				exitStylers.add(styler);
			} else {
				enterStylers.add(styler);
			}
		}
	}

	public void walkTree(Stage stage){
		walk(parser.getRoot(), stage);
	}

	public @NonNull List<InconsistencyInfo> getInconsistencyInfos() {
		return infos;
	}

	private void walk(ParseTree t, Stage stage) {
		if (t instanceof ErrorNode) {

		} else if (t instanceof TerminalNode) {

		} else if (t instanceof ExtendContext ctx) {
			doTask(ctx, enterStylers, stage); // enter rule

			for(int i = 0; i < ctx.getChildCount(); ++i) {
				this.walk(ctx.getChild(i), stage);
			}

			doTask(ctx, exitStylers, stage); // exit rule
		}
	}




	private void doTask(ExtendContext ctx, List<Styler> stylers, Stage stage) {
		if (stage == Stage.EXTRACT) {
			for (Styler styler : stylers) {
				if (styler.isEnable(stage) && styler.isRelevant(ctx, stage,parser)) {
					try {
						styler.extractStyle(ctx,parser);
					} catch (Exception e) {
						logger.error("{} exception at stage {}.", styler.getClass().getSimpleName(), stage, e);
					}
				}
			}
		} else if (stage == Stage.APPLY) {
			ExtendContext newCtx = ctx;
			for (Styler styler : stylers) {
				if(styler.isEnable(stage) && styler.isRelevant(newCtx, stage,parser)) {
					try {
						newCtx = styler.applyStyle(newCtx,parser);
					} catch (Exception e) {
						logger.error("{} exception at stage {}.", styler.getClass().getSimpleName(), stage, e);
					}
				}
			}
		} else if (stage == Stage.ANALYZE) {
			for (Styler styler : stylers) {
				if(styler.isEnable(stage) && styler.isRelevant(ctx, stage,parser)) {
					try {
						List<InconsistencyInfo> ret = styler.analyzeInconsistency(ctx, parser);
						if (ret != null) {
							infos.addAll(ret);
						}
					} catch (Exception e) {
						logger.error("{} exception at stage {}.", styler.getClass().getSimpleName(), stage, e);
					}
				}
			}
		}
	}

}

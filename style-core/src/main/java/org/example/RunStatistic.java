package org.example;

import org.apache.commons.logging.LogFactory;
import org.example.styler.Styler;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RunStatistic {
	private static Map<Integer, Integer> structureStylerStatis = new ConcurrentHashMap<>();
	private static Map<Class<? extends Styler>, Integer> decLayoutStylerStatis = new ConcurrentHashMap<>();
	public static Logger logger = LoggerFactory.getLogger(RunStatistic.class);

	public static void addStructureRule(int rule) {
		structureStylerStatis.merge(rule, 1, Integer::sum);
	}

	public static void hit(Class<? extends Styler> cls) {
		decLayoutStylerStatis.merge(cls, 1, Integer::sum);
	}

	public static void printStatistic() {
		logger.info("---StructureStyler---: ");
		List<Map.Entry<Integer, Integer>> sorted = structureStylerStatis.entrySet().stream().sorted(Comparator.comparing(e -> -e.getValue())).toList();
		sorted.forEach(e -> {
			logger.info("rule {}: {}", e.getKey(), e.getValue());
		});

		for (Map.Entry<Class<? extends Styler>, Integer> entry : decLayoutStylerStatis.entrySet())  {
			logger.info("{}: {}", entry.getKey().getSimpleName(), entry.getValue());
		}
	}
}

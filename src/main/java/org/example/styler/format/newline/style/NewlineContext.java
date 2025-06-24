package org.example.styler.format.newline.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.*;

public class NewlineContext extends StyleContext {
	Map<String, Integer> verticalVector; // vertical vector
	Map<String, Integer> horizontalVector; // horizontal vector

	public NewlineContext() {
		verticalVector = new java.util.HashMap<>();
		horizontalVector = new java.util.HashMap<>();
	}

	public NewlineContext(Map<String, Integer> verticalVector, Map<String, Integer> horizontalVector) {
		this.verticalVector = verticalVector;
		this.horizontalVector = horizontalVector;
	}

	@Override
	public void addElement(Element parent, MyParser parser) {
		parent.addAttribute("verticalVector", verticalVector.toString());
		parent.addAttribute("horizontalVector", horizontalVector.toString());
	}

	@Override
	public void parseElement(Element parent, MyParser parser) {
		if (parent.attribute("verticalVector") != null) {
			String vectorStr = parent.attributeValue("verticalVector");
			verticalVector = parseMap(vectorStr);
		}
		if (parent.attribute("horizontalVector") != null) {
			String vectorStr = parent.attributeValue("horizontalVector");
			horizontalVector = parseMap(vectorStr);
		}
	}


	/**
	 *
	 * @param other
	 * @param weights [vertical weight , horizontal weight]
	 * @return
	 */
	public double similarityTo(NewlineContext other, List<Double> weights) {
		double verticalWeight = weights.get(0);
		double horizontalWeight = weights.get(1);

		double vSim = this.cosineSimilarity(this.verticalVector, other.verticalVector);
		double hSim = this.cosineSimilarity(this.horizontalVector, other.horizontalVector);

		return verticalWeight * vSim + horizontalWeight * hSim;
	}

	private double cosineSimilarity(Map<String, Integer> vec1, Map<String, Integer> vec2) {
		Set<String> allKeys = new HashSet<>();
		allKeys.addAll(vec1.keySet());
		allKeys.addAll(vec2.keySet());

		double dot = 0.0;
		double norm1 = 0.0;
		double norm2 = 0.0;

		for (String key : allKeys) {
			int val1 = vec1.getOrDefault(key, 0);
			int val2 = vec2.getOrDefault(key, 0);

			dot += val1 * val2;
			norm1 += val1 * val1;
			norm2 += val2 * val2;
		}

		if (norm1 == 0 || norm2 == 0) {
			return 0.0; // 若任一向量为零向量，返回不相似
		}

		return dot / (Math.sqrt(norm1) * Math.sqrt(norm2));
	}

	private Map<String, Integer> parseMap(String vectorStr) {
		Map<String, Integer> vector = new HashMap<>();
		vectorStr = vectorStr.substring(1, vectorStr.length() - 1);
		String[] vectorStrs = vectorStr.split(",");
		for (String v : vectorStrs) {
			String[] entry = v.split("=");
			vector.put(entry[0].trim(), Integer.parseInt(entry[1].trim()));
		}
		return vector;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NewlineContext context = (NewlineContext) o;
		return Objects.equals(verticalVector, context.verticalVector) && Objects.equals(horizontalVector, context.horizontalVector);
	}

	@Override
	public int hashCode() {
		return Objects.hash(verticalVector, horizontalVector);
	}
}

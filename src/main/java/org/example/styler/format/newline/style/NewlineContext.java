package org.example.styler.format.newline.style;

import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;
import pascal.taie.analysis.pta.core.heap.Obj;

import java.util.*;

public class NewlineContext extends StyleContext {
	List<String> verticalVector; // vertical vector
	List<String> horizontalVector; // horizontal vector
	List<Integer> verticalLengthVector;
	List<Integer> horizontalLengthVector;
	int verticalSP, horizontalSP; // start point in vertical and horizontal directions

	public NewlineContext() {
		verticalVector = new ArrayList<>();
		horizontalVector = new ArrayList<>();
		horizontalLengthVector = new ArrayList<>();
		verticalLengthVector = new ArrayList<>();
	}

	public NewlineContext(List<String> verticalVector, List<String> horizontalVector, List<Integer> verticalLengthVector,
						  List<Integer> horizontalLengthVector, int verticalSP, int horizontalSP) {
		this.verticalVector = verticalVector;
		this.horizontalVector = horizontalVector;
		this.verticalLengthVector = verticalLengthVector;
		this.horizontalLengthVector = horizontalLengthVector;
		this.verticalSP = verticalSP;
		this.horizontalSP = horizontalSP;
	}

	@Override
	public void addElement(Element parent, MyParser parser) {
		parent.addAttribute("verticalVector", verticalVector.toString());
		parent.addAttribute("horizontalVector", horizontalVector.toString());
		parent.addAttribute("verticalLengthVector", verticalLengthVector.toString());
		parent.addAttribute("horizontalLengthVector", horizontalLengthVector.toString());
		parent.addAttribute("verticalSP", Integer.toString(verticalSP));
		parent.addAttribute("horizontalSP", Integer.toString(horizontalSP));
	}

	@Override
	public void parseElement(Element parent, MyParser parser) {
		if (parent.attribute("verticalVector") != null) {
			String str = parent.attributeValue("verticalVector");
			verticalVector = parseList(str);
		}
		if (parent.attribute("horizontalVector") != null) {
			String str = parent.attributeValue("horizontalVector");
			horizontalVector = parseList(str);
		}
		if (parent.attribute("verticalLengthVector") != null) {
			String str = parent.attributeValue("verticalLengthVector");
			parseList(str).forEach(s -> verticalLengthVector.add(Integer.parseInt(s)));
		}
		if (parent.attribute("horizontalLengthVector") != null) {
			String str = parent.attributeValue("horizontalLengthVector");
			parseList(str).forEach(s -> horizontalLengthVector.add(Integer.parseInt(s)));
		}
		if (parent.attribute("verticalSP") != null) {
			verticalSP = Integer.parseInt(parent.attributeValue("verticalSP"));
		}
		if (parent.attribute("horizontalSP") != null) {
			horizontalSP = Integer.parseInt(parent.attributeValue("horizontalSP"));
		}
	}


	/**
	 *
	 * @param other
	 * @param weights [vertical weight , horizontal weight]
	 * @return
	 */
	public double similarityTo(NewlineContext other, List<Double> weights) {
		if (horizontalSP < 0 || !horizontalVector.get(horizontalSP).equals(other.horizontalVector.get(other.horizontalSP))){
			return 0.0;
		}

		double verticalWeight = weights.get(0);
		double horizontalWeight = weights.get(1);
		double vectorLenWeight = weights.get(2);
		double horizontalLenWeight = weights.get(3);

		double vSim = this.cosineSimilarity(this.verticalVector, other.verticalVector);
		double hSim = this.cosineSimilarity(this.horizontalVector, other.horizontalVector);
		double vLenSim = this.cosineSimilarity(this.verticalLengthVector, other.verticalLengthVector);
		double hLenSim = this.cosineSimilarity(this.horizontalLengthVector, other.horizontalLengthVector);

		double sim = verticalWeight * vSim + horizontalWeight * hSim + vectorLenWeight * vLenSim + horizontalLenWeight * hLenSim;
		return sim;
	}

	private double cosineSimilarity(List<?> vec1, List<?> vec2) {
		Map<Object, Integer> freq1 = new HashMap<>();
		Map<Object, Integer> freq2 = new HashMap<>();

		for (Object o : vec1) {
			freq1.put(o, freq1.getOrDefault(o, 0) + 1);
		}
		for (Object o : vec2) {
			freq2.put(o, freq2.getOrDefault(o, 0) + 1);
		}

		Set<Object> allKeys = new HashSet<>();
		allKeys.addAll(freq1.keySet());
		allKeys.addAll(freq2.keySet());

		double dot = 0.0;
		double norm1 = 0.0;
		double norm2 = 0.0;

		for (Object key : allKeys) {
			int val1 = freq1.getOrDefault(key, 0);
			int val2 = freq2.getOrDefault(key, 0);

			dot += val1 * val2;
			norm1 += val1 * val1;
			norm2 += val2 * val2;
		}

		if (norm1 == 0 || norm2 == 0) {
			return 0.0; // 若任一向量为零向量，返回不相似
		}

		return dot / (Math.sqrt(norm1) * Math.sqrt(norm2));
	}




	private List<String> parseList(String vectorStr) {
		List<String> result = new ArrayList<>();

		if (vectorStr == null || vectorStr.length() < 2) {
			return result;
		}

		// 去除开头和结尾的中括号 [ ]
		String content = vectorStr.substring(1, vectorStr.length() - 1).trim();
		// 按逗号分割，并清除每项前后的空格
		String[] items = content.split("\\s*,\\s*");
		result.addAll(Arrays.asList(items));

		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NewlineContext context = (NewlineContext) o;
		return Objects.equals(verticalVector, context.verticalVector) && Objects.equals(horizontalVector, context.horizontalVector)
				&& Objects.equals(verticalLengthVector, context.verticalLengthVector)
				&& Objects.equals(horizontalLengthVector, context.horizontalLengthVector)
		&& verticalSP == context.verticalSP && horizontalSP == context.horizontalSP;
	}

	@Override
	public int hashCode() {
		return Objects.hash(verticalVector, horizontalVector, verticalLengthVector, horizontalLengthVector,
				verticalSP, horizontalSP);
	}
}

package org.example.styler.format.newline.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.DomIO;
import org.example.style.rule.StyleContext;

import java.util.*;
import java.util.stream.Collectors;

public class NewlineContext extends StyleContext {
	FeatureVector verticalFeature, horizontalFeature;


	public NewlineContext(FeatureVector verticalFeature, FeatureVector horizontalFeature) {
		this.verticalFeature = verticalFeature;
		this.horizontalFeature = horizontalFeature;
	}

	@Override
	public void addElement(Element parent, MyParser parser) {
		if (verticalFeature != null) {
			Element verticalEle = parent.addElement("verticalFeature");
			verticalFeature.addElement(verticalEle, parser);
		}

		if (horizontalFeature != null) {
			Element horizontalEle = parent.addElement("horizontalFeature");
			horizontalFeature.addElement(horizontalEle, parser);
		}
	}

	@Override
	public void parseElement(Element parent, MyParser parser) {
		Element verticalEle  = parent.element("verticalFeature");
		if (verticalFeature != null) {
			verticalFeature.parseElement(verticalEle, parser);
		}

		Element horizontalEle = parent.element("horizontalFeature");
		if (horizontalFeature != null) {
			horizontalFeature.parseElement(horizontalEle, parser);
		}

	}

	public int complexityComparision(NewlineContext other) {
		int hDiff = horizontalFeature.lenVec.stream().reduce(0, Integer::sum) - other.horizontalFeature.lenVec.stream().reduce(0, Integer::sum);
		return hDiff;
	}

	public String getSPNodeName() {
		return horizontalFeature.typeVec.get(horizontalFeature.startPoint);
	}

	public List<String> getVerticalVector() {
		return verticalFeature.typeVec;
	}

	public List<String> getHorizontalVector() {
		return horizontalFeature.typeVec;
	}

	public int getVerticalSPIndex() {
		return verticalFeature.startPoint;
	}

	public int getHorizontalSPIndex() {
		return horizontalFeature.startPoint;
	}

	/**
	 *
	 * @param other
	 * @param weights [vertical weight , horizontal weight]
	 * @return
	 */
	public double similarityTo(NewlineContext other, List<Double> weights) {
		if (other.horizontalFeature == null || !horizontalFeature.hasSameSP(other.horizontalFeature)){
			return 0.0;
		}

		double verticalWeight = weights.get(0);
		double horizontalWeight = weights.get(1);
		double vectorLenWeight = weights.get(2);
		double horizontalLenWeight = weights.get(3);

		double hSim = this.cosineSimilarity(this.horizontalFeature.typeVec, other.horizontalFeature.typeVec);
		double hLenSim = this.cosineSimilarity(this.horizontalFeature.lenVec, other.horizontalFeature.lenVec);
		double vSim = 0, vLenSim = 0;

		if (verticalFeature != null) {
			vSim = this.cosineSimilarity(this.verticalFeature.typeVec, other.verticalFeature.typeVec);
			vLenSim = this.cosineSimilarity(this.verticalFeature.lenVec, other.verticalFeature.lenVec);
		}


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
		return Objects.equals(verticalFeature, context.verticalFeature) && Objects.equals(horizontalFeature, context.horizontalFeature);
	}

	@Override
	public int hashCode() {
		return Objects.hash(verticalFeature, horizontalFeature);
	}

	public static class FeatureVector implements DomIO {
		public List<String> typeVec = new ArrayList<>();
		public List<Integer> lenVec = new ArrayList<>();
		// Start point is where newline will be added or removed after.
		int startPoint;

		public FeatureVector(List<String> typeVec, List<Integer> lenVec, int startPoint) {
			this.typeVec = typeVec;
			this.lenVec = lenVec;
			this.startPoint = startPoint;
		}

		@Override
		public void addElement(Element parent, MyParser parser) {
			parent.addAttribute("typeVec", typeVec.toString().substring(1, typeVec.toString().length() - 1));
			parent.addAttribute("lenVec", lenVec.toString().substring(1, lenVec.toString().length() - 1));
			parent.addAttribute("startPoint", Integer.toString(startPoint));
		}

		@Override
		public void parseElement(Element parent, MyParser parser) {
			typeVec = Arrays.stream(parent.attributeValue("typeVec").split(",")).toList();
			lenVec = Arrays.stream(parent.attributeValue("lenVec").split(","))
					.map(Integer::parseInt)
					.collect(Collectors.toList());
			startPoint = Integer.parseInt(parent.attributeValue("startPoint"));
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			FeatureVector that = (FeatureVector) o;
			return startPoint == that.startPoint && Objects.equals(typeVec, that.typeVec) && Objects.equals(lenVec, that.lenVec);
		}

		@Override
		public int hashCode() {
			return Objects.hash(typeVec, lenVec, startPoint);
		}

		public boolean hasSameSP(FeatureVector horizontalFeature) {
			return typeVec.get(startPoint).equals(horizontalFeature.typeVec.get(startPoint));
		}
	}
}

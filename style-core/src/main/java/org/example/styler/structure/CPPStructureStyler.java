package org.example.styler.structure;

import org.example.MyEnvironment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CPPStructureStyler extends StructureStyler{
	private static final Map<Integer, List<EquivalentStructure>> equivalencesMap = new HashMap<>();

	static {
		List<EquivalentStructure> equivalences = EquivalentStructureManager.getInstance().loadEquivalences(MyEnvironment.getIConfig().getCPPEquivalencesConfig(), "cpp"); // TBD: extend for other languages
		for (EquivalentStructure equivalence : equivalences) {
			for (int rule : equivalence.rules) {
				// create map for efficiency, avoid to traverse all configured structures.
				equivalencesMap.computeIfAbsent(rule, v -> new ArrayList<>()).add(equivalence);
			}
		}

	}

}

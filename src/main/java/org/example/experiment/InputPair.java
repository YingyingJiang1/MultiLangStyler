package org.example.experiment;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/22 3:01
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InputPair{
	int pairSize;
	transient int roundsSize;
	private String sourceDataset;
	private String targetDataset;
	private String resultBaseDir;
	private List<Round> rounds;
	transient private String experimentResult;

	public InputPair() {
	}

	public InputPair(int pairSize,int roundsSize, String sourceDataset,
	                 String targetDataset, String resultBaseDir, List<Round> rounds,
	                 String experimentResult) {
		this.pairSize = pairSize;
		this.roundsSize = roundsSize;
		this.sourceDataset = sourceDataset;
		this.targetDataset = targetDataset;
		this.resultBaseDir = resultBaseDir;
		this.rounds = rounds;
		this.experimentResult = experimentResult;
	}

	public InputPair(int pairSize, String sourceDataset, String targetDataset, String resultBaseDir) {
		this.pairSize = pairSize;
		this.sourceDataset = sourceDataset;
		this.targetDataset = targetDataset;
		this.resultBaseDir = resultBaseDir;
		this.rounds = new ArrayList<>();
	}

	public int getPairSize() {
		return pairSize;
	}

	public int getRoundsSize() {
		return roundsSize;
	}

	public String getSourceDataset() {
		return sourceDataset;
	}

	public String getTargetDataset() {
		return targetDataset;
	}

	public String getResultBaseDir() {
		return resultBaseDir;
	}

	public List<Round> getRounds() {
		return rounds;
	}

	public String getExperimentResult() {
		return experimentResult;
	}

	public void setPairSize(int pairSize) {
		this.pairSize = pairSize;
	}

	public void setRoundsSize(int roundsSize) {
		this.roundsSize = roundsSize;
	}

	public void setSourceDataset(String sourceDataset) {
		this.sourceDataset = sourceDataset;
	}

	public void setTargetDataset(String targetDataset) {
		this.targetDataset = targetDataset;
	}

	public void setResultBaseDir(String resultBaseDir) {
		this.resultBaseDir = resultBaseDir;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

	public void setExperimentResult(String experimentResult) {
		this.experimentResult = experimentResult;
	}

	static class Round {
		public String[] sources;
		public String[] targets;
		public String[] results;
		transient public Map<String, String> experimentResult;
		public Round() {
		}

		public Round(String[] sources, String[] targets, String[] results) {
			this.sources = sources;
			this.targets = targets;
			this.results = results;
		}

		public String[] getSources() {
			return sources;
		}

		public String[] getTargets() {
			return targets;
		}

		public String[] getResults() {
			return results;
		}

		public void setSources(String[] sources) {
			this.sources = sources;
		}

		public void setTargets(String[] targets) {
			this.targets = targets;
		}

		public void setResults(String[] results) {
			this.results = results;
		}
	}
}


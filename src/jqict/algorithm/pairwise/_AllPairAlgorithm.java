//package jqict.algorithm.pairwise;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class _AllPairAlgorithm {
//	private Random r = new Random(0);
//
//	private int numberParameters = 0;
//	private int numberParameterValues = 0;
//	private int numberPairs = 0;
//	private int poolSize = 20;
//	private int[][] legalValues = null;
//	private String[] parameterValues = null; // one-dimensional array of all
//	private int[][] allPairsDisplay = null; // rectangular array; does not
//	private List<int[]> unusedPairs = null; // changes
//	private int[][] unusedPairsSearch = null; // square array -- changes
//	private int[] parameterPositions = null; // the parameter position for a
//	private int[] unusedCounts = null; // count of each parameter value in
//	private List<int[]> testSets = null; // the main result data structure
//
//	public List<List<FactorValue>> generate(List<AllPairFactor> factors) {
//		try {
//			initializePairs();
//			computeTestSets();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return convertToPatterns();
//	} // Main()
//
//	private void initializePairs() {
//		for (int i = 0; i <= legalValues.length - 2; ++i) {
//			for (int j = i + 1; j <= legalValues.length - 1; ++j) {
//				numberPairs += (legalValues[i].length * legalValues[j].length);
//			}
//		}
//		allPairsDisplay = new int[numberPairs][2];
//		unusedPairs = new ArrayList<int[]>();
//		unusedPairsSearch = new int[numberParameterValues][numberParameterValues];
//		int currPair = 0;
//		for (int i = 0; i <= legalValues.length - 2; ++i) {
//			for (int j = i + 1; j <= legalValues.length - 1; ++j) {
//				int[] firstRow = legalValues[i];
//				int[] secondRow = legalValues[j];
//				for (int x = 0; x < firstRow.length; ++x) {
//					for (int y = 0; y < secondRow.length; ++y) {
//						allPairsDisplay[currPair][0] = firstRow[x];
//						allPairsDisplay[currPair][1] = secondRow[y];
//						int[] aPair = new int[2];
//						aPair[0] = firstRow[x];
//						aPair[1] = secondRow[y];
//						unusedPairs.add(aPair);
//						unusedPairsSearch[firstRow[x]][secondRow[y]] = 1;
//
//						++currPair;
//					}
//				}
//			}
//		}
//
//		parameterPositions = new int[numberParameterValues];
//		int k = 0;
//		for (int i = 0; i < legalValues.length; ++i) {
//			int[] curr = legalValues[i];
//			for (int j = 0; j < curr.length; ++j) {
//				parameterPositions[k++] = i;
//			}
//		}
//		unusedCounts = new int[numberParameterValues];
//		for (int i = 0; i < allPairsDisplay[0].length; ++i) {
//			++unusedCounts[allPairsDisplay[i][0]];
//			++unusedCounts[allPairsDisplay[i][1]];
//		}
//
//	}
//
//	private void computeTestSets() {
//		testSets = new ArrayList<int[]>(); // primary data structure
//		while (unusedPairs.size() > 0) {
//			int[][] candidateSets = new int[poolSize][];
//			for (int candidate = 0; candidate < poolSize; ++candidate) {
//				int[] testSet = new int[numberParameters];
//				int bestWeight = 0;
//				int indexOfBestPair = 0;
//				for (int i = 0; i < unusedPairs.size(); ++i) {
//					int[] curr = unusedPairs.get(i);
//					int weight = unusedCounts[curr[0]] + unusedCounts[curr[1]];
//					if (weight > bestWeight) {
//						bestWeight = weight;
//						indexOfBestPair = i;
//					}
//				}
//				int[] best = new int[2];
//				System.arraycopy(unusedPairs.get(indexOfBestPair), 0, best, 0,
//						unusedPairs.get(indexOfBestPair).length);
//
//				int firstPos = parameterPositions[best[0]];
//				int secondPos = parameterPositions[best[1]];
//				int[] ordering = new int[numberParameters];
//				for (int i = 0; i < numberParameters; ++i)
//					ordering[i] = i;
//				ordering[0] = firstPos;
//				ordering[firstPos] = 0;
//
//				int t = ordering[1];
//				ordering[1] = secondPos;
//				ordering[secondPos] = t;
//
//				for (int i = 2; i < ordering.length; i++) {
//					int j = r.nextInt(ordering.length - i);
//
//					int temp = ordering[j];
//					ordering[j] = ordering[i];
//					ordering[i] = temp;
//				}
//
//				testSet[firstPos] = best[0];
//				testSet[secondPos] = best[1];
//				for (int i = 2; i < numberParameters; ++i) {
//					int currPos = ordering[i];
//					int[] possibleValues = legalValues[currPos];
//					int currentCount = 0;
//					int highestCount = 0;
//					int bestJ = 0;
//					for (int j = 0; j < possibleValues.length; ++j) {
//						currentCount = 0;
//						for (int p = 0; p < i; ++p) {
//							int[] candidatePair = new int[] {
//									possibleValues[j], testSet[ordering[p]] };
//							if (unusedPairsSearch[candidatePair[0]][candidatePair[1]] == 1
//									|| unusedPairsSearch[candidatePair[1]][candidatePair[0]] == 1) {
//								++currentCount;
//							} else {
//							}
//						}
//						if (currentCount > highestCount) {
//							highestCount = currentCount;
//							bestJ = j;
//						}
//
//					}
//					testSet[currPos] = possibleValues[bestJ]; 
//				}
//				candidateSets[candidate] = testSet;
//			}
//
//			int indexOfBestCandidate = r.nextInt(candidateSets.length);
//			int mostPairsCaptured = NumberPairsCaptured(
//					candidateSets[indexOfBestCandidate], unusedPairsSearch);
//
//			int[] bestTestSet = new int[numberParameters];
//
//			for (int i = 0; i < candidateSets.length; ++i) {
//				int pairsCaptured = NumberPairsCaptured(candidateSets[i],
//						unusedPairsSearch);
//				if (pairsCaptured > mostPairsCaptured) {
//					mostPairsCaptured = pairsCaptured;
//					indexOfBestCandidate = i;
//				}
//			}
//			System.arraycopy(candidateSets[indexOfBestCandidate], 0,
//					bestTestSet, 0, candidateSets[indexOfBestCandidate].length);
//			testSets.add(bestTestSet);
//			for (int i = 0; i <= numberParameters - 2; ++i) {
//				for (int j = i + 1; j <= numberParameters - 1; ++j) {
//					int v1 = bestTestSet[i];
//					int v2 = bestTestSet[j];
//
//					--unusedCounts[v1];
//					--unusedCounts[v2];
//					unusedPairsSearch[v1][v2] = 0;
//
//					for (int p = 0; p < unusedPairs.size(); ++p) {
//						int[] curr = unusedPairs.get(p);
//
//						if (curr[0] == v1 && curr[1] == v2) {
//							unusedPairs.remove(p);
//						}
//					}
//				}
//			} 
//		}
//
//	}
//
//	private List<List<FactorValue>> convertToPatterns() {
//		List<List<FactorValue>> patterns = new ArrayList<List<FactorValue>>(
//				testSets.size());
//		for (int i = 0; i < testSets.size(); ++i) {
//			List<FactorValue> pattern = new ArrayList<FactorValue>();
//			int[] curr = testSets.get(i);
//			for (int j = 0; j < numberParameters; ++j) {
//				pattern.add(new FactorValue(j, parameterValues[curr[j]]));
//			}
//			patterns.add(pattern);
//		}
//		return patterns;
//	}
//
//	private int NumberPairsCaptured(int[] ts, int[][] unusedPairsSearch) {
//		int ans = 0;
//		for (int i = 0; i <= ts.length - 2; ++i) {
//			for (int j = i + 1; j <= ts.length - 1; ++j) {
//				if (unusedPairsSearch[ts[i]][ts[j]] == 1)
//					++ans;
//			}
//		}
//		return ans;
//	}
// }

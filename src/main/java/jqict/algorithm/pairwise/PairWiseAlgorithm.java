package jqict.algorithm.pairwise;

import java.util.ArrayList;
import java.util.List;

import jqict.core.Algorithm;
import jqict.core.Combination;
import jqict.core.CombinationList;
import jqict.core.ParameterList;

public class PairWiseAlgorithm implements Algorithm {
	private List<Combination> combinations;
	private AllPairList allPairList;
	private CombinationCreator creator;

	@Override
	public CombinationList generate(ParameterList parameters,
			int maxCombinationLimit) {
		initializeAllPairs(parameters);
		int limit = (maxCombinationLimit < 0) ? parameters.getSize()
				: maxCombinationLimit;
		for (int i = 0; i < limit; i++) {
			Combination newCombination = creator.create();
			if (newCombination == null) {
				break;
			}
			combinations.add(newCombination);
		}
		return new CombinationList(combinations);
	}

	private void initializeAllPairs(ParameterList parameters) {
		combinations = new ArrayList<Combination>();
		allPairList = new AllPairList(parameters);
		creator = new CombinationCreator(allPairList);
	}
}
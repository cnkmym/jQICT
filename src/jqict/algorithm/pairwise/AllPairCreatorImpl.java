package jqict.algorithm.pairwise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import jqict.core.CombinationValue;
import jqict.core.Dimension;

class AllPairCreatorImpl implements AllPairCreator {

	
	@Override
	public List<CombinationPair> generate(List<Dimension> dims) {
	
		List<CombinationPair> combinationPairs = new ArrayList<CombinationPair>();
		Deque<CombinationValue> stack = new ArrayDeque<CombinationValue>();
		combination(dims, 0, stack, combinationPairs);
		return combinationPairs;
	}

	private void combination(List<Dimension> dims, int pos,
			Deque<CombinationValue> stack, List<CombinationPair> combinationPairs) {
	
		if (!(pos < dims.size()))
			return;

		Dimension dim = dims.get(pos);
		for (String value : dim.getValues()) {
			CombinationValue combValue = new CombinationValue(dim.getName(), value);
			stack.push(combValue);
			combination(dims, pos + 1, stack, combinationPairs);
			combinationPairs.add(new CombinationPair(stack.getLast(), combValue));
			stack.pop();
		}

	}

	
}
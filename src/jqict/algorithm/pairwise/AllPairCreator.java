package jqict.algorithm.pairwise;

import java.util.List;

import jqict.core.Dimension;

interface AllPairCreator {

	public abstract List<CombinationPair> generate(List<Dimension> dims);

}
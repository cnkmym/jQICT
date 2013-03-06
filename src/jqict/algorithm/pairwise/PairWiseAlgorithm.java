package jqict.algorithm.pairwise;

import java.util.ArrayList;
import java.util.List;

import jqict.core.Algorithm;
import jqict.core.Combination;
import jqict.core.CombinationList;
import jqict.core.ParameterList;

public class PairWiseAlgorithm implements Algorithm {
        private List<Combination> combinations;
        private byte[][] allPairUsageMap;
        private List<Combination> candidates;

        @Override
        public CombinationList generate(ParameterList parameters,
                        int maxCombinationLimit) {
                initializeAllPairs();
                computeCombinations();
                return new CombinationList(combinations);
        }

        private void initializeAllPairs() {
                combinations = new ArrayList<Combination>();

        }

        private void computeCombinations() {

        }

}
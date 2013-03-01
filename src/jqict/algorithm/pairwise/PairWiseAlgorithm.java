package jqict.algorithm.pairwise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import jqict.core.Algorithm;
import jqict.core.Combination;
import jqict.core.CombinationTable;
import jqict.core.CombinationValue;
import jqict.core.Dimension;
import jqict.core.DimensionTable;

public class PairWiseAlgorithm implements Algorithm {

        @Override
        public CombinationTable generate(DimensionTable domain, int maxCombinationLimit) {

                Deque<CombinationValue> stack = new ArrayDeque<CombinationValue>();
                List<Combination> combinations = new ArrayList<Combination>();
                combine(domain.getDimensions(), 0, stack, combinations);

                return new CombinationTable(combinations);
        }

        private void combine(List<Dimension> dims, int pos,
                        Deque<CombinationValue> stack,
                        List<Combination> combinations) {

                if (!(pos < dims.size()))
                        return;

                Dimension dim = dims.get(pos);
                for (String value : dim.getValues()) {
                        stack.push(new CombinationValue(dim.getName(), value));
                        combine(dims, pos + 1, stack, combinations);
                        if (pos == dims.size() - 1) {
                                combinations.add(new Combination(
                                                new ArrayList<CombinationValue>(
                                                                stack)));
                        }
                        stack.pop();
                }
        }

}
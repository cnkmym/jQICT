package jqict.algorithm.fullcombination;

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

public class FullCombinationAlgorithm implements Algorithm {

        @Override
        public CombinationTable generate(DimensionTable domain,
                        int maxCombinationLimit) {

                Deque<CombinationValue> stack = new ArrayDeque<CombinationValue>();
                List<Combination> resultList = new ArrayList<Combination>();
                if (maxCombinationLimit != 0) {
                        combine(domain.getDimensions(), 0, stack, resultList,
                                        maxCombinationLimit);
                }

                return new CombinationTable(resultList);
        }

        /**
         * 
         * @param dims
         * @param fromPosition
         * @param stack
         * @param resultList
         * @param maxCombinationLimit
         */
        private boolean combine(List<Dimension> dims, int fromPosition,
                        Deque<CombinationValue> stack,
                        List<Combination> resultList, int maxCombinationLimit) {

                if (fromPosition >= dims.size()) {
                        return true;
                }

                Dimension dim = dims.get(fromPosition);
                for (String value : dim.getValues()) {
                        stack.push(new CombinationValue(dim.getId(), dim
                                        .getName(), value));
                        if (!combine(dims, fromPosition + 1, stack, resultList,
                                        maxCombinationLimit)) {
                                return false;
                        }
                        if (fromPosition == dims.size() - 1) {
                                resultList.add(new Combination(
                                                new ArrayList<CombinationValue>(
                                                                stack)));
                                if (maxCombinationLimit > 0
                                                && resultList.size() >= maxCombinationLimit) {
                                        return false;
                                }
                        }
                        stack.pop();
                }

                return true;
        }
}

package jqict.algorithm.pairwise;

import jqict.core.Combination;
import jqict.core.CombinationValue;

class CombinationPair {

        private final CombinationValue first;
        private final CombinationValue second;

        public CombinationPair(CombinationValue first, CombinationValue second) {
                this.first = first;
                this.second = second;
        }

        public CombinationValue getFirst() {
                return first;
        }

        public CombinationValue getSecond() {
                return second;
        }

}

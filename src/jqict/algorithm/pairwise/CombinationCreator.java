package jqict.algorithm.pairwise;

import java.util.Random;

import jqict.core.Combination;

public class CombinationCreator {
        private AllPairList allPairList;
        private boolean[] pairUsed;
        private Combination candidate;
        private Random random;

        public CombinationCreator(AllPairList pairs) {
                super();
                random = new Random();
                this.allPairList = pairs;
                this.pairUsed = pairs.copyPairUsed();
        }

        public Combination create() {
                Pair newPair = this.allPairList.nextUnusedPair();
                int[] order = shuffleParameterOrders(
                                this.allPairList.getParameterCount(), newPair);
                candidate = findCandidateCombinationByOrder(order);
                if (!candidate.equals(null)) {
                        updatePairUsage();
                }
                return candidate;
        }

        private Combination findCandidateCombinationByOrder(int[] order) {
                // FIXME
                return null;
        }

        private void updatePairUsage() {
                // FIXME
        }

        private void swap(int[] list, int pos1, int pos2) {
                int temp = list[pos1];
                list[pos1] = list[pos2];
                list[pos2] = temp;
        }

        private int[] shuffleParameterOrders(int length, Pair fixedPair) {
                int[] order = new int[length];
                int param1Index = allPairList
                                .getParameterIndexByValueIndex(fixedPair
                                                .getParam1ValueIndex());
                int param2Index = allPairList
                                .getParameterIndexByValueIndex(fixedPair
                                                .getParam2ValueIndex());

                order[0] = param1Index;
                order[1] = param2Index;
                int index = 2;
                for (int i = 0; i < length; i++) {
                        if (i != order[0] && i != order[1]) {
                                order[index++] = i;
                        }
                }
                // Knuth Shuffle
                for (int i = 2; i < length; i++) {
                        int j = i + random.nextInt(length - i);
                        if (i != j) {
                                swap(order, i, j);
                        }
                }

                return order;
        }
}

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
        }

        public Combination create() {
                Pair newPair = this.allPairList.nextUnusedPair();
                if (newPair == null) {
                        return null;
                }
                this.pairUsed = this.allPairList.copyPairUsed();
                int[] order = shuffleParameterOrders(
                                this.allPairList.getParameterCount(), newPair);
                findCandidateCombinationByOrder(order, newPair);
                updatePairUsage();
                return candidate;
        }

        private void useParameterValuePair(int pairIndex) {
                Pair newPair = this.allPairList.getAvailablePairs()[pairIndex];
                Long param1Id = this.allPairList
                                .getParameterIdByValueIndex(newPair
                                                .getParam1ValueIndex());
                if (!candidate.getMap().containsKey(param1Id)) {
                        candidate.getMap()
                                        .put(param1Id,
                                                        this.allPairList.getParameterValuePairByValueIndex(newPair
                                                                        .getParam1ValueIndex()));
                }

                Long param2Id = this.allPairList
                                .getParameterIdByValueIndex(newPair
                                                .getParam2ValueIndex());
                if (!candidate.getMap().containsKey(param2Id)) {
                        candidate.getMap()
                                        .put(param2Id,
                                                        this.allPairList.getParameterValuePairByValueIndex(newPair
                                                                        .getParam2ValueIndex()));
                }

                this.pairUsed[pairIndex] = true;
        }

        private int findBestValueIndex(int[] candidateIndexes) {
                int currentIndex = -1;
                int count = 0;
                int bestCount = -1;
                for (int i = 0; i < candidateIndexes.length; i++) {
                        count = 0;
                        Integer[] indices = this.allPairList
                                        .getPairIndexesByValueIndex(candidateIndexes[i]);
                        for (Integer index : indices) {
                                if (!this.pairUsed[index]) {
                                        count++;
                                }
                        }
                        if (count > bestCount) {
                                currentIndex = i;
                                bestCount = count;
                        }
                }
                return currentIndex;
        }

        private void findCandidateCombinationByOrder(int[] order, Pair fixedPair) {
                this.candidate = new Combination();
                useParameterValuePair(fixedPair.getPairIndex());

                for (int i = 2; i < order.length; i++) {
                        int paramIndex = order[i];
                        int[] valueIndexes = this.allPairList
                                        .getValueIndexByParameterIndex(paramIndex);
                        int bestValueIndex = findBestValueIndex(valueIndexes);
                        Integer[] indices = this.allPairList
                                        .getPairIndexesByValueIndex(bestValueIndex);

                        for (Integer index : indices) {
                                useParameterValuePair(index);
                        }
                }
        }

        private void updatePairUsage() {
                for (int i = 0; i < pairUsed.length; i++) {
                        if (pairUsed[i]) {
                                this.allPairList.usePair(i);
                        }
                }
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

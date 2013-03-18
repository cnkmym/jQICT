package jp.co.worksap.ate.jpict.testutil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.worksap.ate.jpict.algorithm.pairwise.OnePair;
import jp.co.worksap.ate.jpict.core.Combination;
import jp.co.worksap.ate.jpict.core.CombinationList;
import jp.co.worksap.ate.jpict.core.ParameterValuePair;

public class PairComparator {
        public static boolean hasAllPairs(final List<OnePair> allPairs,
                        CombinationList combinations) {
                List<OnePair> temp = new ArrayList<OnePair>(allPairs.size()) {
                        private static final long serialVersionUID = 4834656468536867694L;

                        {
                                addAll(allPairs);
                        }
                };

                for (Combination combination : combinations.getCombinations()) {
                        Map<Long, ParameterValuePair> valueMap = combination
                                        .getMap();
                        Long[] ids = valueMap.keySet().toArray(new Long[0]);
                        for (int i = 0; i < ids.length - 1; i++) {
                                Long id1 = ids[i];
                                String value1 = valueMap.get(id1)
                                                .getParameterValue();

                                for (int j = i + 1; j < ids.length; j++) {
                                        Long id2 = ids[j];
                                        String value2 = valueMap.get(id2)
                                                        .getParameterValue();
                                        // if some pair is not included
                                        OnePair newPair = new OnePair(id1,
                                                        value1, id2, value2);
                                        // if (!allPairs.contains(newPair)) {
                                        // return false;
                                        // }
                                        temp.remove(newPair);
                                }
                        }
                }

                return (temp.size() == 0);
        }
}

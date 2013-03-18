package jp.co.worksap.ate.jpict.algorithm.pairwise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.co.worksap.ate.jpict.core.Algorithm;
import jp.co.worksap.ate.jpict.core.CombinationList;
import jp.co.worksap.ate.jpict.core.Parameter;
import jp.co.worksap.ate.jpict.core.ParameterList;
import jp.co.worksap.ate.jpict.testutil.PairComparator;
import jp.co.worksap.ate.jpict.testutil.ParameterFileReader;
import junit.framework.TestCase;

import org.junit.Test;

import com.google.gson.JsonSyntaxException;

public class PairwiseAlgorithmTest extends TestCase {

        @Test
        public void test0() {
                Algorithm target = new PairWiseAlgorithm();

                List<Parameter> parameters = new ArrayList<Parameter>();
                parameters.add(new Parameter(1L, "hoge1", Arrays
                                .asList(new String[] { "T", "F" })));

                ParameterList parameterList = new ParameterList(parameters);
                CombinationList combinations = target.generate(parameterList,
                                -1);

                // if there is no pair, there should be no combination
                int expectedPairs = 0;
                assertEquals(expectedPairs, combinations.getCombinations()
                                .size());

        }

        @Test
        public void test1() {
                Algorithm target = new PairWiseAlgorithm();

                List<Parameter> parameters = new ArrayList<Parameter>();
                parameters.add(new Parameter(1L, "param1", Arrays
                                .asList(new String[] { "A", "B" })));
                parameters.add(new Parameter(2L, "param2", Arrays
                                .asList(new String[] { "C" })));

                ParameterList parameterList = new ParameterList(parameters);
                CombinationList combinations = target.generate(parameterList,
                                -1);

                // if there is 2 pair
                int expectedPairs = 2;

                List<OnePair> allPairs = new ArrayList<OnePair>(expectedPairs) {
                        private static final long serialVersionUID = 1L;

                        {
                                add(new OnePair(1L, "A", 2L, "C"));
                                add(new OnePair(1L, "B", 2L, "C"));
                        }
                };
                assertTrue(PairComparator.hasAllPairs(allPairs, combinations));
        }

        @Test
        public void test2() {
                Algorithm target = new PairWiseAlgorithm();

                List<Parameter> parameters = new ArrayList<Parameter>();
                parameters.add(new Parameter(1L, "param1", Arrays
                                .asList(new String[] { "A" })));
                parameters.add(new Parameter(2L, "param2", Arrays
                                .asList(new String[] { "C", "D" })));

                ParameterList parameterList = new ParameterList(parameters);
                CombinationList combinations = target.generate(parameterList,
                                -1);

                // if there is 2 pair
                int expectedPairs = 2;

                List<OnePair> allPairs = new ArrayList<OnePair>(expectedPairs) {
                        private static final long serialVersionUID = 1L;

                        {
                                add(new OnePair(1L, "A", 2L, "C"));
                                add(new OnePair(1L, "A", 2L, "D"));
                        }
                };
                assertTrue(PairComparator.hasAllPairs(allPairs, combinations));

        }

        @Test
        public void test3() {
                Algorithm target = new PairWiseAlgorithm();

                List<Parameter> parameters = new ArrayList<Parameter>();
                parameters.add(new Parameter(1L, "param1", Arrays
                                .asList(new String[] { "A", "B" })));
                parameters.add(new Parameter(2L, "param2", Arrays
                                .asList(new String[] { "C", "D" })));

                ParameterList parameterList = new ParameterList(parameters);
                CombinationList combinations = target.generate(parameterList,
                                -1);

                // if there is 2 pair
                int expectedPairs = 4;

                List<OnePair> allPairs = new ArrayList<OnePair>(expectedPairs) {
                        private static final long serialVersionUID = 1L;

                        {
                                add(new OnePair(1L, "A", 2L, "C"));
                                add(new OnePair(1L, "A", 2L, "D"));
                                add(new OnePair(1L, "B", 2L, "C"));
                                add(new OnePair(1L, "B", 2L, "D"));
                        }
                };
                assertTrue(PairComparator.hasAllPairs(allPairs, combinations));
        }

        @Test
        public void test4() {
                Algorithm target = new PairWiseAlgorithm();

                List<Parameter> parameters = new ArrayList<Parameter>();
                parameters.add(new Parameter(1L, "param1", Arrays
                                .asList(new String[] { "A", "B" })));
                parameters.add(new Parameter(2L, "param2", Arrays
                                .asList(new String[] { "C", "D", "E" })));

                ParameterList parameterList = new ParameterList(parameters);
                CombinationList combinations = target.generate(parameterList,
                                -1);

                // if there is 6 pair
                int expectedPairs = 6;

                List<OnePair> allPairs = new ArrayList<OnePair>(expectedPairs) {
                        private static final long serialVersionUID = 1L;

                        {
                                add(new OnePair(1L, "A", 2L, "C"));
                                add(new OnePair(1L, "A", 2L, "D"));
                                add(new OnePair(1L, "A", 2L, "E"));
                                add(new OnePair(1L, "B", 2L, "C"));
                                add(new OnePair(1L, "B", 2L, "D"));
                                add(new OnePair(1L, "B", 2L, "E"));
                        }
                };
                assertTrue(PairComparator.hasAllPairs(allPairs, combinations));
        }

        @Test
        public void test5() {
                Algorithm target = new PairWiseAlgorithm();

                List<Parameter> parameters = new ArrayList<Parameter>();
                parameters.add(new Parameter(1L, "param1", Arrays
                                .asList(new String[] { "1", "2", "3" })));
                parameters.add(new Parameter(2L, "param2", Arrays
                                .asList(new String[] { "C", "D" })));

                ParameterList parameterList = new ParameterList(parameters);
                CombinationList combinations = target.generate(parameterList,
                                -1);

                // if there is 6 pair
                int expectedPairs = 6;

                List<OnePair> allPairs = new ArrayList<OnePair>(expectedPairs) {
                        private static final long serialVersionUID = 1L;

                        {
                                add(new OnePair(1L, "1", 2L, "C"));
                                add(new OnePair(1L, "1", 2L, "D"));
                                add(new OnePair(1L, "2", 2L, "C"));
                                add(new OnePair(1L, "2", 2L, "D"));
                                add(new OnePair(1L, "3", 2L, "C"));
                                add(new OnePair(1L, "3", 2L, "D"));
                        }
                };
                assertTrue(PairComparator.hasAllPairs(allPairs, combinations));
        }

        @Test
        public void test6() {
                Algorithm target = new PairWiseAlgorithm();

                List<Parameter> parameters = new ArrayList<Parameter>();
                parameters.add(new Parameter(1L, "param1", Arrays
                                .asList(new String[] { "1", "2", "3" })));
                parameters.add(new Parameter(2L, "param2", Arrays
                                .asList(new String[] { "C" })));
                parameters.add(new Parameter(3L, "param2", Arrays
                                .asList(new String[] { "x", "y" })));

                ParameterList parameterList = new ParameterList(parameters);
                CombinationList combinations = target.generate(parameterList,
                                -1);

                // if there is 11 pairs
                // 3*(1+2) + 1*2 = 11
                int expectedPairs = 11;

                List<OnePair> allPairs = new ArrayList<OnePair>(expectedPairs) {
                        private static final long serialVersionUID = 1L;

                        {
                                add(new OnePair(1L, "1", 2L, "C"));
                                add(new OnePair(1L, "1", 3L, "x"));
                                add(new OnePair(1L, "1", 3L, "y"));
                                add(new OnePair(1L, "2", 2L, "C"));
                                add(new OnePair(1L, "2", 3L, "x"));
                                add(new OnePair(1L, "2", 3L, "y"));
                                add(new OnePair(1L, "3", 2L, "C"));
                                add(new OnePair(1L, "3", 3L, "x"));
                                add(new OnePair(1L, "3", 3L, "y"));
                                add(new OnePair(2L, "C", 3L, "x"));
                                add(new OnePair(2L, "C", 3L, "y"));
                        }
                };
                assertTrue(PairComparator.hasAllPairs(allPairs, combinations));
        }

        @Test
        public void test7() {
                Algorithm target = new PairWiseAlgorithm();

                List<Parameter> parameters = new ArrayList<Parameter>();
                parameters.add(new Parameter(0L, "Param0", Arrays
                                .asList(new String[] { "a", "b" })));
                parameters.add(new Parameter(1L, "Param1", Arrays
                                .asList(new String[] { "c", "d", "e", "f" })));
                parameters.add(new Parameter(2L, "Param2", Arrays
                                .asList(new String[] { "01", "001" })));
                parameters.add(new Parameter(3L, "Param3", Arrays
                                .asList(new String[] { "g", "h", "i" })));
                parameters.add(new Parameter(4L, "Param4", Arrays
                                .asList(new String[] { "j", "k" })));

                ParameterList parameterList = new ParameterList(parameters);
                CombinationList combinations = target.generate(parameterList,
                                -1);

                // if there is 66 pair : 
                // 2*(4 + 2+3+2) + 4*(2+3+2) + 2*(3+2) + 3*2 = 66
                int expectedPairs = 66;

                List<OnePair> allPairs = new ArrayList<OnePair>(expectedPairs) {
                        private static final long serialVersionUID = 1L;

                        {
                                // pairs starting with parameter 1
                                add(new OnePair(0L, "a", 1L, "c"));
                                add(new OnePair(0L, "a", 1L, "d"));
                                add(new OnePair(0L, "a", 1L, "e"));
                                add(new OnePair(0L, "a", 1L, "f"));
                                add(new OnePair(0L, "a", 2L, "01"));
                                add(new OnePair(0L, "a", 2L, "001"));
                                add(new OnePair(0L, "a", 3L, "g"));
                                add(new OnePair(0L, "a", 3L, "h"));
                                add(new OnePair(0L, "a", 3L, "i"));
                                add(new OnePair(0L, "a", 4L, "j"));
                                add(new OnePair(0L, "a", 4L, "k"));

                                add(new OnePair(0L, "b", 1L, "c"));
                                add(new OnePair(0L, "b", 1L, "d"));
                                add(new OnePair(0L, "b", 1L, "e"));
                                add(new OnePair(0L, "b", 1L, "f"));
                                add(new OnePair(0L, "b", 2L, "01"));
                                add(new OnePair(0L, "b", 2L, "001"));
                                add(new OnePair(0L, "b", 3L, "g"));
                                add(new OnePair(0L, "b", 3L, "h"));
                                add(new OnePair(0L, "b", 3L, "i"));
                                add(new OnePair(0L, "b", 4L, "j"));
                                add(new OnePair(0L, "b", 4L, "k"));

                                // pairs starting with parameter 2
                                add(new OnePair(1L, "c", 2L, "01"));
                                add(new OnePair(1L, "c", 2L, "001"));
                                add(new OnePair(1L, "c", 3L, "g"));
                                add(new OnePair(1L, "c", 3L, "h"));
                                add(new OnePair(1L, "c", 3L, "i"));
                                add(new OnePair(1L, "c", 4L, "j"));
                                add(new OnePair(1L, "c", 4L, "k"));

                                add(new OnePair(1L, "d", 2L, "01"));
                                add(new OnePair(1L, "d", 2L, "001"));
                                add(new OnePair(1L, "d", 3L, "g"));
                                add(new OnePair(1L, "d", 3L, "h"));
                                add(new OnePair(1L, "d", 3L, "i"));
                                add(new OnePair(1L, "d", 4L, "j"));
                                add(new OnePair(1L, "d", 4L, "k"));

                                add(new OnePair(1L, "e", 2L, "01"));
                                add(new OnePair(1L, "e", 2L, "001"));
                                add(new OnePair(1L, "e", 3L, "g"));
                                add(new OnePair(1L, "e", 3L, "h"));
                                add(new OnePair(1L, "e", 3L, "i"));
                                add(new OnePair(1L, "e", 4L, "j"));
                                add(new OnePair(1L, "e", 4L, "k"));

                                add(new OnePair(1L, "f", 2L, "01"));
                                add(new OnePair(1L, "f", 2L, "001"));
                                add(new OnePair(1L, "f", 3L, "g"));
                                add(new OnePair(1L, "f", 3L, "h"));
                                add(new OnePair(1L, "f", 3L, "i"));
                                add(new OnePair(1L, "f", 4L, "j"));
                                add(new OnePair(1L, "f", 4L, "k"));

                                // pairs starting with parameter 3
                                add(new OnePair(2L, "01", 3L, "g"));
                                add(new OnePair(2L, "01", 3L, "h"));
                                add(new OnePair(2L, "01", 3L, "i"));
                                add(new OnePair(2L, "01", 4L, "j"));
                                add(new OnePair(2L, "01", 4L, "k"));

                                add(new OnePair(2L, "001", 3L, "g"));
                                add(new OnePair(2L, "001", 3L, "h"));
                                add(new OnePair(2L, "001", 3L, "i"));
                                add(new OnePair(2L, "001", 4L, "j"));
                                add(new OnePair(2L, "001", 4L, "k"));

                                // pairs starting with parameter 4
                                add(new OnePair(3L, "g", 4L, "j"));
                                add(new OnePair(3L, "g", 4L, "k"));

                                add(new OnePair(3L, "h", 4L, "j"));
                                add(new OnePair(3L, "h", 4L, "k"));

                                add(new OnePair(3L, "i", 4L, "j"));
                                add(new OnePair(3L, "i", 4L, "k"));

                        }
                };
                assertTrue(PairComparator.hasAllPairs(allPairs, combinations));
        }

        @Test
        public void test_readDataFromFile() throws JsonSyntaxException,
                        IOException {
                Algorithm target = new PairWiseAlgorithm();

                ParameterList parameters = new ParameterFileReader()
                                .getParameterList("data/testData.txt");
                assertEquals(5, parameters.getParameters().size());
                CombinationList combinations = target.generate(parameters, -1);

                // if there is 66 pair
                int expectedPairs = 66;

                List<OnePair> allPairs = new ArrayList<OnePair>(expectedPairs) {
                        private static final long serialVersionUID = 1L;

                        {
                                // pairs starting with parameter 1
                                add(new OnePair(0L, "a", 1L, "c"));
                                add(new OnePair(0L, "a", 1L, "d"));
                                add(new OnePair(0L, "a", 1L, "e"));
                                add(new OnePair(0L, "a", 1L, "f"));
                                add(new OnePair(0L, "a", 2L, "01"));
                                add(new OnePair(0L, "a", 2L, "001"));
                                add(new OnePair(0L, "a", 3L, "g"));
                                add(new OnePair(0L, "a", 3L, "h"));
                                add(new OnePair(0L, "a", 3L, "i"));
                                add(new OnePair(0L, "a", 4L, "j"));
                                add(new OnePair(0L, "a", 4L, "k"));

                                add(new OnePair(0L, "b", 1L, "c"));
                                add(new OnePair(0L, "b", 1L, "d"));
                                add(new OnePair(0L, "b", 1L, "e"));
                                add(new OnePair(0L, "b", 1L, "f"));
                                add(new OnePair(0L, "b", 2L, "01"));
                                add(new OnePair(0L, "b", 2L, "001"));
                                add(new OnePair(0L, "b", 3L, "g"));
                                add(new OnePair(0L, "b", 3L, "h"));
                                add(new OnePair(0L, "b", 3L, "i"));
                                add(new OnePair(0L, "b", 4L, "j"));
                                add(new OnePair(0L, "b", 4L, "k"));

                                // pairs starting with parameter 2
                                add(new OnePair(1L, "c", 2L, "01"));
                                add(new OnePair(1L, "c", 2L, "001"));
                                add(new OnePair(1L, "c", 3L, "g"));
                                add(new OnePair(1L, "c", 3L, "h"));
                                add(new OnePair(1L, "c", 3L, "i"));
                                add(new OnePair(1L, "c", 4L, "j"));
                                add(new OnePair(1L, "c", 4L, "k"));

                                add(new OnePair(1L, "d", 2L, "01"));
                                add(new OnePair(1L, "d", 2L, "001"));
                                add(new OnePair(1L, "d", 3L, "g"));
                                add(new OnePair(1L, "d", 3L, "h"));
                                add(new OnePair(1L, "d", 3L, "i"));
                                add(new OnePair(1L, "d", 4L, "j"));
                                add(new OnePair(1L, "d", 4L, "k"));

                                add(new OnePair(1L, "e", 2L, "01"));
                                add(new OnePair(1L, "e", 2L, "001"));
                                add(new OnePair(1L, "e", 3L, "g"));
                                add(new OnePair(1L, "e", 3L, "h"));
                                add(new OnePair(1L, "e", 3L, "i"));
                                add(new OnePair(1L, "e", 4L, "j"));
                                add(new OnePair(1L, "e", 4L, "k"));

                                add(new OnePair(1L, "f", 2L, "01"));
                                add(new OnePair(1L, "f", 2L, "001"));
                                add(new OnePair(1L, "f", 3L, "g"));
                                add(new OnePair(1L, "f", 3L, "h"));
                                add(new OnePair(1L, "f", 3L, "i"));
                                add(new OnePair(1L, "f", 4L, "j"));
                                add(new OnePair(1L, "f", 4L, "k"));

                                // pairs starting with parameter 3
                                add(new OnePair(2L, "01", 3L, "g"));
                                add(new OnePair(2L, "01", 3L, "h"));
                                add(new OnePair(2L, "01", 3L, "i"));
                                add(new OnePair(2L, "01", 4L, "j"));
                                add(new OnePair(2L, "01", 4L, "k"));

                                add(new OnePair(2L, "001", 3L, "g"));
                                add(new OnePair(2L, "001", 3L, "h"));
                                add(new OnePair(2L, "001", 3L, "i"));
                                add(new OnePair(2L, "001", 4L, "j"));
                                add(new OnePair(2L, "001", 4L, "k"));

                                // pairs starting with parameter 4
                                add(new OnePair(3L, "g", 4L, "j"));
                                add(new OnePair(3L, "g", 4L, "k"));

                                add(new OnePair(3L, "h", 4L, "j"));
                                add(new OnePair(3L, "h", 4L, "k"));

                                add(new OnePair(3L, "i", 4L, "j"));
                                add(new OnePair(3L, "i", 4L, "k"));

                        }
                };
                assertTrue(PairComparator.hasAllPairs(allPairs, combinations));
        }

}

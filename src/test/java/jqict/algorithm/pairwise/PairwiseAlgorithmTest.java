package jqict.algorithm.pairwise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jqict.algorithm.fullcombination.FullCombinationAlgorithm;
import jqict.core.Algorithm;
import jqict.core.Combination;
import jqict.core.CombinationList;
import jqict.core.Parameter;
import jqict.core.ParameterList;
import jqict.core.ParameterValuePair;
import jqict.util.ParameterFileReader;
import junit.framework.TestCase;

import org.junit.Test;

import com.google.gson.JsonSyntaxException;

public class PairwiseAlgorithmTest extends TestCase {

	private boolean checkAllPairCovered(ParameterList parameters,
			CombinationList combinations) {
		AllPairList allPairs = new AllPairList(parameters);
		Set<Pair> usedPairs = new HashSet<Pair>();
		for (Combination combination : combinations.getCombinations()) {
			Set<Long> keys = combination.getMap().keySet();
			Long[] keyArray = keys.toArray(new Long[keys.size()]);
			for (int i = 0; i < keyArray.length - 1; i++) {
				ParameterValuePair value1 = combination.get(keyArray[i]);
				int valueIndex1 = allPairs
						.getValueIndexByParameterValuePair(value1);
				for (int j = i + 1; j < keyArray.length; j++) {
					ParameterValuePair value2 = combination.get(keyArray[j]);
					int valueIndex2 = allPairs
							.getValueIndexByParameterValuePair(value2);
					usedPairs.add(new Pair(0, valueIndex1, valueIndex2));
				}
			}
		}
		return allPairs.getPairCount() == usedPairs.size();
	}

	@Test
	public void test0() {
		Algorithm target = new PairWiseAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(1L, "hoge1", Arrays.asList(new String[] {
				"T", "F" })));

		ParameterList parameterList = new ParameterList(parameters);
		CombinationList combinations = target.generate(parameterList, -1);

		assertEquals(0, combinations.getCombinations().size());
		// assertTrue(checkAllPairCovered(parameterList, combinations));

		// String ret = "[";
		// ret += "[{id:1,name:hoge1,value:T}],";
		// ret += "[{id:1,name:hoge1,value:F}]";
		// ret += "]";
		//
		// System.out.println(combinations.toString());

	}

	@Test
	public void test1() {
		Algorithm target = new PairWiseAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(0L, "Param0", Arrays.asList(new String[] {
				"a", "b" })));
		parameters.add(new Parameter(1L, "Param1", Arrays.asList(new String[] {
				"c", "d", "e", "f" })));
		parameters.add(new Parameter(2L, "Param2", Arrays.asList(new String[] {
				"01", "001" })));
		parameters.add(new Parameter(3L, "Param3", Arrays.asList(new String[] {
				"g", "h", "i" })));
		parameters.add(new Parameter(4L, "Param4", Arrays.asList(new String[] {
				"j", "k" })));

		ParameterList parameterList = new ParameterList(parameters);
		CombinationList combinations = target.generate(parameterList, -1);

		assertTrue(checkAllPairCovered(parameterList, combinations));
		// String ret = "[";
		// ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:0}],";
		// ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:1}],";
		// ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:0}],";
		// ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:1}]";
		// ret += "]";

		// assertEquals(ret, ct.toString());
		System.out.println(combinations.toString());

	}

	@Test
	public void test2() {
		Algorithm target = new PairWiseAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(3L, "hoge1", Arrays
				.asList(new String[] { "T" })));
		parameters.add(new Parameter(4L, "hoge2", Arrays.asList(new String[] {
				"0", "1" })));

		ParameterList parameterList = new ParameterList(parameters);
		CombinationList combinations = target.generate(parameterList, -1);

		assertTrue(checkAllPairCovered(parameterList, combinations));

		// String ret = "[";
		// ret += "[{id:3,name:hoge1,value:T},{id:4,name:hoge2,value:0}],";
		// ret += "[{id:3,name:hoge1,value:T},{id:4,name:hoge2,value:1}]";
		// ret += "]";

		System.out.println(combinations.toString());

	}

	@Test
	public void test3() {
		Algorithm target = new PairWiseAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(1L, "hoge1", Arrays.asList(new String[] {
				"T", "F" })));
		parameters.add(new Parameter(2L, "hoge2", Arrays
				.asList(new String[] { "0" })));

		ParameterList parameterList = new ParameterList(parameters);
		CombinationList combinations = target.generate(parameterList, -1);

		assertTrue(checkAllPairCovered(parameterList, combinations));
		// String ret = "[";
		// ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:0}],";
		// ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:0}]";
		// ret += "]";

		System.out.println(combinations.toString());
	}

	@Test
	public void test4() {
		Algorithm target = new PairWiseAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(1L, "hoge1", Arrays.asList(new String[] {
				"T", "F" })));
		parameters.add(new Parameter(2L, "hoge2", Arrays.asList(new String[] {
				"0", "1", "2" })));

		ParameterList parameterList = new ParameterList(parameters);
		CombinationList combinations = target.generate(parameterList, -1);

		assertTrue(checkAllPairCovered(parameterList, combinations));

		// String ret = "[";
		// ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:0}],";
		// ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:1}],";
		// ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:2}],";
		// ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:0}],";
		// ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:1}],";
		// ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:2}]";
		// ret += "]";

		System.out.println(combinations.toString());
	}

	@Test
	public void test5() {
		Algorithm target = new PairWiseAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(1L, "hoge1", Arrays.asList(new String[] {
				"T", "F", "G" })));
		parameters.add(new Parameter(2L, "hoge2", Arrays.asList(new String[] {
				"0", "1" })));

		ParameterList parameterList = new ParameterList(parameters);
		CombinationList combinations = target.generate(parameterList, 0);
		String ret = "[]";

		assertEquals(ret, combinations.toString());

	}

	@Test
	public void test6() {
		Algorithm target = new PairWiseAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(1L, "hoge1", Arrays.asList(new String[] {
				"T", "F", "G" })));
		parameters.add(new Parameter(2L, "hoge2", Arrays.asList(new String[] {
				"0", "1" })));

		ParameterList parameterList = new ParameterList(parameters);
		CombinationList combinations = target.generate(parameterList, 5);

		assertEquals(5, combinations.getCombinations().size());

	}

	@Test
	public void test_readDataFromFile() throws JsonSyntaxException, IOException {
		Algorithm target = new PairWiseAlgorithm();

		ParameterList parameters = new ParameterFileReader()
				.getParameterList("data/testData.txt");
		assertEquals(5, parameters.getParameters().size());
		CombinationList combinations = target.generate(parameters, -1);
		
		assertTrue(combinations.getCombinations().size() > 0);
		assertTrue(combinations.getCombinations().size() < parameters.getSize());

		System.out.println(combinations);
	}

}

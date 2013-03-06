package jp.co.worksap.ate.jpict.algorithm.fullcombination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.co.worksap.ate.jpict.algorithm.fullcombination.FullCombinationAlgorithm;
import jp.co.worksap.ate.jpict.core.Algorithm;
import jp.co.worksap.ate.jpict.core.CombinationList;
import jp.co.worksap.ate.jpict.core.Parameter;
import jp.co.worksap.ate.jpict.core.ParameterList;
import jp.co.worksap.ate.jpict.util.ParameterFileReader;
import junit.framework.TestCase;

import org.junit.Test;

import com.google.gson.JsonSyntaxException;

public class FullCombinationAlgorithmTest extends TestCase {

	@Test
	public void test0() {
		Algorithm target = new FullCombinationAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(1L, "hoge1", Arrays.asList(new String[] {
				"T", "F" })));

		CombinationList ct = target.generate(new ParameterList(parameters), -1);
		String ret = "[";
		ret += "[{id:1,name:hoge1,value:T}],";
		ret += "[{id:1,name:hoge1,value:F}]";
		ret += "]";

		assertEquals(ret, ct.toString());

	}

	@Test
	public void test1() {
		Algorithm target = new FullCombinationAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(1L, "hoge1", Arrays.asList(new String[] {
				"T", "F" })));
		parameters.add(new Parameter(2L, "hoge2", Arrays.asList(new String[] {
				"0", "1" })));

		CombinationList ct = target.generate(new ParameterList(parameters), -1);

		String ret = "[";
		ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:0}],";
		ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:1}],";
		ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:0}],";
		ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:1}]";
		ret += "]";

		assertEquals(ret, ct.toString());

	}

	@Test
	public void test2() {
		Algorithm target = new FullCombinationAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(3L, "hoge1", Arrays
				.asList(new String[] { "T" })));
		parameters.add(new Parameter(4L, "hoge2", Arrays.asList(new String[] {
				"0", "1" })));

		CombinationList ct = target.generate(new ParameterList(parameters), -1);

		String ret = "[";
		ret += "[{id:3,name:hoge1,value:T},{id:4,name:hoge2,value:0}],";
		ret += "[{id:3,name:hoge1,value:T},{id:4,name:hoge2,value:1}]";
		ret += "]";

		assertEquals(ret, ct.toString());
	}

	@Test
	public void test3() {
		Algorithm target = new FullCombinationAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(1L, "hoge1", Arrays.asList(new String[] {
				"T", "F" })));
		parameters.add(new Parameter(2L, "hoge2", Arrays
				.asList(new String[] { "0" })));

		CombinationList ct = target.generate(new ParameterList(parameters), -1);
		String ret = "[";
		ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:0}],";
		ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:0}]";
		ret += "]";

		assertEquals(ret, ct.toString());
	}

	@Test
	public void test4() {
		Algorithm target = new FullCombinationAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(1L, "hoge1", Arrays.asList(new String[] {
				"T", "F" })));
		parameters.add(new Parameter(2L, "hoge2", Arrays.asList(new String[] {
				"0", "1", "2" })));

		CombinationList ct = target.generate(new ParameterList(parameters), -1);
		String ret = "[";
		ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:0}],";
		ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:1}],";
		ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:2}],";
		ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:0}],";
		ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:1}],";
		ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:2}]";
		ret += "]";

		assertEquals(ret, ct.toString());

	}

	@Test
	public void test5() {
		Algorithm target = new FullCombinationAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(1L, "hoge1", Arrays.asList(new String[] {
				"T", "F", "G" })));
		parameters.add(new Parameter(2L, "hoge2", Arrays.asList(new String[] {
				"0", "1" })));

		CombinationList ct = target.generate(new ParameterList(parameters), 0);

		String ret = "[]";

		assertEquals(ret, ct.toString());

	}

	@Test
	public void test6() {
		Algorithm target = new FullCombinationAlgorithm();

		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter(1L, "hoge1", Arrays.asList(new String[] {
				"T", "F", "G" })));
		parameters.add(new Parameter(2L, "hoge2", Arrays.asList(new String[] {
				"0", "1" })));

		CombinationList ct = target.generate(new ParameterList(parameters), 5);

		String ret = "[";
		ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:0}],";
		ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:1}],";
		ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:0}],";
		ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:1}],";
		ret += "[{id:1,name:hoge1,value:G},{id:2,name:hoge2,value:0}]";
		// ret += "[{name:hoge1,value:G},{name:hoge2,value:1},],";
		ret += "]";

		assertEquals(ret, ct.toString());

	}

	@Test
	public void test_readDataFromFile() throws JsonSyntaxException, IOException {
		Algorithm target = new FullCombinationAlgorithm();

		ParameterList parameters = new ParameterFileReader()
				.getParameterList("data/testData.txt");
		assertEquals(5, parameters.getParameters().size());
		assertEquals(96, parameters.getSize());
		CombinationList combinations = target.generate(parameters, -1);
		assertEquals(96, combinations.getCombinations().size());

		System.out.println(combinations);
	}

}

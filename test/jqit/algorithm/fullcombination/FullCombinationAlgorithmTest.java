package jqit.algorithm.fullcombination;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jqict.algorithm.fullcombination.FullCombinationAlgorithm;
import jqict.core.Algorithm;
import jqict.core.CombinationTable;
import jqict.core.Dimension;
import jqict.core.Domain;
import junit.framework.TestCase;

import org.junit.Test;

public class FullCombinationAlgorithmTest  extends TestCase {

	@Test
	public void test0(){
		Algorithm target = new FullCombinationAlgorithm();
		
		List<Dimension> dimensions = new ArrayList<Dimension>();
		dimensions.add(new Dimension("hoge1", Arrays.asList(new String[] { "T", "F"})));
		
		Domain domain = new Domain(dimensions);
		
		CombinationTable ct = target.generate(domain);
		String ret = "[";
		ret += "[{name:hoge1,value:T},],";
		ret += "[{name:hoge1,value:F},],";
		ret += "]";
		
		assertEquals(ret, ct.toString());

	}

	@Test
	public void test1(){
		Algorithm target = new FullCombinationAlgorithm();
		
		List<Dimension> dimensions = new ArrayList<Dimension>();
		dimensions.add(new Dimension("hoge1", Arrays.asList(new String[] { "T", "F"})));
		dimensions.add(new Dimension("hoge2", Arrays.asList(new String[] { "0", "1"})));
		
		Domain domain = new Domain(dimensions);
		
		CombinationTable ct = target.generate(domain);
		String ret = "[";
		ret += "[{name:hoge1,value:T},{name:hoge2,value:0},],";
		ret += "[{name:hoge1,value:T},{name:hoge2,value:1},],";
		ret += "[{name:hoge1,value:F},{name:hoge2,value:0},],";
		ret += "[{name:hoge1,value:F},{name:hoge2,value:1},],";
		ret += "]";
		
		assertEquals(ret, ct.toString());

	}

	@Test
	public void test2(){
		Algorithm target = new FullCombinationAlgorithm();
		
		List<Dimension> dimensions = new ArrayList<Dimension>();
		dimensions.add(new Dimension("hoge1", Arrays.asList(new String[] { "T"})));
		dimensions.add(new Dimension("hoge2", Arrays.asList(new String[] { "0", "1"})));
		
		Domain domain = new Domain(dimensions);
		
		CombinationTable ct = target.generate(domain);
		String ret = "[";
		ret += "[{name:hoge1,value:T},{name:hoge2,value:0},],";
		ret += "[{name:hoge1,value:T},{name:hoge2,value:1},],";
		ret += "]";
		
		assertEquals(ret, ct.toString());
	}

	@Test
	public void test3(){
		Algorithm target = new FullCombinationAlgorithm();
		
		List<Dimension> dimensions = new ArrayList<Dimension>();
		dimensions.add(new Dimension("hoge1", Arrays.asList(new String[] { "T", "F"})));
		dimensions.add(new Dimension("hoge2", Arrays.asList(new String[] { "0"})));
		
		Domain domain = new Domain(dimensions);
		
		CombinationTable ct = target.generate(domain);
		String ret = "[";
		ret += "[{name:hoge1,value:T},{name:hoge2,value:0},],";
		ret += "[{name:hoge1,value:F},{name:hoge2,value:0},],";
		ret += "]";
		
		assertEquals(ret, ct.toString());
	}

	@Test
	public void test4(){
		Algorithm target = new FullCombinationAlgorithm();
		
		List<Dimension> dimensions = new ArrayList<Dimension>();
		dimensions.add(new Dimension("hoge1", Arrays.asList(new String[] { "T", "F"})));
		dimensions.add(new Dimension("hoge2", Arrays.asList(new String[] { "0", "1", "2"})));
		
		Domain domain = new Domain(dimensions);
		
		CombinationTable ct = target.generate(domain);
		String ret = "[";
		ret += "[{name:hoge1,value:T},{name:hoge2,value:0},],";
		ret += "[{name:hoge1,value:T},{name:hoge2,value:1},],";
		ret += "[{name:hoge1,value:T},{name:hoge2,value:2},],";
		ret += "[{name:hoge1,value:F},{name:hoge2,value:0},],";
		ret += "[{name:hoge1,value:F},{name:hoge2,value:1},],";
		ret += "[{name:hoge1,value:F},{name:hoge2,value:2},],";
		ret += "]";
		
		assertEquals(ret, ct.toString());

	}

	@Test
	public void test5(){
		Algorithm target = new FullCombinationAlgorithm();
		
		List<Dimension> dimensions = new ArrayList<Dimension>();
		dimensions.add(new Dimension("hoge1", Arrays.asList(new String[] { "T", "F", "G"})));
		dimensions.add(new Dimension("hoge2", Arrays.asList(new String[] { "0", "1"})));
		
		Domain domain = new Domain(dimensions);
		
		CombinationTable ct = target.generate(domain);
		String ret = "[";
		ret += "[{name:hoge1,value:T},{name:hoge2,value:0},],";
		ret += "[{name:hoge1,value:T},{name:hoge2,value:1},],";
		ret += "[{name:hoge1,value:F},{name:hoge2,value:0},],";
		ret += "[{name:hoge1,value:F},{name:hoge2,value:1},],";
		ret += "[{name:hoge1,value:G},{name:hoge2,value:0},],";
		ret += "[{name:hoge1,value:G},{name:hoge2,value:1},],";
		ret += "]";
		
		assertEquals(ret, ct.toString());

	}

	
}

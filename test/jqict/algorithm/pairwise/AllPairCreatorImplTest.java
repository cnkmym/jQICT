package jqict.algorithm.pairwise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jqict.core.Parameter;
import junit.framework.TestCase;

import org.junit.Test;

public class AllPairCreatorImplTest  extends TestCase {

	@Test
	public void test1(){
		AllPairCreator creator = new AllPairCreatorImpl();
		
		List<Parameter> dimensions = new ArrayList<Parameter>();
		dimensions.add(new Parameter("hoge1", Arrays.asList(new String[] { "T", "F"})));
		dimensions.add(new Parameter("hoge2", Arrays.asList(new String[] { "0", "1"})));
		
		List<CombinationPair> rets = creator.generate(dimensions);
		
		assertEquals(4, rets.size());
		assertEquals("T", rets.get(0).getFirst().getParameterValue());
		assertEquals("0", rets.get(0).getSecond().getParameterValue());
		assertEquals("T", rets.get(1).getFirst().getParameterValue());
		assertEquals("1", rets.get(1).getSecond().getParameterValue());
		assertEquals("F", rets.get(2).getFirst().getParameterValue());
		assertEquals("0", rets.get(2).getSecond().getParameterValue());
		assertEquals("F", rets.get(3).getFirst().getParameterValue());
		assertEquals("1", rets.get(3).getSecond().getParameterValue());

	}
	
	@Test
	public void test2(){
		AllPairCreator creator = new AllPairCreatorImpl();
		
		List<Parameter> dimensions = new ArrayList<Parameter>();
		dimensions.add(new Parameter("hoge1", Arrays.asList(new String[] { "T", "F"})));
		dimensions.add(new Parameter("hoge2", Arrays.asList(new String[] { "0", "1"})));
		dimensions.add(new Parameter("hoge2", Arrays.asList(new String[] { "q", "w"})));
		
		List<CombinationPair> rets = creator.generate(dimensions);
		
		assertEquals(12, rets.size());
		assertEquals("T", rets.get(0).getFirst().getParameterValue());
		assertEquals("0", rets.get(0).getSecond().getParameterValue());
		
		assertEquals("T", rets.get(1).getFirst().getParameterValue());
		assertEquals("1", rets.get(1).getSecond().getParameterValue());
		
		assertEquals("F", rets.get(2).getFirst().getParameterValue());
		assertEquals("0", rets.get(2).getSecond().getParameterValue());
		
		assertEquals("F", rets.get(3).getFirst().getParameterValue());
		assertEquals("1", rets.get(3).getSecond().getParameterValue());

		assertEquals("T", rets.get(4).getFirst().getParameterValue());
		assertEquals("q", rets.get(4).getSecond().getParameterValue());

		assertEquals("T", rets.get(5).getFirst().getParameterValue());
		assertEquals("w", rets.get(5).getSecond().getParameterValue());

		assertEquals("F", rets.get(6).getFirst().getParameterValue());
		assertEquals("q", rets.get(6).getSecond().getParameterValue());
		
		assertEquals("F", rets.get(7).getFirst().getParameterValue());
		assertEquals("w", rets.get(7).getSecond().getParameterValue());

		assertEquals("0", rets.get(8).getFirst().getParameterValue());
		assertEquals("q", rets.get(8).getSecond().getParameterValue());
		
		assertEquals("0", rets.get(9).getFirst().getParameterValue());
		assertEquals("w", rets.get(9).getSecond().getParameterValue());
	
		assertEquals("1", rets.get(10).getFirst().getParameterValue());
		assertEquals("q", rets.get(10).getSecond().getParameterValue());

		assertEquals("1", rets.get(11).getFirst().getParameterValue());
		assertEquals("w", rets.get(11).getSecond().getParameterValue());
	}
	

	@Test
	public void test3(){
		AllPairCreator creator = new AllPairCreatorImpl();
		
		List<Parameter> dimensions = new ArrayList<Parameter>();
		dimensions.add(new Parameter("hoge1", Arrays.asList(new String[] { "T"})));
		dimensions.add(new Parameter("hoge2", Arrays.asList(new String[] { "0", "1"})));
		
		List<CombinationPair> rets = creator.generate(dimensions);
		
		assertEquals(2, rets.size());
		assertEquals("T", rets.get(0).getFirst().getParameterValue());
		assertEquals("0", rets.get(0).getSecond().getParameterValue());
		assertEquals("T", rets.get(1).getFirst().getParameterValue());
		assertEquals("1", rets.get(1).getSecond().getParameterValue());

	}

	@Test
	public void test4(){
		AllPairCreator creator = new AllPairCreatorImpl();
		
		List<Parameter> dimensions = new ArrayList<Parameter>();
		dimensions.add(new Parameter("hoge1", Arrays.asList(new String[] { "T", "F"})));
		dimensions.add(new Parameter("hoge2", Arrays.asList(new String[] { "0"})));
		
		List<CombinationPair> rets = creator.generate(dimensions);
		
		assertEquals(2, rets.size());
		assertEquals("T", rets.get(0).getFirst().getParameterValue());
		assertEquals("0", rets.get(0).getSecond().getParameterValue());
		assertEquals("F", rets.get(1).getFirst().getParameterValue());
		assertEquals("0", rets.get(1).getSecond().getParameterValue());

	}



	
}

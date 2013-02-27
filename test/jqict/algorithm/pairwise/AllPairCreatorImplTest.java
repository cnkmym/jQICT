package jqict.algorithm.pairwise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jqict.core.Dimension;
import junit.framework.TestCase;

import org.junit.Test;

public class AllPairCreatorImplTest  extends TestCase {

	@Test
	public void test1(){
		AllPairCreator creator = new AllPairCreatorImpl();
		
		List<Dimension> dimensions = new ArrayList<Dimension>();
		dimensions.add(new Dimension("hoge1", Arrays.asList(new String[] { "T", "F"})));
		dimensions.add(new Dimension("hoge2", Arrays.asList(new String[] { "0", "1"})));
		
		List<CombinationPair> rets = creator.generate(dimensions);
		
		assertEquals(4, rets.size());
		assertEquals("T", rets.get(0).getFirst().getValue());
		assertEquals("0", rets.get(0).getSecond().getValue());
		assertEquals("T", rets.get(1).getFirst().getValue());
		assertEquals("1", rets.get(1).getSecond().getValue());
		assertEquals("F", rets.get(2).getFirst().getValue());
		assertEquals("0", rets.get(2).getSecond().getValue());
		assertEquals("F", rets.get(3).getFirst().getValue());
		assertEquals("1", rets.get(3).getSecond().getValue());

	}
	
	@Test
	public void test2(){
		AllPairCreator creator = new AllPairCreatorImpl();
		
		List<Dimension> dimensions = new ArrayList<Dimension>();
		dimensions.add(new Dimension("hoge1", Arrays.asList(new String[] { "T", "F"})));
		dimensions.add(new Dimension("hoge2", Arrays.asList(new String[] { "0", "1"})));
		dimensions.add(new Dimension("hoge2", Arrays.asList(new String[] { "q", "w"})));
		
		List<CombinationPair> rets = creator.generate(dimensions);
		
		assertEquals(12, rets.size());
		assertEquals("T", rets.get(0).getFirst().getValue());
		assertEquals("0", rets.get(0).getSecond().getValue());
		
		assertEquals("T", rets.get(1).getFirst().getValue());
		assertEquals("1", rets.get(1).getSecond().getValue());
		
		assertEquals("F", rets.get(2).getFirst().getValue());
		assertEquals("0", rets.get(2).getSecond().getValue());
		
		assertEquals("F", rets.get(3).getFirst().getValue());
		assertEquals("1", rets.get(3).getSecond().getValue());

		assertEquals("T", rets.get(4).getFirst().getValue());
		assertEquals("q", rets.get(4).getSecond().getValue());

		assertEquals("T", rets.get(5).getFirst().getValue());
		assertEquals("w", rets.get(5).getSecond().getValue());

		assertEquals("F", rets.get(6).getFirst().getValue());
		assertEquals("q", rets.get(6).getSecond().getValue());
		
		assertEquals("F", rets.get(7).getFirst().getValue());
		assertEquals("w", rets.get(7).getSecond().getValue());

		assertEquals("0", rets.get(8).getFirst().getValue());
		assertEquals("q", rets.get(8).getSecond().getValue());
		
		assertEquals("0", rets.get(9).getFirst().getValue());
		assertEquals("w", rets.get(9).getSecond().getValue());
	
		assertEquals("1", rets.get(10).getFirst().getValue());
		assertEquals("q", rets.get(10).getSecond().getValue());

		assertEquals("1", rets.get(11).getFirst().getValue());
		assertEquals("w", rets.get(11).getSecond().getValue());
	}
	

	@Test
	public void test3(){
		AllPairCreator creator = new AllPairCreatorImpl();
		
		List<Dimension> dimensions = new ArrayList<Dimension>();
		dimensions.add(new Dimension("hoge1", Arrays.asList(new String[] { "T"})));
		dimensions.add(new Dimension("hoge2", Arrays.asList(new String[] { "0", "1"})));
		
		List<CombinationPair> rets = creator.generate(dimensions);
		
		assertEquals(2, rets.size());
		assertEquals("T", rets.get(0).getFirst().getValue());
		assertEquals("0", rets.get(0).getSecond().getValue());
		assertEquals("T", rets.get(1).getFirst().getValue());
		assertEquals("1", rets.get(1).getSecond().getValue());

	}

	@Test
	public void test4(){
		AllPairCreator creator = new AllPairCreatorImpl();
		
		List<Dimension> dimensions = new ArrayList<Dimension>();
		dimensions.add(new Dimension("hoge1", Arrays.asList(new String[] { "T", "F"})));
		dimensions.add(new Dimension("hoge2", Arrays.asList(new String[] { "0"})));
		
		List<CombinationPair> rets = creator.generate(dimensions);
		
		assertEquals(2, rets.size());
		assertEquals("T", rets.get(0).getFirst().getValue());
		assertEquals("0", rets.get(0).getSecond().getValue());
		assertEquals("F", rets.get(1).getFirst().getValue());
		assertEquals("0", rets.get(1).getSecond().getValue());

	}



	
}

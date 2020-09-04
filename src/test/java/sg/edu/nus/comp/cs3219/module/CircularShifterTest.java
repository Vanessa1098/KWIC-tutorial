package sg.edu.nus.comp.cs3219.module;

import org.junit.Before;
import org.junit.Test;
import sg.edu.nus.comp.cs3219.model.LineStorage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CircularShifterTest {
	LineStorage inputLineStorage;
	LineStorage afterShiftLineStorage;
	CircularShifter shifter;

	@Before
	public void setUp() {
		inputLineStorage = new LineStorage();
		afterShiftLineStorage = new LineStorage();
		shifter = new CircularShifter(afterShiftLineStorage);
		Set<String> words = new HashSet<>();
		words.add("the");
		words.add("after");
		shifter.setIgnoreWords(words);
		inputLineStorage.addObserver(shifter);
	}

	@Test
	public void test() {
		inputLineStorage.addLine("The Day after Tomorrow");
		assertEquals(2, afterShiftLineStorage.size());

		assertEquals("Day after Tomorrow the", afterShiftLineStorage.get(0).toString());
		assertEquals("Tomorrow the Day after", afterShiftLineStorage.get(1).toString());
	}

	@Test
	public void test1() {
		//TODO: Write testing code here
		inputLineStorage.addLine("Avenger: Infinity War");
		Iterator<String> it = shifter.getIgnoreWords().iterator();
		while(it.hasNext()) {
			assertEquals(inputLineStorage.get(0).toString().contains(it.next()), false);
		}
	}

	@Test
	public void test2() {
		//TODO: Write testing code here
		inputLineStorage.addLine("The Day after Tomorrow");
		Iterator<String> it = shifter.getIgnoreWords().iterator();
		while(it.hasNext()) {
			assertEquals(inputLineStorage.get(0).toString().contains(it.next()), true);
		}
	}

}

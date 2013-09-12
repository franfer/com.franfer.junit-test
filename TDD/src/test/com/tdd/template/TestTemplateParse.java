package com.tdd.template;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTemplateParse {

	public TestTemplateParse() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void emptyTemplateRendersAsEmptyString() throws Exception {
		List<String> segments = parse("");
		assertSegments(segments, "");
		
	}
	
	@Test
	public void templateWithOnlyPlainText() throws Exception {
		List<String> segments = parse("plain text only");
		assertSegments(segments, "plain text only");
		
	}
	
	@Test
	public void parsingMultipleVariables() throws Exception {
		List<String> segments = parse("${a}:${b}:${c}");
		assertSegments(segments, "${a}", ":", "${b}", ":", "${c}");
	}
	
	private List<String> parse(String template) {
		return new TemplateParse().parse(template);
	}
	
	private void assertSegments(List<? extends Object> 
	actual, Object... expected) {
		assertEquals("Number of segments doesn't match.", 
				expected.length, actual.size());
		assertEquals(Arrays.asList(expected), actual);
	}
}

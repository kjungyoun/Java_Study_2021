package com.ssafy.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherDAO {
	private List<Weather> list = new ArrayList<Weather>(20);
	
	public List<Weather> getWeatherList(String url){
		list.removeAll(list);
		connectXML(url);
		return list;
	}

	private void connectXML(String url) {
		SAXParserFactory fac = SAXParserFactory.newInstance();
		try {
			SAXParser parser = fac.newSAXParser();
			SaxHandler handler = new SaxHandler();
			parser.parse(new URL(url).openConnection().getInputStream(), handler);
		} catch (Exception e) {
			throw new RuntimeException("날씨 정보를 전송 받는 중 오류 발생");
		}
		
	}
	
	public class SaxHandler extends DefaultHandler{
		String temp;
		Weather w;
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if(qName.equals("data")) {
				w = new Weather();
			}
		}
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			temp = new String(ch,start,length);
		}
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(qName.equals("hour")) {
				w.setHour(temp);
			}else if(qName.equals("temp")) {
				w.setTemp(temp);
			}else if(qName.equals("wfKor")) {
				w.setWfKor(temp);
			}else if(qName.equals("reh")) {
				w.setReh(temp);
			}else if(qName.equals("data")) {
				list.add(w);
			}
		}
	}
}

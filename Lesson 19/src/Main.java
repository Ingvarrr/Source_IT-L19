/**
 * Created by vig on 12/16/16.
 */
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        String path = "Lesson 19/src/staff.xml";
        DefaultHandler handler = new MyHandler();
        saxParser.parse(path, new MyHandler());

    }
    public static class MyHandler extends DefaultHandler{

        Staff buff = null;
        List<Staff> staffs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            String out = qName + " " +attributes.getLength();
            System.out.println(out);
            sb = new StringBuilder();

            if (qName.equals("staff")){
                buff = new Staff();
            }
            for (int i = 0; i < attributes.getLength(); i++) {


                if (attributes.getQName(i).equalsIgnoreCase("isRegular")) {
                    buff.setRegular(Boolean.valueOf(attributes.getValue(i)));
                    System.out.println("salary is regular = " + Boolean.valueOf(attributes.getValue(i)));
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            char [] result = new char[length];
            for (int i = 0; i <length ; i++) {
                result[i] = ch[start + i];
            }
            String str = new String(result);
            sb.append(str);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if(qName.equalsIgnoreCase("firstname")){
                buff.setFirstName(sb.toString());
            }
            if(qName.equalsIgnoreCase("lastname")){
                buff.setLastName(sb.toString());
            }
            if(qName.equalsIgnoreCase("salary")){
                buff.setSallaryValue(Integer.parseInt(sb.toString()));
            }
            /*if (qName.equals("staff")){
                buff = new Staff();
            }*/
            if(qName.equals("staff")) {
                staffs.add(buff);
            }

            System.out.println("VALUE " + sb.toString().trim());
            sb = new StringBuilder();
            String out = "END " + qName;
            System.out.println(out);
        }


    }
}

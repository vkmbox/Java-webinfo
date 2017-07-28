package vkmbox.webinfo.cbr;

import ru.cbr.web.DailyInfo;
import ru.cbr.web.DailyInfoSoap;
import ru.cbr.web.EnumValutesXMLResponse.EnumValutesXMLResult;
import vkmbox.webinfo.util.XmlConverter;

import java.time.LocalDate;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;

public class ExchRateDaily {
  public static void main (String ... args) {
    DailyInfo service = new DailyInfo();
    DailyInfoSoap port = service.getDailyInfoSoap();
    
    XMLGregorianCalendar onDate = null;
    try {
      onDate = XmlConverter.getXMLGregorianCalendar(LocalDate.now());
    } catch (DatatypeConfigurationException ex) {
      ex.printStackTrace();
    }
 
    EnumValutesXMLResult en = port.enumValutesXML(false);
    ExchRateParser.parseEnumValutes(en);
    System.out.println("Count:"+en.getContent().size());
    
  /*GetCursOnDateResult curs = port.getCursOnDate(onDate);  
 
  onDate =port.getLatestDateTime();
  GetCursOnDateXMLResult result = port.getCursOnDateXML(onDate);
  Valute list = null;
 
  try{  
   list = GetCursOnDateResultParser.getValuteByValuteCh("USD", result);
  } catch (Exception e){
 
  }  
  System.out.println(list.curs);  
 
  try{  
   list = GetCursOnDateResultParser.getValuteByValuteCode("840", result);
  } catch (Exception e){
 
  }  
  System.out.println(list.curs);*/
    
    System.out.println("Hello, world");
  }
}